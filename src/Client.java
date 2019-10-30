import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public Client(String host, int port) {


        try {
            Socket s = new Socket(host, port);

            InputStream in = s.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            System.out.println(bin.readLine());
            s.close();
            Thread.sleep(0);

        } catch (IOException e) {
            // if no server available then generate IO Exception and exit
            System.out.println("#### Server unreachable! ####");
            System.out.println(e);
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String args[]) {

        if ((args.length < 1) || (args.length > 2))
        { System.out.println("Usage: [host] <port>") ;
            System.exit (1) ;
        }
        String server_host = args[0] ;
        int server_port = 5155 ;
        if (args.length == 2)
            server_port = Integer.parseInt (args[1]) ;


        while (true) {
            Client client = new Client(server_host, server_port);
        }
    }

}
			
