/**
 * Created for assignment 3.3
 * Creates 2 toy factories and makes them a complex.
 * Creats an empty truck and loads it. Then unloads the truck and prints each product.
 * 
 * This class represents polymorphism because now I can create products that are not toys and
 * my Truck class will not have to change at all to account new Product types
 * 
 * @author Kamron Cole
*/
package toys;

import products.*;

public class Main {
    public static void main(String[] args) {
        RobotFactory rf = new RobotFactory();
        DollFactory df = new DollFactory();
        Factory[] factories = new Factory[]{df, rf};
        Complex toyComplex = new Complex(factories);
        Truck gm = new Truck(5);

        while (!gm.isFull()) {
            gm.load(toyComplex.manufacture());
        }

        while(!gm.isEmpty()) {
            Product unloaded = gm.unload();
            System.out.println(unloaded);
        }
    }
}
