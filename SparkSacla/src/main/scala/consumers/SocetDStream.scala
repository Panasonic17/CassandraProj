package consumers
import org.apache.spark.streaming.StreamingContext

object SocetDStream extends DStreamSource {
   def getDStream(streamingContext: StreamingContext) = {
     streamingContext.socketTextStream("localhost", 4444)
   }
}
