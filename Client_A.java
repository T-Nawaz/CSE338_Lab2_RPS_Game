import java.io.*;
import java.net.*;
import java.text.MessageFormat;
import java.util.Scanner;
/*
  YOU WILL FIND 100% MATCH WITH THE FOLLOWING REPOSITORY
  https://github.com/T-Nawaz/CSE338_Lab2_RPS_Game
  BECAUSE THAT REPOSITORY IS MINE
*/

public class Client_A {
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
        Scanner manualInput = new Scanner(System.in);

        try {
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintWriter(socket.getOutputStream(),true);
            System.out.print("Enter your name: ");
            String name = manualInput.nextLine();
            outputStream.println(name);

            while (true){

                System.out.print(new StringBuilder().append("Client A (").append(name).append("): ").toString());
                outputStream.println(manualInput.nextLine());
                System.out.print("Server: ");
                System.out.println(MessageFormat.format("{0}\n", inputStream.readLine()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
