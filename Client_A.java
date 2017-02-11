package client;

public class Client_A {

    public static void main(String[] args) {

        try {
            Socket serverSocketLol = new Socket("localhost", 30);

            //this guy reads from server:
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(serverSocketLol.getInputStream())
            );

            //this guy writes from server:
            PrintWriter writer = new PrintWriter(
                    serverSocketLol.getOutputStream(), true
            );

            System.out.println("New Client has joined");

            System.out.println(reader.readLine());			//read == output

            //chat client:
            Scanner consoleInput = new Scanner(System.in);

            while (true) {
                System.out.println("Server says: " + reader.readLine());
                System.out.println("Client: ");
                writer.println(consoleInput.nextLine());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
