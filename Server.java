package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int port = 22222;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket gameClientSocket = null;

        System.out.println("Server is starting...");

        while(true){
            try{
                serverSocket = new ServerSocket(30);

                gameClientSocket =  serverSocket.accept();

                System.out.println("Client has connected");
                //Reads from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(gameClientSocket.getInputStream()));

                PrintWriter writer = new PrintWriter(gameClientSocket.getOutputStream(), true);
                //Writes to client
                writer.println("WELCOME TO GAME SERVER");

                while (true) {
                    System.out.print("Server: ");

                    System.out.println("Client says: " + reader.readLine());
                }

                //consoleInput.close();
                //ss.close();

            } catch (IOException e){
                System.out.println("Client has left.");
                //e.printStackTrace();
            }
        }
    }
}
