import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(1234)) {

            while (true) {
                Socket client = server.accept();

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                out.writeUTF("sup client");

                in.close();
                out.close();
                client.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
