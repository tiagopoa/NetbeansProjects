package urnaclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UrnaClient {

	public static void main(String[] args) throws IOException {
		/*if (args.length != 2) {
			System.err.println("Usage: java EchoClient <host name> <port Number>");
			System.exit(1);
		}*/
        String hostName = "127.0.0.1";
        int portNumber = 8005;        
        int voto = 0;
        
        Scanner scan = new Scanner(System.in);
        
        try (Socket echoSocket  = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
        String userInput;            
            
            
        while (true){
            System.out.println("\nEleições");
            System.out.println("Digite o numero do seu candidato e aperte enter: ");
            System.out.println("1 - Zezinho");
            System.out.println("2 - Huguinho");
            System.out.println("3 - Luizinho");            
            voto = scan.nextInt();
            System.out.println("\nVocê escolheu o candidato: " + voto);
            System.out.println("Confirma? \n1 - SIM\n2 - NAO");
            int confirma = scan.nextInt();
            if (confirma==1){
            out.println(voto);             
            } 
        }
        }catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);            
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
    
}
