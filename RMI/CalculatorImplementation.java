import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation class of the remote interface
// This class provides the actual logic for the remote methods
// It extends UnicastRemoteObject to make the object available for remote calls
public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {

    // Constructor
    protected CalculatorImplementation() throws RemoteException {
        super();
    }

    // Remote method to perform addition
    // This method is invoked remotely by the client
    public int add(int a, int b) throws RemoteException {
        System.out.println("Server Log: Adding " + a + " with " + b);
        return a + b;
    }

    // Remote method to perform subtraction
    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Server Log: Subtracting " + b + " from " + a);
        return a - b;
    }

    // Remote method to perform multiplication
    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Server Log: Multiplying " + a + " with " + b);
        return a * b;
    }

    // Remote method to perform division
    // Includes error handling for division by zero
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            System.out.println("Server Log: Division by zero attempted with " + a + " and " + b);
            throw new RemoteException("Division by zero not allowed");
        }
        System.out.println("Server Log: Dividing " + a + " by " + b);
        return (double) a / b;
    }
}
