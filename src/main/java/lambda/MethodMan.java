package main.java.lambda;

import java.io.PrintWriter;
import java.util.function.Supplier;

import main.java.model.Movie;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 20/06/14
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MethodMan {

  private static PrintWriter pw = new PrintWriter(System.out, true);

  public void oldInstanceMethod(){
    pw.println("An old instance method is being run by your new lambda");
  }

  private static void oldMethod(){
    pw.println("An old method is being run by your new lambda");
  }

  public MethodMan(){
    Runnable oldStuff = MethodMan::oldMethod;
    oldStuff.run();

    oldStuff = this::oldInstanceMethod;
    oldStuff.run();

    Supplier<Movie> newMovie = Movie::new;
    pw.println("There " + (newMovie.get() != null ? "is":"isn't") + " a new movie made from a method reference!" );
  }

  public static void main(String[] args){
    new MethodMan();
  }
}
