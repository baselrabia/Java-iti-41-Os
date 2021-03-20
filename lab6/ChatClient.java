import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*; 
import java.io.*; 
import java.util.*; 


public class ChatClient extends JFrame {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    JTextArea ta;
    JTextField tf;
    String user;

    public static void main(String args[]) {
        ChatClient ui = new ChatClient();
        ui.setSize(600, 400);
        ui.setResizable(false);
        ui.setVisible(true);
    }

    public ChatClient() {

        this.setLayout(new FlowLayout());
        ta = new JTextArea(20, 50);
        JScrollPane scroll = new JScrollPane(ta);
        tf = new JTextField(40);
        JButton okButton = new JButton("Send");
        user = JOptionPane.showInputDialog("Anyone there?");

        add(scroll);
        add(tf);
        add(okButton);

            try {
                mySocket = new Socket(InetAddress.getLocalHost(), 5005);
                dis = new DataInputStream(mySocket.getInputStream());
                ps = new PrintStream(mySocket.getOutputStream());
               // ps.println("Test Test ");
                // ps.println(tf.getText());
                
                // String replyMsg = dis.readLine();

                // System.out.println(replyMsg);
                new ChatReader();

            }
            catch (IOException ex) {
                ex.printStackTrace();
            }

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ps.println(user + " : " + tf.getText());
                //ta.append(tf.getText() + "\n");
                tf.setText("");
            }
        });

    }
   



class ChatReader extends Thread {
    
 
    public ChatReader() {
        try {
            // dis = new DataInputStream(cs.getInputStream());
            // ps = new PrintStream(cs.getOutputStream());
            // clientsVector.add(this);
            start();
         } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            while (true) {
                String str = ChatClient.this.dis.readLine();
                 ChatClient.this.ta.append(str + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
}