import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static final String dataFile = "testDataFrameCSV.txt";
    static final Integer sleepTime = 330;
    static ArrayList<PrintWriter> outs = new ArrayList();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to Server side");
        ServerSocket servers = new ServerSocket(4444);
        Suport s = new Suport(outs, servers);
        Thread t=new Thread(s);
        t.setDaemon(true);
        t.start();
        while(true){
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                for (PrintWriter out:outs) {
                    out.println(sCurrentLine);
                }

                Thread.sleep(sleepTime);
            }

           }
           outs= new ArrayList();
        }

    }
}
