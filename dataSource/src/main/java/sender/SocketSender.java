package sender;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketSender implements DataSender<String> {
    static ArrayList<PrintWriter> outs = new ArrayList();

    static ServerSocket serverSocket;
    Suport s = new Suport();
    Thread t = new Thread(s);

    public SocketSender() throws Exception {
        serverSocket = new ServerSocket(4444);
        t.start();
    }

    @Override
    public void send(String data) {
        for (PrintWriter out : outs) {
            out.println(data);
        }
    }

    //help to send data to all clients of Server
    class Suport extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Socket fromserver = serverSocket.accept();
                    outs.add(new PrintWriter(fromserver.getOutputStream(), true));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

