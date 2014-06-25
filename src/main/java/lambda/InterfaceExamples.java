package main.java.lambda;

import java.io.PrintWriter;
import java.time.Duration;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import main.java.model.Movie;
import main.java.model.Review;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 20/06/14
 * Time: 9:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceExamples {
  private static PrintWriter pw = new PrintWriter(System.out, true);
  private static Movie movie, movie2;

  private static void init(){
    movie = new Movie();
    movie.setName("Shaun of the Dead");
    movie.setRunningTime(Duration.ofMinutes(99));
    movie.setStars(5);

    movie2 = new Movie();
    movie2.setName("Manos: The Hands of Fate");
    movie2.setRunningTime(Duration.ofMinutes(74));
    movie2.setStars(1);
  }

  private static String getReview(int stars){
    String review = "";
    switch(stars){
      case 1: review = "Bloody terrible!"; break;
      case 2: review = "Not that good, really"; break;
      case 3: review = "Watchable, especially for fans"; break;
      case 4: review = "A very good movie"; break;
      case 5: review = "Great movie! Everyone should watch it."; break;
      default: review = "This movie is indescribable";
    }
    return review;
  }

  private static void demoRunnable(){
    Runnable threadFree = () -> pw.println("Another day, you will see me used in threads\nBut it is not this day!");
    threadFree.run();
  }

  private static void demoConsumer(){
    pw.println("\n***Consumer<T> - One parameter, no result***");
    Consumer<Movie> watcher = (m) -> pw.println("I watched " + m.getName() + " for " + movie.getRunningTime().toMinutes() + " minutes");
    watcher.accept(movie);
  }

  private static void demoSupplier(){
    pw.println("\n***Supplier<T> - No parameters, result of T***");
    Supplier<Movie> makeMovie = () -> {Movie m =new Movie();
      m.setName("Unnamed");
      return m;
    };
    Movie movieNew = makeMovie.get();
    pw.println("This new movie is called " + movieNew.getName() + " until we name it");
  }

  private static void demoPredicate(){
    pw.println("\n***Predicate<T> - One parameter, boolean result***");
    Predicate<Movie> noRubbish = (m) -> m.getStars() >= 3;
    pw.println(movie.getName() + " is " + (noRubbish.test(movie) ? "cool":"rubbish") + "!");
    pw.println(movie2.getName() + " is " + (noRubbish.test(movie2) ? "cool":"rubbish") + "!");
  }

  private static void demoFunction(){
    pw.println("\n***Function<T, R> - One parameter of type T, result of type R***");
    Function<Movie, Review> reviewMovie = m -> {Review review = new Review(m);
      review.setDescription(getReview(m.getStars()));
      return review;
    };
    Review r = reviewMovie.apply(movie2);
    pw.println("Our reviewer watched " + r.getMovie().getName() + " and he said " + r.getDescription());
  }

  private static void demoBinaryOperator(){
    pw.println("\n***BinaryOperator<T> - Two parameters of type T, result of type T***");
    BinaryOperator<Duration> doubleFeature = (d1,d2) -> d1.plus(d2).plus(Duration.ofMinutes(10));
    pw.println("Watch a double feature of " + movie.getName() + " and " + movie2.getName());
    pw.println("Total screening time is " + doubleFeature.apply(movie.getRunningTime(),
            movie2.getRunningTime()).toMinutes() + " minutes.");
  }

  private static void demoUnaryOperator(){
    pw.println("\n***UnaryOperator<T> - One parameters of type T, result of type T***");
    UnaryOperator<Duration> withAds = (d) -> d.plus(Duration.ofMinutes(15));
    pw.println("Thanks to promotional requirements");
    pw.println("You'll be watching " + movie.getName() + " for "
            + withAds.apply(movie.getRunningTime()).toMinutes() + " minutes.");
  }

  public static void main(String[] args){
    pw.println("***Runnable - No parameters, no result, just code***");
    init();
    demoRunnable();
    demoConsumer();
    demoSupplier();
    demoPredicate();
    demoFunction();
    demoBinaryOperator();
    demoUnaryOperator();
  }
}
