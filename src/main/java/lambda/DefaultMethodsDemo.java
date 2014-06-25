package main.java.lambda;

import java.io.PrintWriter;

import main.java.impl.InstantCoffeeMaker;
import main.java.impl.PoshCoffeeMaker;
import main.java.interfaces.CoffeeMaker;
import main.java.model.Coffee;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 20/06/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultMethodsDemo {
  private static PrintWriter pw = new PrintWriter(System.out, true);

  public static void describeCoffee(Coffee coffee){
    pw.println("Coffee made: " + coffee.getName() + ", has strength " + coffee.getStrength());
    pw.println("Style is: " + coffee.getStyle());
  }

  public static void main(String[] args){
    CoffeeMaker instantCoffeeMaker = new InstantCoffeeMaker();
    CoffeeMaker poshCoffeeMaker = new PoshCoffeeMaker();
    Coffee coffee1 = new Coffee("Nescafe", -1.9);
    Coffee coffee2 = new Coffee("Santos", 5);
    Coffee brewed1 = instantCoffeeMaker.makeCoffee(() -> coffee1 );
    Coffee brewed2 = poshCoffeeMaker.makeCoffee(() -> coffee2);

    pw.println("The instant coffee maker does not extend makeCoffee, but still works");
    describeCoffee(brewed1);

    pw.println("The posh coffee maker overrides the default implementation of makeCoffee");
    describeCoffee(brewed2);
  }
}
