package test;


import com.datastax.driver.core.*;

public class main {
    public static void main(String[] args) {

        Cluster cluster1 = Cluster.builder().addContactPoint("172.20.0.2").build();
        Session session = cluster1.connect("youtube");

        session.execute("INSERT INTO video_statistics (id,published_at,title,description,channel_title,view_count,like_count,dislike_count) VALUES ('id','published_at','title','description','channel_title',1,2,3)");
        ResultSet results = session.execute("SELECT * FROM users WHERE id='id'");
        for (Row row : results) {
            System.out.print( row.getString(1)+"  "+row.getString(2));
        }

    }
}
