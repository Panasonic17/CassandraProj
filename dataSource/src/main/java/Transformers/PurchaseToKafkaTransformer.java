package Transformers;

import Entity.Purchase;
import org.apache.kafka.clients.producer.ProducerRecord;

public class PurchaseToKafkaTransformer implements Transformer<ProducerRecord, String>{
    @Override
    public ProducerRecord transform(String row) {
        Purchase purchase=new Purchase(row);
       return new ProducerRecord<String, String>("market",purchase.toCSV());
    }
}
