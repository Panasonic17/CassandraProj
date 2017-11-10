package dataGen;

import java.util.Random;

public class PurchaseGenerator extends Thread implements ValueGenerator{
    int dataPerSec=100;
    double partOfLoginedConsumers=0.7;
    int countOfProducts=1000;
    int countOfCounsumers=1000;
    Random r=new Random();
    @Override
    public String generate() {
        int id =r.nextDouble() < partOfLoginedConsumers ? r.nextInt(countOfCounsumers) : 0;
        int[] products=new int[r.nextInt(10)];
        for (int i = 0; i <products.length ; i++) {
            products[i]=r.nextInt(1000);
        }
        int price;
        try {
            Thread.sleep(60/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return
    }
}
