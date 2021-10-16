/**
 * Created for assignment 3.3
 * Contains the outline of a complex.
 * 
 * @author Kamron Cole
*/
package products;

import java.util.Random;

public class Complex implements Factory{
    private Factory[] factories;
    private Factory[] usedFactories;
    private Random r = new Random();

    /**
     * create a complex which is a collection of factories
     * @param factories
    */
    public Complex(Factory[] factories) {
        this.factories = factories;
        this.usedFactories = new Factory[factories.length];
    }

    /**
     * returns a product from a random factory
     * Same factory can not be choses twice in a row
    */
    @Override
    public Product manufacture() {
        int fIndex = r.nextInt(factories.length);
        while (factories[fIndex] == null) {
            fIndex = r.nextInt(factories.length);

            boolean factoriesNull = true;
            for(Factory f : factories) {
                if (f != null) {
                    factoriesNull = false;
                    break;
                }
            }

            if (factoriesNull) {
                resetFactories();
            }
        }

        Factory factory = factories[fIndex];
        usedFactories[fIndex] = factory;
        factories[fIndex] = null;
        return factory.manufacture();
    }

    /**
     * helper function to reset usedFactories and Factories arrays
    */
    private void resetFactories() {
        int i = 0;
        for (Factory f : usedFactories) {
            factories[i] = f;
            i++;
        }
    }
}
