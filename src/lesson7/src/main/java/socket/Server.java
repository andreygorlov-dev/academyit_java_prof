package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket socket;

    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(4004);
        System.out.println("Server start");

        socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String data = reader.readLine();
        System.out.println(data);

        bufferedWriter.write("Успешное подключение! " + data + "\n");

        bufferedWriter.flush();
    }
}
