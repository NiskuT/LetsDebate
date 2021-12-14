import javax.swing.*;
import java.awt.*;

public class FenetreClient extends JFrame {

    private JLabel chronotxt;
    private String chrono;

    public FenetreClient(String chrono){
        super();
        this.chrono = chrono;
        build();
    }

    private void build(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        chronotxt = new JLabel(chrono);
        panel.add(chronotxt);
        chronotxt.setBounds(200,0,2000,1000);
        chronotxt.setFont(new Font("Century Gothic Black", Font.PLAIN, 200));
        chronotxt.setForeground(Color.ORANGE);

        return panel;
    }

    public void update(String chrono){
        chronotxt.setText(chrono);
    }
}