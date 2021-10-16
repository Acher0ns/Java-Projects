/**
 * Created for assignment 3.3
 * Contains the outline of a truck.
 * Each truck can me loaded and unloaded
 * each truck has its own capacity
 * 
 * @author Kamron Cole
*/
package products;

public class Truck {
       private Product[] products;
       private int numLoaded;
   
       /**
        * Each truck can me loaded and unloaded
        * each truck has its own capacity
        * @param capacity how many products the truck can hold
        */
       public Truck(int capacity) {
           this.products= new Product[capacity];
           this.numLoaded = 0;
       }
   
       /**
        * @return whether the truck is full
        */
       public boolean isFull() {
           return numLoaded == products.length;
       }
   
       /**
        * @return whether the truck is empty
        */
       public boolean isEmpty() {
           return numLoaded == 0;
       }
   
       /**
        * Loads the truck from front to back
        * @param product
        */
       public void load(Product product) {
           if(!isFull()) {
               products[numLoaded] = product;
               numLoaded++;
           }
       }
   
        /**
        * Unloads the truck from back to front
        * @param product
        */
       public Product unload() {
           if(!isEmpty()) {
            numLoaded--;
               Product product = products[numLoaded];
               products[numLoaded] = null;
               return product;
           } else {
               return null;
           }
       }
   } 
