package lambdas;

import java.io.PrintWriter;

/**
 * Created by CraigFox on 11/06/14.
 */
public class LambdaScope {

    private String otherMovie = "X Men First Class";

    private static PrintWriter pw = new PrintWriter(System.out, true);
    public LambdaScope() {
        String movie = "Raiders Of The Lost Ark";
        Runnable r = () -> pw.println("Let's watch " + movie);
        r.run();
        Runnable r2 = () -> pw.println("Now let's watch " + otherMovie);
        r2.run();
        /* The following code doesn't work! Can't reassign local variable
          movie = "Shakespeare In Love";
          r.run(); */
    }

    public static void main(String[] args){
        new LambdaScope();
    }
}
