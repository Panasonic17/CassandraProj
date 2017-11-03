import com.satori.rtm.*;
import com.satori.rtm.model.AnyJson;
import com.satori.rtm.model.SubscriptionData;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Oleksandr_Shainoga on 11/3/2017.
 */
public class TestDataGenerator {
    static final String endpoint = "wss://open-data.api.satori.com";
    static final String appkey = "9fbd1c4BEa889C66cFf83B042B0fDCed";
    static final String channel = "youtube-videos";
    static int i = 0;
static int  rowCount=5000;

    private static final String FILENAME = "testDataSet.txt";
    static String[] data1 = new String[rowCount];

    public static void main(String[] args) throws InterruptedException {


        final RtmClient client = new RtmClientBuilder(endpoint, appkey)
                .setListener(new RtmClientAdapter() {
                    @Override
                    public void onEnterConnected(RtmClient client) {
                        System.out.println("Connected to Satori RTM!");
                    }
                })
                .build();

//        final Producer<String, String> producer = new KafkaProd().getProduser();

        SubscriptionAdapter listener = new SubscriptionAdapter() {
            @Override
            public void onSubscriptionData(SubscriptionData data) {
                for (AnyJson json : data.getMessages()) {
                    ProducerRecord<String, String> youtube = new ProducerRecord<String, String>(
                            "youtube", "youtube", json.toString());

                    data1[i] = youtube.value();
                    i++;
                    if (i >= rowCount) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
                            for (String s: data1 ) {
                                bw.write(s + '\n');
                            }
                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                        System.exit(0);
                        //  i = 0;
                    }
//                    System.out.println("send " + i);
//                    producer.send(youtube);
                }
            }
        };

        client.createSubscription(channel, SubscriptionMode.SIMPLE, listener);
        System.out.println("started");
        client.start();
    }
}