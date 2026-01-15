# Importing the xmlrpc client module to communicate with the RPC server
import xmlrpc.client

try:
    # Creating a proxy object to connect to the remote RPC server
    server = xmlrpc.client.ServerProxy("http://13.48.249.5:8000/")

    # Calling remote procedures hosted on the server
    print("Addition:", server.add(5, 3))
    print("Subtraction:", server.subtract(10, 4))
    print("Multiplication:", server.multiply(6, 7))
    print("Division:", server.divide(20, 5))

    # Calling division with zero to test error handling
    print("Division by zero:", server.divide(10, 0))

# This exception is raised if the server is unreachable
except ConnectionRefusedError:
    print("Error: Could not connect to the server.")

# This block handles any other unexpected errors
except Exception as e:
    print("Unexpected error:", str(e))
