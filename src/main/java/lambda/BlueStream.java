package main.java.lambda;

import java.awt.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.helpers.StreamHelper;
import main.java.model.Gadget;
import static java.awt.Color.*;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 23/06/14
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class BlueStream {
  List<Gadget> gadgets = new ArrayList<>();
  PrintWriter pw = new PrintWriter(System.out, true);

  public BlueStream(){
    gadgets.addAll(StreamHelper.provideGadgetList());
    List<Gadget> blueGadgets = gadgets.stream().filter(g -> g.getColor() == BLUE).collect(Collectors.toList());
    pw.println("Should return gadgets 1 and 4");
    blueGadgets.stream().forEach(g -> pw.println(g.getName()));
  }

  public static void main(String[] args){
    new BlueStream();
  }
}
