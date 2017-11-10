import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import java.io.IOException;

public class CousumerGenerator {
    Cluster cluster;

    public CousumerGenerator(Cluster cluster) {
        this.cluster = cluster;
    }

    public void generate(int i) throws IOException {
        Session session = cluster.connect("market");
        PreparedStatement statement = session.prepare("INSERT INTO consumers" + "(consumer_id, name)" + "VALUES (?,?);");
        BoundStatement boundStatement = new BoundStatement(statement);
        for (int j = 0; j <=i ; j++)
        session.execute(boundStatement.bind(j,"Consumer-"+j));
    }
}
