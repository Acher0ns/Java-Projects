/**
 * Created for assignment 3.3
 * Contains the outline of a product.
 * 
 * @author Kamron Cole
*/
package products;

public class Product {
    private static int NUM_OF_PRODUCTS; // Used to assign unique products codes
    private String name;
    private final int productCode;
    private final double msrp;

    public Product(String name, double msrp) {
        this.name = name;
        this.msrp = msrp;
        this.productCode = 1000000 + NUM_OF_PRODUCTS;
        NUM_OF_PRODUCTS++;
    }

    /**
     * returns string in format "Name{productCode=<productCode>, MSRP=<MSRP>}"
    */
    @Override
    public String toString() {
        return this.name + "{productCode=<" + this.productCode + ">, MSRP=<" + this.msrp + ">}";
    }

    /**
     * @return Return product name
    */
    public String getName() {
        return name;
    }

    /**
     * @return Return product Product Code
    */
    public int getProductCode() {
        return productCode;
    }

    /**
     * @return Return product MSRP (Cost)
    */
    public double getMsrp() {
        return msrp;
    }
}
