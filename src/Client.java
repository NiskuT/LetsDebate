import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    public Client(String address, Integer port) throws IOException {

        //code to establish a connection
        System.out.println("Quel chrono ? ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        FenetrePresentateur fenetrePresentateur = null;
        FenetreClient fenetreClient = null;
        if(s.equals("3")) fenetrePresentateur = new FenetrePresentateur("","");
        else fenetreClient = new FenetreClient("");

        try {
            startConnection(address, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("1");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1");
        }

        String line = "";
        //below line is to read message from input
        while(true){
            line = input.readLine();
            if (line == null || line.equals("Done")) break;
            //System.out.println(line);

            String chrono, chrono1, chrono2;
            if(s.equals("1")) {
                chrono = line.substring(10,17);
                fenetreClient.update(chrono);
            }
            else if(s.equals("2")) {
                chrono = line.substring(39,46);
                fenetreClient.update(chrono);
            }
            else if(s.equals("3")){
                chrono1 = line.substring(10,17);
                chrono2 = line.substring(39,46);
                fenetrePresentateur.update(chrono1, chrono2);
            }

        }

        try {
            stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startConnection (String ip,int port) throws IOException {
        socket = new Socket(ip, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // sends output to the socket
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void stopConnection () throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}

