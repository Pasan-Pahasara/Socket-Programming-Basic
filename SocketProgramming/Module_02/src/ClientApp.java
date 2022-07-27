import java.io.*;
import java.net.Socket;

/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
public class ClientApp {
    public static void main(String[] args) {
        final int PORT = 8000;
        try {
            Socket socket = new Socket("localhost", PORT);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "", reply = "";

            while (!message.equals("finish")) {
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);

                message = dataInputStream.readUTF();
                System.out.println("Server says , :" + message);
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
