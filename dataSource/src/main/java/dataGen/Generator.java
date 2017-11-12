package dataGen;

import Transformers.PurchaseToKafkaTransformer;
import Transformers.PurchaseToSocetTransformer;
import Transformers.Transformer;
import sender.DataSender;
import sender.KafkaSender;
import sender.SocketSender;

public class Generator {
    DataSender dataSender;
    PurchaseGenerator purchaseGenerator;
    Transformer purcheTransformer;

    public Generator(String mode) {
        if(mode.equals("kafka")){
             dataSender=new KafkaSender();
             purchaseGenerator=new PurchaseGenerator();
             purcheTransformer=new PurchaseToKafkaTransformer();
        }
        else{
             dataSender=new SocketSender();
             purchaseGenerator=new PurchaseGenerator();
             purcheTransformer=new PurchaseToSocetTransformer();
        }
    }

    public void generate(){
        while(true){
          String  purchase= purchaseGenerator.generate();
          dataSender.send(purcheTransformer.transform(purchase));
        }
    }
}
