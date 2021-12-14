import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {
    private ServerSocket serverSocket;
    private static Chrono chrono1;
    private static Chrono chrono2;
    private static FenetreServer fenetre;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(serverSocket.getLocalSocketAddress());
        chrono1 = new Chrono();
        chrono2 = new Chrono();
        fenetre = new FenetreServer(chrono1, chrono2);
        System.out.println(serverSocket);
        while(true) {
            Socket serverofsocket = serverSocket.accept();
            System.out.println(serverofsocket);
            new ClientHandler(serverofsocket).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            System.out.println("Nouveau client accepté." + socket);
        }

        public void run() {

            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String inputLine = "";
            for(int k = 0; k<500;k++) {
                fenetre.update();
                out.println("Chrono1 : " + chrono1.getDureeTxt()+"     ||     Chrono2 : " + chrono2.getDureeTxt());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}