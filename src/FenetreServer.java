import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreServer extends JFrame implements ActionListener {

    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private JLabel chrono1txt;
    private JLabel chrono2txt;
    private Chrono chrono1;
    private Chrono chrono2;

    public FenetreServer(Chrono chrono1, Chrono chrono2){
        super();
        this.chrono1 = chrono1;
        this.chrono2 = chrono2;
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
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(10,10,10,10);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 3;
        gc.weighty = 2;

        gc.gridx = 0;
        gc.gridy = 0;

        bouton1= new JButton("Chrono1");
        bouton1.addActionListener(this);
        panel.add(bouton1, gc);
        bouton1.setBackground(Color.WHITE);
        bouton1.setFont(new Font("Century Gothic Black", Font.PLAIN, 50));

        gc.gridx = 1;
        gc.gridy = 0;

        bouton2 = new JButton("Speaker");
        bouton2.addActionListener(this);
        panel.add(bouton2, gc);
        bouton2.setBackground(Color.WHITE);
        bouton2.setFont(new Font("Century Gothic Black", Font.PLAIN, 50));

        gc.gridx = 2;
        gc.gridy = 0;

        bouton3 = new JButton("Chrono2");
        bouton3.addActionListener(this);
        panel.add(bouton3, gc);
        bouton3.setBackground(Color.WHITE);
        bouton3.setFont(new Font("Century Gothic Black", Font.PLAIN, 50));

        gc.gridx = 0;
        gc.gridy = 1;

        chrono1txt = new JLabel(chrono1.getDureeTxt());
        panel.add(chrono1txt, gc);
        chrono1txt.setFont(new Font("Century Gothic Black", Font.PLAIN, 130));

        gc.gridx = 2;
        gc.gridy = 1;

        chrono2txt = new JLabel(chrono2.getDureeTxt());
        panel.add(chrono2txt, gc);
        chrono2txt.setFont(new Font("Century Gothic Black", Font.PLAIN, 130));

        return panel;
    }

    public void update(){
        chrono1txt.setText(chrono1.getDureeTxt());
        chrono2txt.setText(chrono2.getDureeTxt());
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bouton1){
            chrono1.start();
            chrono2.stop();
            chrono1txt.setForeground(Color.GREEN);
            chrono2txt.setForeground(Color.BLACK);
        } else if(source == bouton3){
            chrono1.stop();
            chrono2.start();
            chrono1txt.setForeground(Color.BLACK);
            chrono2txt.setForeground(Color.GREEN);
        } else if(source == bouton2){
            chrono1.stop();
            chrono2.stop();
            chrono1txt.setForeground(Color.BLACK);
            chrono2txt.setForeground(Color.BLACK);
        }
    }
}