import javax.swing.*;
import java.awt.*;

public class FenetrePresentateur extends JFrame {

    private JLabel chronotxt1;
    private String chrono1;
    private JLabel chronotxt2;
    private String chrono2;

    public FenetrePresentateur(String chrono1, String chrono2){
        super();
        this.chrono1 = chrono1;
        this.chrono2 = chrono2;
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

        GridBagConstraints gc = new GridBagConstraints();

        //gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(10,10,10,10);
        gc.weightx = 2;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.EAST;

        chronotxt1 = new JLabel(chrono1);
        panel.add(chronotxt1, gc);
        chronotxt1.setFont(new Font("Century Gothic Black", Font.PLAIN, 200));
        chronotxt1.setForeground(Color.ORANGE);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.WEST;

        chronotxt2 = new JLabel(chrono2);
        panel.add(chronotxt2, gc);
        chronotxt2.setFont(new Font("Century Gothic Black", Font.PLAIN, 200));
        chronotxt2.setForeground(Color.ORANGE);

        return panel;
    }

    public void update(String chrono1, String chrono2){
        chronotxt1.setText(chrono1);
        chronotxt2.setText(chrono2);
    }
}