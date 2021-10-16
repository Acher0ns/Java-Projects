/**
 * Problem Solving 1:
 * 
 * Name:                Type:       Parent/Interfaces?
 * Product              Abstract    N/A
 * Truck                Class       N/A
 * Factory              Interface   N/A
 * Complex              Class       N/A
 * Microwave            Class       Product
 * Microwave Factory    Class       Factory
 * 
 * (↑ Something like that ↑)
 * 
 * 
 * 
 * Problem Solving 2:
 * 
 * Type:                State:          Behavior:
 * Product              Name            N/A
 *                      Product Code
 *                      MSRP
 * 
 * Truck                Capacity        Load
 *                      currentLoad     Unload
 * 
 * Factory              N/A             Manufacture(Make)
 * 
 * Microwave Factory    N/A             Manufacture(Make)
 * 
 * (↑ Something like that ↑)
 * 
 * 
 * 
 * Problem Solving 3:
 * 
 * Saved as "pss2-Class-Diagram.pdf"
 * 
 * 
 * 
 * Problem Solving 4:
 * 
 * public class Truck {
 *     private Product[] products;
 *     private int numLoaded;
 * 
 *     public Truck(int capacity) {
 *         this.products= new product[capacity];
 *         this.numLoaded = 0;
 *     }
 * 
 *     public boolean isFull() {
 *         return numLoaded == products.length;
 *     }
 * 
 *     public boolean isEmpty() {
 *         return numLoaded == 0;
 *     }
 * 
 *     public void load(Product product) {
 *         if(!isFull()) {
 *             products[loaded] = product;
 *             numLoaded++;
 *         }
 *     }
 * 
 *     public Product unload() {
 *         if(!isEmpty()) {
 *             loaded--;
 *             Product product = products[loaded];
 *             products[loaded] = null;
 *             return product;
 *         } else {
 *             return null;
 *         }
 *     }
 * } 
*/