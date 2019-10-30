import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    private ServerSocket s;
    private Socket client;
    private Connection c;
    private static final int PORT_NUM = 5155;
    private int threadCounter = 0;


    public Server() {


        System.out.println("PORT_NUM in use: " + PORT_NUM);
        // create the socket the server will listen to
        try {
            s = new ServerSocket(PORT_NUM);
        } catch (java.io.IOException e) {
            System.out.println("Port already in use");
            System.out.println(" " + e);
            System.exit(1);
        }

        System.out.println("Server is listening ....");


        // OK, now listen for connections and create them
		while(true) {
            try {

                client = s.accept();
                System.out.println("SERVER:  connection accepted");



                // create a separate thread to service the client
                c = new Connection(client);
				Thread thread = new Thread(c, "Server Thread: " + threadCounter);
				thread.start();
				threadCounter++;
				System.out.println("" + thread.getName() + "\n");

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.print(e);
                }
            } catch (java.io.IOException e) {
                System.out.println(e);
            }

        }
    }


    public static void main(String args[]) {

        try{
            InetAddress server_inet_address = InetAddress.getLocalHost() ;
            String server_host_name = server_inet_address.getHostName();
            String server_ip_address = server_inet_address.getHostAddress();

            System.out.println ("Server Hostname: " + server_host_name ) ;
            System.out.println("Server IP Address: " + server_ip_address);
            System.out.println ("Server port: 5155" ) ;
        }

        catch (java.net.UnknownHostException e){
            System.out.println(e);
            System.exit(1);
        }


        Server timeOfDayServer = new Server();

    }

}	