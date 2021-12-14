import java.util.concurrent.TimeUnit;

public class Chrono {

    private long tempsDepart=0;
    private long tempsFin=0;
    private boolean pause = false;
    private boolean launched = false;
    private long duree=0;

    public void start()
    {
        if(launched) {
            long mtn = System.currentTimeMillis();
            tempsDepart = tempsDepart + mtn - tempsFin;
            pause = false;
        } else {
            tempsDepart = System.currentTimeMillis();
            launched = true;
        }
    }
    
    public void stop()
    {
        if(launched && !pause) {
            tempsFin = System.currentTimeMillis();
            duree = tempsFin - tempsDepart;
            pause = true;
        }
    }

    public long getDureeSec()
    {
        if(!pause && launched){
            tempsFin=System.currentTimeMillis();
            duree=tempsFin-tempsDepart;
        }
        return duree/1000;
    }

    public String getDureeTxt()
    {
        return timeToHMS(getDureeSec());
    }

    public static String timeToHMS(long tempsS) {

        // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "1 h 26 min 3 s"

        String dm = String.valueOf((int) (tempsS / 600));
        String m = String.valueOf((int) ((tempsS % 600) / 60));
        String s = String.valueOf((int) (tempsS % 10));
        String ds = String.valueOf((int) ((tempsS % 60) / 10));

        return dm + m + " : " + ds + s;
    }

    public static void main ( String[] args) {
        Chrono chrono = new Chrono();
        chrono.start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(chrono.getDureeTxt());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chrono.stop();
        System.out.println(chrono.getDureeTxt());
    }
}

