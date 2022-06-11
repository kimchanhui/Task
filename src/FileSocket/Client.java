package FileSocket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.sendSocket();
    }

    private void sendSocket() {
        boolean loop = true;
        while (loop) {
            sendSocketData();
        }
    }

    private void sendSocketData() {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            Thread.sleep(1000);

            System.out.print("Send data : ");
            String data = scanner.nextLine();

            OutputStream stream = socket.getOutputStream();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream));
            out.write(data);
            out.newLine();
            out.flush();

//            InputStream inputStream = socket.getInputStream();
//            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//            String receivedData = in.readLine();
//            System.out.println("Received data:" + receivedData);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
