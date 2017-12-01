package contadorserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private final Socket client;
    ServerSocket serverSocket = null;

    public RequestHandler(Socket client) {
        this.client = client;
    }
    
    /*public int soma = 0;    
    public String getSoma(){
        return Integer.toString(this.soma);
    }*/
    
    int candidato1 = 0;
    int candidato2 = 0;
    int candidato3 = 0;
    
    
    @Override
    public void run(){
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);) {            
            System.out.println("Thread started with name: " + Thread.currentThread().getName());
            String userInput;
            while ((userInput = in.readLine()) != null) {
                userInput = userInput.replaceAll("[^ A-Za-z0-9]", "");
                System.out.println("Received message from: " + Thread.currentThread().getName() + " : " + userInput);
                out.println("teste" + userInput);
                //writer.write(userInput);
                //writer.newLine();
                //writer.flush();
                
                //public int somaVotos(soma);
                
                /*switch (Integer.getInteger(userInput)) {
                    case 1: {
                        candidato1++;
                    }
                    case 2: {
                        candidato2++;
                    }
                    case 3: {
                        candidato3++;
                    }
                }*/
                
                int voto = Integer.parseInt(userInput);
                
                if (voto == 1){
                    candidato1++;
                } else if (voto == 2){
                    candidato2++;
                } else if (voto == 3){
                    candidato3++;
                }
                       
                System.out.println("\n\nParcial de votos");
                System.out.println("Zezinho: " + candidato1);
                System.out.println("Huguinho: " + candidato2);
                System.out.println("Luizinho: " + candidato3);
                
                //soma+=;  
                //System.out.println("soma: " + soma);
            }
            
        } catch (IOException e) {
                System.out.println("I/O Exception: " + e);                
                } catch (Exception ex){
                        System.out.println("Exception in Thread Run. Exception ");
                        }
            
    }
    
}
