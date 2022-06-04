package Chatting;

import socket.SocketClientSample;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        SocketClient sample = new SocketClient();
        sample.sendSocket();
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
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            out.close();

            if (data == "exit")  {
                InputStream inputStream = socket.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String inputData = null;
                StringBuilder receivedData = new StringBuilder();
                while((inputData = in.readLine()) != null) {
                    receivedData.append(inputData);
                }
                System.out.println("Received data:" + receivedData);
                in.close();
                inputStream.close();
            }

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
