package ca.nait.dmit2015;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a circle with a default radius
//        Circle circle1 = new Circle();
        var circle1 = new Circle();
        // Print the radius, diameter, perimeter, and area to Console
        String message = String.format(
                "Radius: %s, Diameter: %s, Perimeter: %.2f, Area: %.3f",
                circle1.getRadius(),
                circle1.diameter(),
                circle1.perimeter(),
                circle1.area()
                );
        System.out.println(message);
        // Change the radius to 5
        circle1.setRadius(5);
        message = String.format(
                "Radius: %s, Diameter: %s, Perimeter: %.2f, Area: %.3f",
                circle1.getRadius(),
                circle1.diameter(),
                circle1.perimeter(),
                circle1.area()
        );
        System.out.println(message);
        // Create a new circle with a radius of -100
        Circle circle2 = new Circle(-100);
        message = String.format(
                "Radius: %s, Diameter: %s, Perimeter: %.2f, Area: %.3f",
                circle2.getRadius(),
                circle2.diameter(),
                circle2.perimeter(),
                circle2.area()
        );
        System.out.println(message);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}