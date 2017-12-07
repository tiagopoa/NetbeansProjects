package contadorserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            System.out.println("Urna conectada com o nome: " + Thread.currentThread().getName());
            String userInput;
            while ((userInput = in.readLine()) != null) {
                userInput = userInput.replaceAll("[^ A-Za-z0-9]", "");
                //System.out.println("Received message from: " + Thread.currentThread().getName() + " : " + userInput);
                out.println("teste" + userInput);
                               
                int voto = Integer.parseInt(userInput);
           
                switch (voto) {
                    case 1:
                        candidato1++;
                        break;
                    case 2:
                        candidato2++;
                        break;
                    case 3:
                        candidato3++;
                        break;
                    default:
                        break;
                }
                       
                System.out.println("\n\nParcial de votos da Urna: " + Thread.currentThread().getName());
                System.out.println("Zezinho: " + candidato1);
                System.out.println("Huguinho: " + candidato2);
                System.out.println("Luizinho: " + candidato3);
                
                Socket socketCliente = null;
        try {
            socketCliente = new Socket("localhost", 6789);
            System.out.println("Conectado ao Servidor!");
            DataInputStream dis = new DataInputStream(
                    socketCliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(
                    socketCliente.getOutputStream());
            
            //String nome = JOptionPane.showInputDialog("Nome: ");            
            
            dos.writeUTF(Integer.toString(voto));
            //System.out.println("Enviando "+nome);
            
            //String mensagem = dis.readUTF();
            //System.out.println("Mensagem recebida: "+mensagem);
            //JOptionPane.showMessageDialog(null, mensagem);            
            
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if(socketCliente != null)
                    socketCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                
            }
            
        } catch (IOException e) {
                System.out.println("I/O Exception: " + e);                
                } catch (Exception ex){
                        System.out.println("Exception in Thread Run. Exception ");
                        }
            
    }
    
}
