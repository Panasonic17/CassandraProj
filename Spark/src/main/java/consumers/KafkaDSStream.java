package consumers;

//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.spark.streaming.api.java.JavaDStream;
//import org.apache.spark.streaming.api.java.JavaInputDStream;
//import org.apache.spark.streaming.api.java.JavaStreamingContext;
//import org.apache.spark.streaming.kafka010.ConsumerStrategies;
//import org.apache.spark.streaming.kafka010.KafkaUtils;
//import org.apache.spark.streaming.kafka010.LocationStrategies;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksandr_Shainoga on 11/3/2017.
 */
public class KafkaDSStream implements DStream {
//    @Override
//    public JavaDStream getDSSteam(JavaStreamingContext jsc) {
//        Map<String, Object> kafkaParams = new HashMap<>();
//        kafkaParams.put("bootstrap.servers", "localhost:9092");
//        kafkaParams.put("key.deserializer", StringDeserializer.class);
//        kafkaParams.put("value.deserializer", StringDeserializer.class);
//        kafkaParams.put("zookeeper", "172.18.0.2:2181");
////       kafkaParams.put("group.id", "youtube");
//        kafkaParams.put("auto.offset.reset", "latest");
//        kafkaParams.put("enable.auto.commit", false);
//        Collection<String> topics = Arrays.asList("youtube");
//        JavaInputDStream DSStream =
//                KafkaUtils.createDirectStream(
//                        jsc,
//                        LocationStrategies.PreferConsistent(),
//                        ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
//                );
//          return  DSStream.flatMap(x -> Arrays.asList(x).iterator());
//
//    }
}
