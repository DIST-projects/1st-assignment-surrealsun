import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface for the Calculator service
// This interface defines the methods that can be invoked remotely by the client
public interface Calculator extends Remote {
    
    // Remote method to perform addition of two integers
    int add(int a, int b) throws RemoteException;
    // Throws RemoteException to handle network-related errors

    // Remote method to perform subtraction
    int subtract(int a, int b) throws RemoteException;

    // Remote method to perform multiplication
    int multiply(int a, int b) throws RemoteException;

    // Remote method to perform division
    double divide(int a, int b) throws RemoteException;
}
