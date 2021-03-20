
import java.net.*; 
import java.io.*; 
import java.util.*; 


public class ChatServer {
    ServerSocket serverSocket;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
         try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                Socket s = serverSocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   
}


class ChatHandler extends Thread {
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler> ();

    public ChatHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clientsVector.add(this);
            start();
         } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            while (true) {
                String str = dis.readLine();
                sendMessageToAll(str);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    void sendMessageToAll(String msg) {
        for (ChatHandler ch: clientsVector) {
            ch.ps.println(msg);
        }
    }
}