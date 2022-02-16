import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client{

    private Socket socket = null;
    private DataInputStream in = null;
    private static DataOutputStream out = null;
    Scanner scanner = null;
    LinkedList<String> messages = new LinkedList<String>();
    LinkedList<String> guiMessages = new LinkedList<String>();
    
    static JLabel serverOutputs = new JLabel("<html>" + "<br>Line" + "<br>Line" + "<br>Line" + "</html>");;
    
    public static void main(String args[]){
        int port = 5000;
	    Client client = new Client("localhost", port); 

        //Citation: Learned how to use Java GUI from Stack Overflow
        //Link: https://stackoverflow.com/questions/15194991/how-to-put-a-table-and-3-buttons-in-a-jframe

        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JPanel topPanel = new JPanel();
        JPanel btnPanel = new JPanel();

        topPanel.add(serverOutputs, new GridBagConstraints());
        serverOutputs.setVisible(true);

        JTextField usernameField = new JTextField("Enter Username...");
        JButton saveUsernameButton = new JButton("Save Username");
        topPanel.add(usernameField);
        topPanel.add(saveUsernameButton);

        saveUsernameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    out.writeUTF(usernameField.getText());
                    usernameField.setVisible(false);
                    saveUsernameButton.setVisible(false);
                }catch(IOException i){
                    i.printStackTrace();
                }
            }
        });

        //Spell Button
        JButton spellButton = new JButton("SPELL");
        spellButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    out.writeUTF("spell");
                }catch(IOException i){
                    i.printStackTrace();
                }
            }
        });

        //Shield Button
        JButton shieldButton = new JButton("SHIELD");
        shieldButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    out.writeUTF("shield");
                }catch(IOException i){
                    i.printStackTrace();
                }
            }
        });

        JButton swordButton = new JButton("SWORD");
        swordButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    out.writeUTF("sword");
                }catch(IOException i){
                    i.printStackTrace();
                }
            }
        });

        btnPanel.add(spellButton);
        btnPanel.add(shieldButton);
        btnPanel.add(swordButton);
        //serverOutputs.setVisible(false);

        frame.getContentPane().add(topPanel, BorderLayout.CENTER);
        frame.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public Client(String address, int port){
        connectToServer(address, port);
        startChat();
    }
    
    private void startChat(){
        ExecutorService coreThreads = Executors.newCachedThreadPool();
        
        printMessagesThread printMessagesThread = new printMessagesThread(messages);
        coreThreads.execute(printMessagesThread);

        readMessagesThread readMessagesThread = new readMessagesThread(messages);
        coreThreads.execute(readMessagesThread);

        writeInputsThread writeInputsThread = new writeInputsThread();
        coreThreads.execute(writeInputsThread);

    }
    
    //Ensures that messages are printed beautifully
    public void guiMessageHandler(String message){
        if(guiMessages.size() < 10){
            guiMessages.add(message);
        }
        else{
            guiMessages.pop();
            guiMessages.add(message);
        }

        String finalMessage = "<html>";

        for(String string : guiMessages){
            finalMessage = finalMessage + "<br>" + string;
        }

        finalMessage = finalMessage + "</html>";
        serverOutputs.setText(finalMessage);
    }

    //handles printing any messages in messages LinkedList
    class printMessagesThread implements Runnable{
        private LinkedList<String> messages;
        public printMessagesThread(LinkedList<String> messages){
            this.messages = messages;
        }
    
        @Override
        public void run(){
            TimeUnit time = TimeUnit.MILLISECONDS;
            while(true){
                try{
                    String newMessage = messages.poll();
                    if(newMessage != null){
                        guiMessageHandler(newMessage);
                    }
                    time.sleep(250);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //handles writing the system input from the client to the server
    class writeInputsThread implements Runnable{
        public writeInputsThread(){
            scanner = new Scanner(System.in);
        }
    
        @Override
        public void run(){
            TimeUnit time = TimeUnit.MILLISECONDS;
            while(true){
                try{
                    if(scanner.hasNext()){
                        String messageToServer = scanner.nextLine();
                        out.writeUTF(messageToServer);
                    }
                    time.sleep(250);
                }catch(InterruptedException|IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //handles adding any messages from the server to the messages LinkedList
    class readMessagesThread implements Runnable{
        private LinkedList<String> messages;
        public readMessagesThread(LinkedList<String> messages){
            this.messages = messages;
        }
    
        @Override
        public void run(){
            TimeUnit time = TimeUnit.MILLISECONDS;
            while(true){
                try{
                    if(in.available() > 0){
                        String messageFromServer = in.readUTF();
                        messages.add(messageFromServer);
                    }
                    time.sleep(250);
                }catch(InterruptedException|IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //connects to the server
    private void connectToServer(String address, int port){
        try{
            socket = new Socket(address, port);
            messages.add("Connected.");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }
    
    private void endConnection(){
        try {
            in.close();
            out.close();
            socket.close();
        }catch (IOException i){
            System.out.println(i);
        }
    }
}