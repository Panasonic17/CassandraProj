import consumers.SocetDStream
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import parsers.PraseVideoFromSatoriJson

object App {
  def main(args: Array[String]): Unit = {
    val cassandraHost = "172.20.0.2"
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[*]").set("spark.cassandra.connection.host", "172.20.0.2"))
    val ssc = new StreamingContext(sc, Seconds(1))
    var dataSource = SocetDStream.getDStream(ssc)
    dataSource.map(row=> {
      print(row);
//      PraseVideoFromSatoriJson.parceVideoJson(row)
    }).count()
    ssc.start() // Start the computation
    ssc.awaitTermination()
  }
}
