# Importing the SimpleXMLRPCServer class to create an RPC server
from xmlrpc.server import SimpleXMLRPCServer

# Remote procedure to perform addition
def add(a, b):
    print("Performing addition on server")
    return a + b

# Remote procedure to perform subtraction
def subtract(a, b):
    print("Performing subtraction on server")
    return a - b

# Remote procedure to perform multiplication
def multiply(a, b):
    print("Performing multiplication on server")
    return a * b

# Remote procedure to perform division
def divide(a, b):
    # Handling division by zero error
    if b == 0:
        return "Error: Division by zero"
    
    print("Performing division on server")
    return a / b

# Creating the RPC server object
# "0.0.0.0" allows the server to accept requests from any external client
# 8000 is the port number on which the server will listen
server = SimpleXMLRPCServer(("0.0.0.0", 8000))

print("RPC Server is running on port 8000...")

# Registering all functions so that clients can call them remotely
server.register_function(add, "add")
server.register_function(subtract, "subtract")
server.register_function(multiply, "multiply")
server.register_function(divide, "divide")

# Keeps the server running continuously
# The server will wait for incoming client requests
server.serve_forever()
