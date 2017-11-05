package test

import com.datastax.spark.connector.cql.CassandraConnector
import consumers.{DStreamSource, SocetDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

object test {
  def main(args: Array[String]): Unit = {
    val cassandraHost = "172.20.0.2"
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[*]").set("spark.cassandra.connection.host", "172.20.0.2"))

    //    sc.cassandraTable("youtube", "video_statistics").select("id").count()

    val ssc = new StreamingContext(sc, Seconds(1))
    var dataSource = SocetDStream.getDStream(ssc)
    val lines = dataSource
    lines.print()
    ssc.start() // Start the computation
    ssc.awaitTermination()
    // Print the first ten elements of each RDD generated in this DStream to the console

    //      sc.textFile("testDataSet.txt")
    //         .flatMap(line => line.split(" "))
    //         .map(word => (word, 1)).reduceByKey(_ + _)
    //

  }
}
