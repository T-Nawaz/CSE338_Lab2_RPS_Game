import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_B {
    public static Socket socket = null;
    public static void main(String[] args){
        try{
            socket = new Socket("localhost",16000);
            System.out.println(new StringBuilder().append("Connection to Server over port: ").append(socket.getPort()).append(" established \n").toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        Scanner consoleInput = new Scanner(System.in);

        try {
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintWriter(socket.getOutputStream(),true);


            while (true){

                System.out.print("Client B: ");
                outputStream.println(consoleInput.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
