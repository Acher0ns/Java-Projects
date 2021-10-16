/**
 * Problem Solving 1:
 * 
 * Name:            Type:           Super Class:
 * Toy              Abstract        N/A
 * Robot            Class           Toy
 * Doll             Class           Toy
 * Action Figure    Class           Doll
 * 
 * 
 * 
 * Problem Solving 2:
 * 
 * Class:       State:          Behavior:
 * Toy          Product Code    Play
 *              Name
 *              MSRP
 * 
 * Robot        Charge          play
 *              "Sound"         
 * 
 * Doll         Hair Color      Play   
 *              Eye Color
 *              Phrases
 * 
 * 
 * 
 * Problem Solving 3:
 * 
 * Saved as "pss1-Toy-Class-Diagram.pdf"
 * 
 * 
 * 
 * Problem Solving 4:
 * 
 * public abstract class Toy {
 *     private final int productCode;
 *     private final String name;
 *     private final double msrp;
 * 
 *     public abstract void play();
 * 
 *     public Toy(int productCode, String name, double msrp) {
 *         this.productCode = productCode;
 *         this.name = name;
 *         this.msrp = msrp;
 *     }
 * }
*/
