import java.net.*;
import java.io.*;
import java.util.LinkedList;

public class Client{
    private final String endphrase = "Bye";
    private Socket socket = null;
    private DataInputStream userInput = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private String username;
    
    public Client(String address, int port){
        connectToServer(address, port);
        initializeUsername();
        startChat();
    }
    
    private void startChat(){
        Thread getandsendMessages = new Thread(){
            public void run(){
                String inputLine = "";
                while(!inputLine.equals(endphrase)){
                    try{
                        inputLine = userInput.readLine();
                        messageToServer(inputLine);
                    }catch(IOException e){
                        System.out.println("Error: " + e);
                    }
                }
            }
        };
        
        Thread receiveandprintMessages = new Thread(){
            public void run(){
		String line = "";
                while (!line.equals(endphrase)) {
                    try {
                        line = in.readUTF();
                        System.out.println(line);
                    } catch (IOException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                }
            }
        };
        
        getandsendMessages.start();
        receiveandprintMessages.start();
    }
    
    private void messageToServer(String message){
        if (!message.equals(endphrase)) {
            
            //Send outs from Client
            try {
                out.writeUTF(username + ": " + message);
            }catch(IOException e){
                System.out.println("Error: " + e);
            }
        }
        else{
            endConnection();
        }
    }
    
    private void connectToServer(String address, int port){
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            userInput = new DataInputStream(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }
    
    private void initializeUsername(){
        System.out.printf("Enter your username: ");
        try{
            username = userInput.readLine();
            messageToServer("Server: Welcome " + username);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    private void endConnection(){
        try {
            userInput.close();
            in.close();
            out.close();
            socket.close();
        }catch (IOException i){
            System.out.println(i);
        }
    }
    
    public static void main(String args[]){
        int port = Integer.parseInt(args[0]);
	Client client = new Client("localhost", port); 
    }
}








