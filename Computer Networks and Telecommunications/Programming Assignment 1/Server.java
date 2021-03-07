import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Server{
    public Server(int port) {
        startChat(port);
    }
    
    public void startChat(int port){
        LinkedList<String> messages = new LinkedList<String>();
        
        
        try {
            final ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Awaiting client");
            final Socket socket = server.accept();
            System.out.println("Client accepted");
            
            DataInputStream in = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream out = new DataOutputStream(
                    socket.getOutputStream());
            
        Thread receiveandprintMessages = new Thread(){
            public void run(){
		String line = "";
                while (!line.equals("Bye")) {
                    try {
                        line = in.readUTF();
                        messages.push(line);
                        System.out.println(line);
                    } catch (IOException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                }
                System.out.println("Goodbye!");
            }
        };
        
        Thread getandsendMessages = new Thread(){
            public void run(){
                while(true){
                    try{TimeUnit.MILLISECONDS.sleep(10);}catch(InterruptedException e){}
                    if(messages.size() > 0){
                        try{
                            out.writeUTF(messages.pop());
                        }catch(IOException e){
                            System.out.println("Error: " + e);
                        }
                    }
                }
            }
        };
        
        
        receiveandprintMessages.start();
        getandsendMessages.start();
    }catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public static void main(String args[]) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        
    }
}

