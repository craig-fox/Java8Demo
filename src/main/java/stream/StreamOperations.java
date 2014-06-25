package main.java.stream;

import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import main.java.helpers.StreamHelper;
import main.java.model.Gadget;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 23/06/14
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class StreamOperations {

  List<Gadget> gadgets = new ArrayList<>();
  PrintWriter pw = new PrintWriter(System.out, true);
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

  private void demoSorted(){
    pw.println("Sort by invented date");
    gadgets.stream()
            .sorted((g1, g2) -> g1.getInvented().compareTo(g2.getInvented()))
            .forEach(g -> pw.println(g.getName() + " was invented on " +  formatter.format(g.getInvented())));
  }

  private void demoMap(){
    pw.println("\nInventor names, in order");
    gadgets.stream().map(g -> g.getInventor()).sorted().forEach(name -> pw.println(name));
  }

  private void demoFlatMap(){
    pw.println("\nAll parts used to make gadgets");
    gadgets.stream().flatMap(g -> g.getParts().stream()).forEach(p -> pw.println( p.getName()));
  }

  private void demoLimit(){
    pw.println("\nReturn just 2 gadgets");
    gadgets.stream().limit(2).forEach(g -> pw.println(g.getName()));
  }

  private void demoDistinct(){
    pw.println("\nEach part used in first 2 gadgets");
    gadgets.stream()
            .limit(2)
            .flatMap(g -> g.getParts().stream())
            .distinct()
            .forEach(p -> pw.println(p.getName()));
  }

  public StreamOperations(){
    gadgets.addAll(StreamHelper.provideGadgetList());
    demoSorted();
    demoMap();
    demoFlatMap();
    demoLimit();
    demoDistinct();
  }

  public static void main(String[] args){
    new StreamOperations();
  }
}
