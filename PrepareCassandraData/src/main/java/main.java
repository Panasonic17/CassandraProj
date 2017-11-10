import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Cluster cluster;
        Session session;
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
//        session = cluster.connect("market");
        CousumerGenerator cousumerGenerator=new CousumerGenerator(cluster);
        cousumerGenerator.generate(100);
        ProductGenerator productGenerator=new ProductGenerator(cluster);
        productGenerator.generate(100);
        cluster.close();

    }
}
