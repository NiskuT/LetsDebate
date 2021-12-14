import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    public Client(String address, Integer port) throws IOException {

        //code to establish a connection
        try {
            startConnection(address, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";
        //below line is to read message from input
        while(true){
            line = input.readLine();
            if (line == null || line.equals("Done")) break;
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println(line);
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

