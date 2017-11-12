package dataGen;

import java.util.Arrays;
import java.util.Random;

public class PurchaseGenerator  implements ValueGenerator{

    double partOfLoginedConsumers=0.7;
    int countOfProducts=1000;
    int countOfCounsumers=1000;

    public PurchaseGenerator(double partOfLoginedConsumers, int countOfProducts, int countOfCounsumers) {
        this.partOfLoginedConsumers = partOfLoginedConsumers;
        this.countOfProducts = countOfProducts;
        this.countOfCounsumers = countOfCounsumers;
    }

    public PurchaseGenerator() {
    }

    Random r=new Random();

    @Override
    public String generate() {
        int consumerID =r.nextDouble() < partOfLoginedConsumers ? r.nextInt(countOfCounsumers) : 0;
        int[] products=new int[r.nextInt(10)+1];
        for (int i = 0; i <products.length ; i++) {
            products[i]=r.nextInt(1000);
        }
        int price=10;
        return ""+consumerID+","+ Arrays.toString(products)+","+price;
    }
}
