package Consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * Created by Oleksandr_Shainoga on 11/3/2017.
 */
public class SocetDSStream implements DStream {


    @Override
    public JavaInputDStream getDSSteam(JavaStreamingContext jsc) {
        JavaInputDStream DSStream = jsc.socketTextStream("127.0.0.1", 4444);
        return DSStream;
    }
}
