import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Scanner;

public class Client{
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    Scanner scanner = null;
    LinkedList<String> messages = new LinkedList<String>();
    
    public static void main(String args[]){
        int port = 5000;
	    Client client = new Client("localhost", port); 
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
                        System.out.println(newMessage);
                    }
                    time.sleep(250);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

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