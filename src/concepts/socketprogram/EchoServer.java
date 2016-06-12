package concepts.socketprogram;

import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*keytool -genkey -keystore mySrvKeystore -keyalg RSA*/

/**
 * Created by pradeep on 9/6/16.
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
//            System.setProperty("javax.net.ssl.keyStore", "mySrvKeystore");
//            System.setProperty("javax.net.ssl.keyStorePassword", "123456");
            SSLServerSocketFactory sslserversocketfactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket =
                    (SSLServerSocket) sslserversocketfactory.createServerSocket(9999);
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();

            InputStream inputstream = sslsocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
