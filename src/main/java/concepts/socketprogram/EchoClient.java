package concepts.socketprogram;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by pradeep on 9/6/16.
 */
public class EchoClient {

    static final int FEED_VERSION = 0x46520001;
    static final String PASSWORD = "quah5PiokaeD";

    public static void main(String[] args) {
//        try {
////            System.setProperty("javax.net.ssl.trustStore", "mySrvKeystore");
////            System.setProperty("javax.net.ssl.trustStorePassword", "123456");
//            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 9999);
//
//            InputStream inputstream = System.in;
//            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
//            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
//
//            OutputStream outputstream = sslsocket.getOutputStream();
//            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
//            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
//
//            String string = null;
//            while ((string = bufferedreader.readLine()) != null) {
//                bufferedwriter.write(string + '\n');
//                bufferedwriter.flush();
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

        InputStream caInput = null;
        char[] pwd = "quah5PiokaeD".toCharArray();
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            caInput = new BufferedInputStream(new FileInputStream(
                    "/home/pradeep/gd_bundle-g2-g1.crt"));
            Certificate ca;

            ca = cf.generateCertificate(caInput);
            System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());

            SSLSocket sslSocket = connectToServer(pwd, ca);

            if (sslSocket.isConnected()) {
                System.out.println("Connected...");
                sslSocket.startHandshake();
                writeInputToServer(sslSocket);
                readInputFromServer(sslSocket);
            } else {
                System.out.println("Connect Fails...");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (caInput != null) {
                try {
                    caInput.close();
                    System.out.println("Socket closed!!");
                } catch (IOException exception2) {
                    exception2.printStackTrace();
                }
            }
        }
    }

    private static void readInputFromServer(SSLSocket sock) throws IOException {
        InputStream inputstream = sock.getInputStream();
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

        String data;
        System.out.println("Reading data from server : ");
        while ((data = bufferedreader.readLine()) != null) {
            System.out.println("Data read : ");
            System.out.println(data);
        }
        System.out.println("Data read completed!!");
    }

    private static void writeInputToServer(SSLSocket sslsocket) throws IOException {
        System.out.println("Writing data from server : ");
        OutputStream outputstream = sslsocket.getOutputStream();
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
        BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);

        bufferedwriter.write(FEED_VERSION);
        bufferedwriter.flush();

        System.out.println("Data write completed!!");

    }

    private static SSLSocket connectToServer(char[] pwd, Certificate ca) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, KeyManagementException {
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, pwd);
        keyStore.setCertificateEntry("ca", ca);

        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);

        SSLSocket sslSocket = (SSLSocket) context.getSocketFactory()
                .createSocket("livefeed.flightradar24.com", 4652);
        sslSocket.setUseClientMode(true);

        String[] suites = sslSocket.getSupportedCipherSuites();
        sslSocket.setEnabledCipherSuites(suites);

        return sslSocket;
    }
}
