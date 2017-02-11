package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 22222;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket gameClientSocket = null;
        System.out.println("GAME SERVER IS STARTING");
        while(true){
            try{
                serverSocket = new ServerSocket(port);
                gameClientSocket = serverSocket.accept();

                System.out.println("Server: PLAYER HAS CONNECTED");
                //Reads from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(gameClientSocket.getInputStream()));

                PrintWriter printWriter = new PrintWriter(gameClientSocket.getOutputStream(), true);
                //Writes to client
                printWriter.println("Server: WELCOME TO GAME SERVER");

                while (true) {
                    printWriter.println("Waiting for client response... \n");
                    System.out.println("Client says: " + reader.readLine());
                }

            } catch (IOException e){
                System.out.println("Client has left.");
            }
        }
    }
}
