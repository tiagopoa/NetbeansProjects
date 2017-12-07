/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somavotosurnas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tcv
 */


public class SomaVotosUrnas {
    
 
    
    public static void main(String[] args) {
        
           int voto = 0;
           int candidato1 = 0;
           int candidato2 = 0;
           int candidato3 = 0;
    
    ServerSocket serverSocket = null;
        Socket listenSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
            System.out.println("Aguardando conexao...");
            while (true) {
            listenSocket = serverSocket.accept();
            System.out.println("Urna conectada!!");
            DataInputStream dis = new DataInputStream(
                    listenSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(
                    listenSocket.getOutputStream());
            
            
            String msg = dis.readUTF();
            //System.out.println("Recebido "+msg);
            //String hello = "Hello "+nome;
            //dos.writeUTF(hello);            
            //System.out.println("Enviado "+hello);
            
            switch (Integer.parseInt(msg)) {
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
            
            System.out.println("\n\nSoma dos votos das Urnas");
                System.out.println("Zezinho: " + candidato1);
                System.out.println("Huguinho: " + candidato2);
                System.out.println("Luizinho: " + candidato3);
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SomaVotosUrnas.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(listenSocket != null){
                try {
                    listenSocket.close();
                    serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(SomaVotosUrnas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
    
}
