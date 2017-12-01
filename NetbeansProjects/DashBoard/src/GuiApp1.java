import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;

public class GuiApp1 {

    public static void main(String[] args) {

        new GuiApp1();
    }

    public GuiApp1()
    {
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        guiFrame.setSize(300,250);
        guiFrame.setLocationRelativeTo(null);

        Box caixaVertical = Box.createVerticalBox();

        List<JLabel> labelLista = new ArrayList<JLabel>();
        List<JTextField> inputLista = new ArrayList<JTextField>();
        for(int i=0;i<10;i++){
            Box caixaHorizontal = Box.createHorizontalBox();
            JLabel label = new JLabel("Label" + i + "         ");
            JTextField input = new JTextField(10);
            labelLista.add(label);
            inputLista.add(input);
            caixaHorizontal.add(label);
            caixaHorizontal.add(input);
            caixaVertical.add(caixaHorizontal);
        }
        guiFrame.add(caixaVertical);
        guiFrame.setVisible(true);
    }

}