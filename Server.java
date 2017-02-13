import java.io.*;
import java.net.*;
/*
  YOU WILL FIND 100% MATCH WITH THE FOLLOWING REPOSITORY
  https://github.com/T-Nawaz/CSE338_Lab2_RPS_Game
  BECAUSE THAT REPOSITORY IS MINE
*/

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
            System.out.println(new StringBuilder().append("Error while connecting through port").append(port).toString());
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

                String nameA = clientAin.readLine();
                String nameB = clientBin.readLine();

                while(clientSocketA.isConnected() && clientSocketB.isConnected()){

                    System.out.print("ClientA ("+ nameA + "): ");
                    clientAchoice = Integer.parseInt(clientAin.readLine());
                    System.out.println(clientAchoice);

                    System.out.print("ClientB ("+ nameB + "): ");
                    clientBchoice = Integer.parseInt(clientBin.readLine());
                    System.out.println(clientBchoice);

                    if((clientAchoice == 2 && clientBchoice==1) || (clientAchoice == 3 && clientBchoice == 2) || (clientAchoice == 1 && clientBchoice == 3)){
                        clientAout.println("You won this round\n");
                        clientBout.println("You lost this round\n");
                        System.out.println(nameA +" won this round\nEnd of round\n");
                    }


                    if((clientBchoice == 2 && clientAchoice == 1) || (clientBchoice == 3 && clientAchoice == 2) || (clientBchoice == 1 && clientAchoice == 3)){
                        clientAout.println("You lost this round\n");
                        clientBout.println("You won this round\n");
                        System.out.println(nameB +" won this round\nEnd of round\n");
                    }

                    if(clientBchoice == clientAchoice) {
                        clientAout.println("Match Draw \n");
                        clientBout.println("Match Draw \n");
                        System.out.println("Match ended in a draw\nEnd of round \n");
                            }

                }
            } catch (IOException e) {
                System.out.println("Client Left");

            }


        }

    }
}
