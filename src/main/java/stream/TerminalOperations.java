package main.java.stream;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import main.java.helpers.StreamHelper;
import main.java.model.Gadget;
import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 23/06/14
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TerminalOperations {
  List<Gadget> gadgets = new ArrayList<>();
  PrintWriter pw = new PrintWriter(System.out, true);

  private void demoListIntoSet(){

    Set<Gadget> gadgetSet = gadgets.stream().collect(Collectors.toSet());
    pw.println("Made a set from gadgetList. Compiler chooses the name");
    pw.println("It's a " + gadgetSet.getClass().getName());
    pw.println("I want a LinkedHashSet!");
    Set<Gadget> gadgetSet2 = gadgets.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    pw.println("This one's a " + gadgetSet2.getClass().getName());
  }

  private void demoAnyMatch(){
    pw.println("\nDid Thomas Edison invent any of the gadgets?");
    boolean isEdison = gadgets.stream().anyMatch(g -> g.getInventor().equalsIgnoreCase("Thomas Edison"));
    pw.println(isEdison?"Yes":"No");
  }

  private void demoMapReduce(){
    pw.println("Count how many parts there are in the gadgets");
    int totalNumParts = gadgets.stream().map(g -> g.getParts().size()).reduce(0, Integer::sum);
    pw.println("There are " + totalNumParts + " parts");
  }

  private void demoListOfInventors(){
    pw.println("\nA comma-delimited list of inventors");
    pw.println(gadgets.stream()
            .map(g -> g.getInventor()).distinct()
            .collect(joining(", ")));
  }

  private void demoAverageParts(){
    pw.println("\nThe average number of parts per gadget");
    double averageParts = gadgets.stream().collect(averagingInt(gadget -> gadget.getParts().size()));
    pw.println(averageParts);

  }

  private void demoGroupingBy(){
    pw.println("\nInventors and how many gadgets they built");
    Map<String, List<Gadget>> gadgetsByInventor = gadgets.stream()
            .collect(groupingBy(gadget -> gadget.getInventor()));
    gadgetsByInventor.forEach((inventor, gadgetList) -> pw.println(inventor + " built "
            + gadgetList.size() + (gadgetList.size() == 1 ? " gadget" : " gadgets")));
  }

  private void demoDownstreamCollector(){
    pw.println("\nInventors and the gadgets they built");
    Map<String, List<String>> gadgetNamesByInventor = gadgets.stream()
            .collect(groupingBy(Gadget::getInventor, mapping(Gadget::getName, toList())));
    gadgetNamesByInventor.forEach((inventor, gadgetNames) ->
                              {pw.println(inventor);
                                gadgetNames.forEach(gName -> pw.println("-" +gName));
                              });
  }

  public TerminalOperations(){
    gadgets.addAll(StreamHelper.provideGadgetList());
    demoListIntoSet();
    demoAnyMatch();
    demoMapReduce();
    demoListOfInventors();
    demoAverageParts();
    demoGroupingBy();
    demoDownstreamCollector();
  }

  public static void main(String[] args){
    new TerminalOperations();
  }
}
