package FileSocket;

import memo.WriteMemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private Write write = new Write();
    private DataOutputStream dataOutputStream = null;
    private ServerSocket server = null;
    private Socket client = null;

    public static void main(String[] args) {
        Server sample = new Server();
        sample.startServer();
    }

    public void startServer() {
        try {
            server = new ServerSocket(9999);
            StringBuffer buffer = new StringBuffer();
            while(true) {
                System.out.println("Server : Waiting for request.");
                client = server.accept();
                System.out.println("Server : Accepted.");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = in.readLine();

                System.out.println("Received data:" + data);

                if (data.equals("complete")) {
                    write.WriteText(buffer.toString());
                } else {
                    buffer.append(data);
                }

//                OutputStream outputStream = client.getOutputStream();
//                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
//                byte[] ascii = data.toString().getBytes(StandardCharsets.US_ASCII);
//                StringBuffer sb = new StringBuffer();
//                for(byte b : ascii) {
//                    sb.append(String.format("%s ", b));
//                }
//                out.write(sb.toString());
//                out.newLine();
//                out.flush();
//                System.out.println("Return : " + sb.toString());
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

    private void SendFile() {
        try {
            dataOutputStream = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
