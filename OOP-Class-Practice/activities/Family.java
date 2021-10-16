package activities;

public class Family {
    public static void printParent(Parent parent) {
        System.out.println(parent);
    }

    public static void printChild(Child child) {
        System.out.println(child);
    }

    public static void main(String[] args) {
        Parent p = new Parent("Darth Vader");
        Child c = new Child("Luke", 23);

        printParent(p);
        printChild(c);

        Parent c1 = new Child("R2D2", 200);
        //Child daughter = new Parent("Sue");
        
        printParent(c1);
        printChild((Child)c);
        // printChild((Child)p);

        Parent p2 = c;
        printParent(p2);
        printChild((Child)p2);
    }
}
