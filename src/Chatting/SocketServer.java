package Chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class SocketServer {
    public static void main(String[] args) {
        SocketServer sample = new SocketServer();
        sample.startServer();
    }

    public void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while(true) {
                System.out.println("Server : Waiting for request.");
                client = server.accept();
                System.out.println("Server : Accepted.");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = in.readLine();

                System.out.println("Received data:" + data);


                OutputStream outputStream = client.getOutputStream();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
                byte[] ascii = data.toString().getBytes(StandardCharsets.US_ASCII);
                StringBuffer sb = new StringBuffer();
                for(byte b : ascii) {
                    sb.append(String.format("%s ", b));
                }
                out.write(sb.toString());
                out.newLine();
                out.flush();
                System.out.println("Return : " + sb.toString());
                System.out.println("----------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
