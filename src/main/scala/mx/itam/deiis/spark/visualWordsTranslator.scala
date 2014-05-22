package mx.itam.deiis.spark
import org.apache.spark.SparkContext
import SparkContext._
import org.apache.spark.mllib.clustering.KMeansModel
import java.io._
import scala.Array.canBuildFrom

class visualWordsTranslator {

//spark environment
  val cores = Runtime.getRuntime().availableProcessors()
  val sc = new SparkContext("local[" + cores + "]", "kmeans_spark", "E:\\MCC\\Semester 4\\IIS\\Workspace\\VPProject\\target\\dependency")

  def getVW(sourceFile: String, objectFile: String, outFile:String) {

    //parse data
    val data = sc.textFile(sourceFile)
    val parsedData = data.map(_.split(',').map(_.toDouble))

    //retrieve kmeans model
    val kmIn: FileInputStream = new FileInputStream(objectFile)
    val kmObjIn: ObjectInputStream = new ObjectInputStream(kmIn)
    val kmModel2: KMeansModel = kmObjIn.readObject().asInstanceOf[KMeansModel]

    //make predictions - internally uses knn
    val predData = parsedData.map(x => kmModel2.predict(x))
   //save predictions
    predData.saveAsTextFile(outFile)
/*
    var bw = new BufferedWriter(new FileWriter(outFile))

    //val predDataArray = predData.collect()
    
    for (j <- 0 until predData.collect().length) {
    	//printf("%d ",predData.collect()(j))
        bw.write(predData.collect()(j).toInt.toString)
        bw.write(" ")
     }
    bw.close()
*/
    //finish
    kmObjIn.close()
  }
  
  def close() {
	  sc.stop();
  }
}