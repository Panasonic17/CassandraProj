import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by Oleksandr_Shainoga on 11/6/2017.
 */
public class main {
    public static void main(String[] args) {
        try {
            Cluster cluster = Cluster.builder().addContactPoint("172.20.0.1").withPort(9042).build();
            Session session = cluster.connect("demo");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            Cluster cluster = Cluster.builder().addContactPoint("172.20.0.2").build();
            Session session = cluster.connect("demo");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
