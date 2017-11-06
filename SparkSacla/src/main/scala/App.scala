import consumers.SocetDStream
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import parsers.{CSVToVideo, PraseVideoFromSatoriJson}
import com.datastax.spark.connector._
import org.apache.spark.sql.cassandra._

object App {
  def main(args: Array[String]): Unit = {
    val cassandraHost = "172.20.0.1"
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[*]").set("spark.cassandra.connection.host", cassandraHost))
    val ssc = new StreamingContext(sc, Seconds(1))
    var dataSource = SocetDStream.getDStream(ssc)

  dataSource.map(row=>CSVToVideo.parce(row)).foreachRDD(rdd => {
    rdd.saveToCassandra("yputube", "video_statistics", SomeColumns("id", "title"))
  })
    ssc.start() // Start the computation
    ssc.awaitTermination()
  }
}

//val description = snippet.get("description").toString.trim.replace("\n", "")
////        System.out.println(description);
//row.append(jsonObject.get("id") + ",")
//row.append(stat.get("like_count") + ",")
//row.append(stat.get("dislike_count") + ",")
//row.append(stat.get("view_count") + ",")
//row.append(snippet.get("published_at") + ",")
//row.append(snippet.get("title").toString.trim.replace("\n", "") + ",")
//row.append(description + ",")
//row.append(snippet.get("channel_title") + ",")
//row.append(snippet.get("tags"))