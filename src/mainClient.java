import java.io.IOException;

public class mainClient {

    public static void main ( String[] args) throws IOException {
        Client monClient = new Client(args[0], 1024);
    }
}
