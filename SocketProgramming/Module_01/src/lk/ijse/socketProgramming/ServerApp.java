package lk.ijse.socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
public class ServerApp {
    public static void main(String[] args) throws IOException {
        final int PORT = 8000;
        ServerSocket serverSocket = new ServerSocket(PORT); // localhost = 127.0.0.1

        System.out.println("Server is running in port: " + PORT);

        Socket localSocket = serverSocket.accept();
        System.out.println("Port " + localSocket.getPort());
        System.out.println("IP " + localSocket.getInetAddress());

        InputStreamReader inputStreamReader
                = new InputStreamReader(localSocket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String clientMsg = bufferedReader.readLine();

        System.out.println("Client says : "+ clientMsg);

    }
}
