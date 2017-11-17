import consumers.SocetDStream
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import com.datastax.spark.connector._
import org.apache.spark.sql.cassandra._

object App {
  def main(args: Array[String]): Unit = {

    val cassandraHost = "127.0.0.1"
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[4]").set("spark.cassandra.connection.host", cassandraHost))
    val ssc = new StreamingContext(sc, Seconds(2))

    var dataSource = SocetDStream.getDStream(ssc)

    dataSource.map(a => {
      println(a)
    }).count().print()

    ssc.start() // Start the computation
    ssc.awaitTermination()
  }
}
