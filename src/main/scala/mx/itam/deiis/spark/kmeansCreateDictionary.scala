package mx.itam.deiis.spark

import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.ObjectOutputStream

import scala.Array.canBuildFrom

import org.apache.spark.SparkContext
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.clustering.KMeansModel

class kmeansCreateDictionary {

  val sc = new SparkContext("local", "kmeans_spark", "E:\\MCC\\Semester 4\\IIS\\Workspace\\VPProject\\target\\dependency")
  // master, appName, sparkHome, jars required
  val maxIter = 50
  var id = 0

  def createDictionary(k: Int, sourceFile: String, outFile: String, objectFile: String) {

    //read data .sift
    val data = sc.textFile(sourceFile)
    val parsedData = data.map(_.split(',').map(_.toDouble))

    var bw = new BufferedWriter(new FileWriter(outFile))

    //create kmeans model
    val kmModel: KMeansModel = KMeans.train(parsedData, k, maxIter)

    //get cluster centers i.e. centroids, that correspond to the dictionary
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
    sc.stop();

  }

}