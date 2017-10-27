package test;


import com.datastax.driver.core.*;

public class main {
    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("cassandra-1").build();
        Session session = cluster.connect("demo");
        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
        ResultSet results = session.execute("SELECT * FROM users WHERE lastname='Jones'");
        for (Row row : results) {
            System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
        }
        cluster.close();
    }
}
