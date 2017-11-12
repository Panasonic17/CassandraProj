package Entity;

import java.util.Arrays;

public class Purchase {
    public Purchase(int id, int[] products, int value) {
        this.id = id;
        this.products = products;
        this.value = value;
    }

    public Purchase(String s) {

    }

    int id;
    int[] products;
    int value;

    public String toCSV() {
        return "" + id + "," + products + "," + value;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", products=" + Arrays.toString(products) +
                ", value=" + value +
                '}';
    }
}
