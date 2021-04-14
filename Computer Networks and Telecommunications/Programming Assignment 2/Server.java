import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Server{
    public static void main(String args[]) {
        Server server = new Server();
        
    }
    
    ServerSocket server;
    LinkedList<String> messages = new LinkedList<String>();
    LinkedList<connectionThread> connections = new LinkedList<connectionThread>();

    public Server() {
        //Init main ServerSocket
        try{this.server = new ServerSocket(5000);}
        catch(IOException e){e.printStackTrace();}

        startChat();
    }
    
    public void startChat(){
        int port = 5000;
        messages.add("Server started on port: " + port);

        ExecutorService coreThreads = Executors.newCachedThreadPool();

        printMessagesThread mainMessagesThread = new printMessagesThread(messages);
        coreThreads.execute(mainMessagesThread);

        
        connectionThread user1 = new connectionThread(server, messages);
        connectionThread user2 = new connectionThread(server, messages);

        connections.add(user1);
        connections.add(user2);

		//Start each thread
        ExecutorService connectionExecutor = Executors.newCachedThreadPool();
		connectionExecutor.execute(user1);
        connectionExecutor.execute(user2);
		connectionExecutor.shutdown();

        //Wait until users are connected before proceeding
        TimeUnit time = TimeUnit.SECONDS;
        while(true){
            if(user1.isConnected() && user2.isConnected()){
                break;
            }
            else{
                try{
                    time.sleep(1);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        messages.add("Sufficient users connected.");
        messages.add("Starting game...");
        messages.add("");

        startGame(user1, user2);
    }

    public void startGame(connectionThread user1, connectionThread user2){
        writeToClients("Starting game...");
        writeToClients("Welcome to Shield, Spell, Sword!");
        writeToClients("You will be able to choose a move each round: shield, spell, or sword.");
        writeToClients("Shield beats sword, sword beats spell, and spell beats shield.");
        writeToClients("You will go up against an opponent who will also have the same choice.");
        writeToClients("May luck be on your side! Have fun!\n");

        while(true){
            messages.add("\nStarting New Round...");
            writeToClients("What would you like to use: shield, spell, or sword?");
            String move1 = user1.readInput().toLowerCase();
            String move2 = user2.readInput().toLowerCase();

            //Ensure Moves Are Valid
            while(!move1.matches("shield|spell|sword")){
                user1.writeToClient("Move invalid. Please select another.");
                move1 = user1.readInput().toLowerCase();
            }

            while(!move2.matches("shield|spell|sword")){
                user2.writeToClient("Move invalid. Please select another.");
                move2 = user2.readInput().toLowerCase();
            }

            String moves = String.format("%s used %s | %s used %s", user1.getUsername(), move1, user2.getUsername(), move2);
            messages.add(moves);

            //Tie
            if(move1.equals(move2)){
                System.out.println("This came true");
                String tie = String.format("Tie - both users selected: %s\n", move1);
                messages.add(tie);
                writeToClients(tie);
            }
            else{
                writeToClients(moves);
                if(move1.equals("spell") && move2.equals("shield")){
                    writeToClients(String.format("%s wins this round!\n", user1.getUsername()));
                }
                else if(move1.equals("sword") && move2.equals("spell")){
                    writeToClients(String.format("%s wins this round!\n", user1.getUsername()));
                }
                else if(move1.equals("shield") && move2.equals("sword")){
                    writeToClients(String.format("%s wins this round!\n", user1.getUsername()));
                }
                else if(move2.equals("spell") && move1.equals("shield")){
                    writeToClients(String.format("%s wins this round!\n", user2.getUsername()));
                }
                else if(move2.equals("sword") && move1.equals("spell")){
                    writeToClients(String.format("%s wins this round!\n", user2.getUsername()));
                }
                else if(move2.equals("shield") && move1.equals("sword")){
                    writeToClients(String.format("%s wins this round!\n", user2.getUsername()));
                }
                else{
                    System.out.println("Something has gone wrong...");
                }
            }
        }
    }

    public void writeToClients(String message){
        for(connectionThread connection : connections){
            connection.writeToClient(message);
        }
    }
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

class connectionThread implements Runnable{
    private String username = null;
    private boolean isConnected = false;
    private ServerSocket server;
    private LinkedList<String> messages;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    

    public connectionThread(ServerSocket server, LinkedList<String> messages){
        this.server = server;
        this.messages = messages;
    }

    public boolean isConnected(){
        return isConnected;
    }

    @Override
    public void run(){
        try{
            final Socket user = server.accept();
            
            in = new DataInputStream(user.getInputStream());
            out = new DataOutputStream(user.getOutputStream());
            writeToClient("Hello friend! What's your name?");

            //wait until Client gives username before proceeding
            TimeUnit time = TimeUnit.MILLISECONDS;
            try{
                while(in.available() == 0){
                    time.sleep(250);
                }
            }
            catch(InterruptedException e){e.printStackTrace();}

            this.username = in.readUTF();

            messages.add(this.username + " has connected.");
            isConnected = true;
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getUsername(){
        return this.username;
    }

    public String readInput(){
        String input = "";

        TimeUnit time = TimeUnit.MILLISECONDS;
            try{
                while(in.available() == 0){
                    time.sleep(250);
                }
                input = in.readUTF();
            }
            catch(InterruptedException|IOException e){e.printStackTrace();}


        return input;
    }

    public void writeToClient(String message){
        try{
            out.writeUTF("Server: " + message);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}