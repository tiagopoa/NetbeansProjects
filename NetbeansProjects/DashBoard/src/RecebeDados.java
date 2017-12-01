
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class RecebeDados implements Runnable {
 
    
     int sensor1;
     
    private JLabel janela1;  
    public RecebeDados(JLabel janela1){
    this.janela1 = janela1;
    }
    
    RecebeDados(int sensor1) {       
        this.sensor1 = sensor1;
    }
    
    
    
    

    @Override
    public void run() {
        
      System.out.println("Valor passado pelo sensor1: " + sensor1);
      
      janela1.setText("teste");
            janela1.updateUI();
      try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RecebeDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    
}
