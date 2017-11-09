

import Convertors.ConvertorFromJsonToCSV;
import Convertors.JsonConvertorToCSVFromYoutube;
import Convertors.JsonConvertorToCSVFromYoutubeVideos;
import com.satori.rtm.*;
import com.satori.rtm.model.*;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.parser.ParseException;

public class SubscribeToOpenChannel {
    static final String endpoint = "wss://open-data.api.satori.com";
    static final String appkey = "9fbd1c4BEa889C66cFf83B042B0fDCed";
    static String channel = "youtube-videos";
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final ConvertorFromJsonToCSV convertor;
        if (channel.equals("youtube-videos"))
            convertor = new JsonConvertorToCSVFromYoutubeVideos();
        else
            convertor = new JsonConvertorToCSVFromYoutube();
        JsonConvertorToCSVFromYoutubeVideos convert = new JsonConvertorToCSVFromYoutubeVideos();
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
                    ProducerRecord<String, String> youtube = null;
                    try {
                        youtube = new ProducerRecord<String, String>(
                                "youtube", "youtube", convertor.convert(json.toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

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