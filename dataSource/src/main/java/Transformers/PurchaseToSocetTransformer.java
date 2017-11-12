package Transformers;

public class PurchaseToSocetTransformer implements Transformer<String,String> {
    @Override
    public String transform(String row) {
        return row;
    }
}
