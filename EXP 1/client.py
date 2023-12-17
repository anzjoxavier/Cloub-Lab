import socket

def start_client():
    
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_address = ('localhost', 12345)
    try:
        client_socket.connect(server_address)
        message = "Hello, server!"
        client_socket.sendall(message.encode())
        data = client_socket.recv(1024)
        print(f"Sent: {data.decode()}")
    finally:
        client_socket.close()
if __name__ == '__main__':
    start_client()


