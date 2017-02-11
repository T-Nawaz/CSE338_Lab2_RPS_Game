package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client_A {

    public static void main(String[] args) {

        try {
            Socket serverSocketLol = new Socket("localhost", 22222);
            //Reads from server
            BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocketLol.getInputStream()));
            //Writes to server
            PrintWriter writer = new PrintWriter(serverSocketLol.getOutputStream(), true);
            System.out.println(reader.readLine());
            //Client input system
            Scanner consoleInput = new Scanner(System.in);

            while (true) {
                System.out.println("Server : " + reader.readLine());
                System.out.print("Client: ");
                writer.println(consoleInput.nextLine());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
