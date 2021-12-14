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
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK);

        chronotxt = new JLabel(chrono);
        panel.add(chronotxt);
        chronotxt.setFont(new Font("Century Gothic Black", Font.PLAIN, 400));
        chronotxt.setForeground(Color.ORANGE);

        return panel;
    }

    public void update(String chrono){
        chronotxt.setText(chrono);
    }
}