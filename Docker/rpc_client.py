# Importing the xmlrpc client module to communicate with the RPC server
import xmlrpc.client

try:
    # Connect to the RPC server running inside Docker on localhost
    server = xmlrpc.client.ServerProxy("http://localhost:8000/")

    # Calling remote procedures hosted on the server
    print("Addition:", server.add(5, 3))
    print("Subtraction:", server.subtract(10, 4))
    print("Multiplication:", server.multiply(6, 7))
    print("Division:", server.divide(20, 5))

    # Calling division with zero to test error handling
    print("Division by zero:", server.divide(10, 0))

# If Docker container/server is not running
except ConnectionRefusedError:
    print("Error: Could not connect to the Docker RPC server.")

# Handles any other unexpected errors
except Exception as e:
    print("Unexpected error:", str(e))
