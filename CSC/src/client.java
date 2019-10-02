import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client {
public static void main(String[] args) {
    try(Socket s = new Socket("localhost", 1234)) {
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        System.out.println("sup server!");

        out.writeUTF("sup server");

        String m = in.readUTF();
        System.out.println(m);

        in.close();
        out.close();
        s.close();
    }catch (Exception e) {
        e.printStackTrace();
    }
}
}
