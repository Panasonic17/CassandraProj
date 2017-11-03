package Consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * Created by Oleksandr_Shainoga on 11/3/2017.
 */
public interface DStream {
    public JavaDStream getDSSteam(JavaStreamingContext jsc);
}
