package test;


import com.datastax.driver.core.*;

public class main {
    public static void main(String[] args) {
        // 9160
        try {
            Cluster cluster = Cluster.builder().addContactPoint("172.20.0.2").withPort(9160).build();
            Session session = cluster.connect("demo");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        Cluster cluster1 = Cluster.builder().addContactPoint("172.20.0.2").build();
        Session session = cluster1.connect("demo");
//        Session session = cluster.connect("demo");
//        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
//        ResultSet results = session.execute("SELECT * FROM users WHERE lastname='Jones'");
//        for (Row row : results) {
//            System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
//        }
//        cluster.close();

    }
}
