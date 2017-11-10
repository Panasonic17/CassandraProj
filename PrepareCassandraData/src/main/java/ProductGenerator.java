import com.datastax.driver.core.BoundStatement;
        import com.datastax.driver.core.Cluster;
        import com.datastax.driver.core.PreparedStatement;
        import com.datastax.driver.core.Session;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
        import java.util.Random;

public class ProductGenerator {
    Cluster cluster;
    Random r=new Random();
    public ProductGenerator(Cluster cluster) {
        this.cluster = cluster;
    }
    public void generate(int i) throws IOException {
        Session session = cluster.connect("market");
        PreparedStatement statement = session.prepare("INSERT INTO products" + "(product_id, name,price)" + "VALUES (?,?,?);");
        BoundStatement boundStatement = new BoundStatement(statement);
        for (int j = 0; j <=i ; j++)
            session.execute(boundStatement.bind(j,"product-"+j,(int)Math.abs(r.nextGaussian()*100*r.nextGaussian()*1000)));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("priceList.csv"))) {
            for (int j = 0; j <=i ; j++)
            bw.write(j+","+Math.abs(r.nextGaussian()*100*r.nextGaussian()*1000)+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
