
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcv
 */
class EntraDados implements Runnable{

    @Override
    public void run() {
        while (true) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Insira o valor do sensor 1: ");
        int sensor1 = scan.nextInt();
        
        /*RecebeDados recebeDados = new RecebeDados();
        Thread threadRecebeDados = new Thread(recebeDados);
        threadRecebeDados.start();*/
        
        Thread recebeDados = new Thread(new RecebeDados(sensor1));
	recebeDados.start();
        }
    }
    
}
