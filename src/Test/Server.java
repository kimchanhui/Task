package Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        Server sample = new Server();
        sample.startServer();
    }

    private void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("-------------::: Accept :::-----------");
                System.out.println("Server:Accepted");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = in.readLine();

                System.out.println("Received data:" + data);

                String request = data;

                int no_1;
                int no_2;
                int i;
                int result;

                if (data.contains("+")) {
                    i = data.indexOf("+");
                    no_1 = Integer.parseInt(data.substring(0, i));
                    no_2 = Integer.parseInt(data.substring(i+1, data.length()));
                    result = no_1 + no_2;
                    data = String.valueOf(result);
                } else if (data.contains("-")){
                    i = data.indexOf("-");
                    no_1 = Integer.parseInt(data.substring(0, i));
                    no_2 = Integer.parseInt(data.substring(i+1, data.length()));
                    result = no_1 - no_2;
                    data = String.valueOf(result);
                } else if (data.contains("/")){
                    i = data.indexOf("/");
                    no_1 = Integer.parseInt(data.substring(0, i));
                    no_2 = Integer.parseInt(data.substring(i+1, data.length()));
                    result = no_1 / no_2;
                    data = String.valueOf(result);
                } else if (data.contains("*")){
                    i = data.indexOf("*");
                    no_1 = Integer.parseInt(data.substring(0, i));
                    no_2 = Integer.parseInt(data.substring(i+1, data.length()));
                    result = no_1 * no_2;
                    data = String.valueOf(result);
                } else if (data.equals("EXIT")) {

                } else {
                    data = "Not Defined Command";
                }

                String response = data;

                OutputStream outStream = client.getOutputStream();
                BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ) );

                StringBuffer sb = new StringBuffer();
                sb.append(data);
                out.write(sb.toString());
                out.newLine();
                out.flush();
                System.out.println("Return : "+sb.toString());
                System.out.println("--------::: End :::---------");

                WriteFile(request, response, client.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static File file = new File("C:\\textFolder\\file.txt");
    private void WriteFile(String request, String response, String ip) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd- HH:mm:ss");
        Date time = new Date();


        String text = format.format(time) + "-" + ip + " : " + request + " > " + response;

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            bufferedWriter.write(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}