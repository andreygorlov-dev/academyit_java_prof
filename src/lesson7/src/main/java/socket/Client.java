package socket;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket socket;

    public static void main(String[] args) throws IOException {

        socket = new Socket("127.0.0.1", 4004);

        System.out.println("Подключен");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("Привет! мир \n");

        bufferedWriter.flush();

        String data = reader.readLine();
        System.out.println(data);
    }

}
