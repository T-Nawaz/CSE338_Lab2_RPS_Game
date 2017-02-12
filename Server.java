import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

    private static ServerSocket gameServer = null;
    private static Socket clientSocketA = null;
    private static Socket clientSocketB = null;
    private static final int port = 16000;

    public static void main(String args[]){

        BufferedReader clientAin = null;
        BufferedReader clientBin = null;
        PrintWriter clientAout = null;
        PrintWriter clientBout = null;

        try{
            System.out.println("Game Server is Starting");
            gameServer = new ServerSocket(port);
            System.out.println("Game Server Online");
        }catch (IOException e){
            System.out.println("Error while connecting through port" + port);
            System.exit(-1);
        }

        while (true){

            try {
                clientSocketA = gameServer.accept();
                clientSocketB = gameServer.accept();
                System.out.println("Client Connected\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                clientAin = new BufferedReader(new InputStreamReader(clientSocketA.getInputStream()));
                clientBin = new BufferedReader(new InputStreamReader(clientSocketB.getInputStream()));

                clientAout = new PrintWriter(clientSocketA.getOutputStream(), true);
                clientBout = new PrintWriter(clientSocketB.getOutputStream(), true);

                int clientAchoice, clientBchoice;

                while(clientSocketA.isConnected() && clientSocketB.isConnected()){

                    System.out.print("ClientA: ");
                    clientAchoice = Integer.parseInt(clientAin.readLine());
                    System.out.println(clientAchoice);

                    System.out.print("ClientB: ");
                    clientBchoice = Integer.parseInt(clientBin.readLine());
                    System.out.println(clientBchoice);

                    if((clientAchoice==2 && clientBchoice==1) || (clientAchoice==3 && clientBchoice==2) || (clientAchoice==1 && clientBchoice==3)){
                        clientAout.println("Player A has won");
                        clientBout.println("Player A has won");
                        System.out.println("Player A has won");
                    }


                    if((clientBchoice==2 && clientAchoice==1) || (clientBchoice==3 && clientAchoice==2) || (clientBchoice==1 && clientAchoice==3)){
                        clientAout.println("Player B has won");
                        clientBout.println("Player B has won");
                        System.out.println("Player B has won");
                    }

                    if(clientBchoice == clientAchoice) {
                        clientAout.println("Match Draw");
                        clientBout.println("Match Draw");
                        System.out.println("Match Draw");
                            }

                }
            } catch (IOException e) {
                System.out.println("Client Left");

            }


        }

    }
}
