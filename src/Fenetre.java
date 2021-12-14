import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {

    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private Chrono chrono1;
    private Chrono chrono2;

    public Fenetre(Chrono chrono1, Chrono chrono2){
        super();
        this.chrono1 = chrono1;
        this.chrono2 = chrono2;
        build();//On initialise notre fenêtre
    }

    private void build(){
        setSize(320,240); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On permet le redimensionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        bouton1= new JButton("Chrono1");
        bouton1.addActionListener(this);
        panel.add(bouton1);

        bouton2 = new JButton("Speaker");
        bouton2.addActionListener(this);
        panel.add(bouton2);

         bouton3 = new JButton("Chrono2");
        bouton3.addActionListener(this);
        panel.add(bouton3);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bouton1){
            chrono1.start();
            chrono2.stop();
        } else if(source == bouton3){
            chrono1.stop();
            chrono2.start();
        } else if(source == bouton2){
            chrono1.stop();
            chrono2.stop();
        }
    }
}