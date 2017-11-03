import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Oleksandr_Shainoga on 11/3/2017.
 */
public class Suport extends  Thread{
    ArrayList<PrintWriter> out;
    ServerSocket serverSocket;

    public Suport(ArrayList<PrintWriter> out, ServerSocket serverSocket) {
        this.out = out;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket fromserver =  serverSocket.accept();
                out.add( new PrintWriter(fromserver.getOutputStream(), true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
