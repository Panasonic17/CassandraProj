

import com.satori.rtm.*;
import com.satori.rtm.model.*;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SubscribeToOpenChannel {
    static final String endpoint = "wss://open-data.api.satori.com";
    static final String appkey = "9fbd1c4BEa889C66cFf83B042B0fDCed";
    static final String channel = "youtube-videos";
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {


        final RtmClient client = new RtmClientBuilder(endpoint, appkey)
                .setListener(new RtmClientAdapter() {
                    @Override
                    public void onEnterConnected(RtmClient client) {
                        System.out.println("Connected to Satori RTM!");
                    }
                })
                .build();

        final Producer<String, String> producer = new KafkaProd().getProduser();

        SubscriptionAdapter listener = new SubscriptionAdapter() {
            @Override
            public void onSubscriptionData(SubscriptionData data) {
                for (AnyJson json : data.getMessages()) {
                    ProducerRecord<String, String> youtube = new ProducerRecord<String, String>(
                            "youtube", "youtube", json.toString());

                    i++;
                    if (i >= 1000) {
                        System.out.println("send " + i);
                        i = 0;
                    }
                    producer.send(youtube);
                }
            }
        };

        client.createSubscription(channel, SubscriptionMode.SIMPLE, listener);
        System.out.println("started");
        client.start();
    }
}