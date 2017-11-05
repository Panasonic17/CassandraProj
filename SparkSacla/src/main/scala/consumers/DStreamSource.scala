package consumers

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.DStream

trait DStreamSource {

  def getDStream(streamingContext:StreamingContext): DStream[String]

}
