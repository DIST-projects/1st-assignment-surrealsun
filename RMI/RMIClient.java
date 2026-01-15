import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry on the AWS server
            Registry registry = LocateRegistry.getRegistry("13.48.249.5", 1099);

            // Look up the remote object by name
            Calculator calc = (Calculator) registry.lookup("CalculatorService");

            // Call remote methods
            System.out.println("Addition: " + calc.add(5, 3));
            System.out.println("Subtraction: " + calc.subtract(10, 4));
            System.out.println("Multiplication: " + calc.multiply(6, 7));
            System.out.println("Division: " + calc.divide(20, 5));

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
