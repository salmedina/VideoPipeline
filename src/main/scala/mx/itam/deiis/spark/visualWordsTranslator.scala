package mx.itam.deiis.spark
import org.apache.spark.SparkContext
import SparkContext._
import org.apache.spark.mllib.clustering.KMeansModel
import java.io._
import scala.Array.canBuildFrom

class visualWordsTranslator {

  //spark environment
  val sc = new SparkContext("local", "kmeans_spark", "/usr/local/Cellar/spark-0.9.1/")

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

    //finish
    kmObjIn.close()
    sc.stop();
  }

}