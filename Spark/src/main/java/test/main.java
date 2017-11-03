package test;


import Consumers.SocetDSStream;
import com.datastax.spark.connector.japi.rdd.CassandraJavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;



public class main {

    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("youtube");

        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        JavaInputDStream<String>  dStream =new SocetDSStream().getDSSteam(jssc);

        JavaDStream<String> words = dStream;
        words.foreachRDD(a->{
            System.out.println("Strat RDD");
            a.foreach(a1-> System.out.println(a1));
            System.out.println("End RDD");
        } );

        jssc.start();
        jssc.awaitTermination();
    }
}
