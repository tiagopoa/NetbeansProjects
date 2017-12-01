package contadorserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContadorServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Início da Votação");
	        /*if (args.length < 1){
	            System.err.println("Usage echoServer <port number>");
	            System.exit(1);
	        }*/
	        int portNumber = 8005;
	        ExecutorService executor = null;
	        
	        try(ServerSocket serverSocket = new ServerSocket(portNumber);) {
	            executor = Executors.newFixedThreadPool(5);
	            System.out.println("Aguardando Eleitores");
	            while (true) {
	                Socket clientSocket = serverSocket.accept();
                        Runnable worker = new RequestHandler(clientSocket);
	                executor.execute(worker);
                        //System.out.println("Received message from: " + worker.getSoma());
	            }
	        } catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
	            System.out.println(e.getMessage());
                        } finally{
                            if (executor != null){
                                executor.shutdown();
	            }
	    }
    }
    
}
