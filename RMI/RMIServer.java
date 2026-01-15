import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Set the public IP of the AWS server
            System.setProperty("java.rmi.server.hostname", "13.48.249.5");

            // Create the remote object
            CalculatorImplementation calc = new CalculatorImplementation();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object with a name
            registry.rebind("CalculatorService", calc);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
            e.printStackTrace();
        }
    }
}
