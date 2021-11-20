import java.io.IOException;

public class main {

    public static void main ( String[] args) throws IOException {
        Server monServeur = new Server();
        monServeur.start(1024);

    }
}
