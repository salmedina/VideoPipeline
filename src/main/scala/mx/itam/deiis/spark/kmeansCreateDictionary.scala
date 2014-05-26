package mx.itam.deiis.spark

import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.ObjectOutputStream
import scala.Array.canBuildFrom
import org.apache.spark.SparkContext
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.clustering.KMeansModel
import org.apache.spark.SparkConf

class kmeansCreateDictionary {

  def createDictionary(k: Int, sourceFile: String, outFile: String, objectFile: String) {
    //spark environment
    val usedCores = Runtime.getRuntime().availableProcessors() - 1
    // master, appName, sparkHome, jars required
    val conf = new SparkConf().setMaster("local[" + usedCores + "]").setAppName("kmeans++").set("spark.executor.memory", "2g")
  	val sc = new SparkContext(conf)
	val maxIter = 50
	var id = 0
  
    //read data .sift
    val data = sc.textFile(sourceFile)
    val parsedData = data.map(_.split(',').map(_.toDouble))

    //create kmeans model
    val kmModel: KMeansModel = KMeans.train(parsedData, k, maxIter)

    var bw = new BufferedWriter(new FileWriter(outFile))
    //get centroids, that correspond to the dictionary
    //println("Total clusters: " + kmModel.clusterCenters.length)
    kmModel.clusterCenters.foreach { c =>
      //printf("%d : ", id)
      id = id + 1
      for (j <- 0 until c.length) {
        //printf("%.2f ", c(j))
        bw.write(c(j).toInt.toString)
        bw.write(" ")
      }
      bw.write("\n")
      //println();
    }
    bw.close()

    //print kmeans object model
    val kmOut: FileOutputStream = new FileOutputStream(objectFile)
    val kmObjOut: ObjectOutputStream = new ObjectOutputStream(kmOut)
    kmObjOut.writeObject(kmModel)

    //finish
    kmObjOut.close()
    sc.clearJars();
    sc.clearFiles();    
    sc.stop();
  }
}