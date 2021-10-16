/**
 * Created for assignment 3.2
 * Contains the outline of a toy.
 * 
 * @author Kamron Cole
*/
package toys;

import products.Product;

public abstract class Toy extends Product {
    public abstract void play(); // Each toy needs to do something when played with

    /**
     * Creates a toy
     * 
     * @param msrp Cost of toy
     * @param name Type of Toy (usually class name)
    */
    public Toy(double msrp, String name) {
        super(name, msrp);
    }

    /**
     * returns string in format "Name{productCode=<productCode>, MSRP=<MSRP>}"
    */
    @Override
    public String toString() {
        return getName() + "{productCode=<" + getProductCode() + ">, MSRP=<" + getMsrp() + ">}";
    }
}
