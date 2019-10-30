import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable{
	
	private Socket	outputLine;	
	
	
	public Connection(Socket s) {		
		outputLine = s;	
	}	
 	
	
	public void run() {
	
		// getOutputStream returns an OutputStream object	
		// allowing ordinary file IO over the socket.

		// create a new PrintWriter with auto flushing
		try {
			// create a new PrintWriter with auto flushing
			PrintWriter pout = new PrintWriter(outputLine.getOutputStream(), true);
			
			// now send a message to the client			
			pout.println(" The Date and Time is " + new java.util.Date().toString());	
			
			// now close the socket				
			outputLine.close(); 
		}		
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
