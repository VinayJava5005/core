package concepts.socketprogram;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@SuppressWarnings("unused")
public class Socket {
    public static void main(String[] args) throws KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException, CertificateException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        PrintStream out = System.out;

        char ksPass[] = "quah5PiokaeD".toCharArray();
        char ctPass[] = "quah5PiokaeD".toCharArray();
        SSLSocketFactory f =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket c =
                    (SSLSocket) f.createSocket("livefeed.flightradar24.com", 4652);
            c.setUseClientMode(true);
            c.startHandshake();
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode("RlIAAQ==");
            OutputStream dos = c.getOutputStream();
            dos.write(bytes);

            InputStream socketInputStream = c.getInputStream();

            MessageDigest passHash = MessageDigest.getInstance("MD5");
            passHash.update("quah5PiokaeD".getBytes("UTF-8"));
            byte[] digest = passHash.digest();

            byte[] challange = new byte[16];
            socketInputStream.read(challange);
            MessageDigest respHash = MessageDigest.getInstance("MD5");
            respHash.update(digest);
            respHash.update(challange);
            byte[] response = respHash.digest();

            dos.write(response);
            int r = 0;
            System.out.println("Fetching Data.........");
            byte[] header = new byte[24];
            int header_data = socketInputStream.read(header);
            System.out.println("header_data : " + header_data);


            InputStream inputStream = new ByteArrayInputStream(header);
            DataInputStream inputcontent = new DataInputStream(inputStream);
            int sequence = inputcontent.readInt();
            int comp_size = inputcontent.readInt();
            int full_size = inputcontent.readInt();
            int aircraft_count = inputcontent.readInt();
            long epoch = inputcontent.readLong();
            System.out.println(sequence + "," + comp_size + "," + full_size + "," + aircraft_count + "," + epoch);

            byte[] gzipData = new byte[comp_size];
            socketInputStream.read(gzipData);

            Inflater decompressor = new Inflater();
            decompressor.setInput(gzipData);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(gzipData.length);
            byte[] buf = new byte[full_size];
            while (!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);

            }
            System.out.println(new String(buf));


            c.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.toString());
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static void printSocketInfo(SSLSocket s) {
        System.out.println("Socket class: " + s.getClass());
        System.out.println("   Remote address = "
                + s.getInetAddress().toString());
        System.out.println("   Remote port = " + s.getPort());
        System.out.println("   Local Socket address = "
                + s.getLocalSocketAddress().toString());
        System.out.println("   Local address = "
                + s.getLocalAddress().toString());
        System.out.println("   Local port = " + s.getLocalPort());
        System.out.println("   Need client authentication = "
                + s.getNeedClientAuth());
        SSLSession ss = s.getSession();
        System.out.println("   Cipher suite = " + ss.getCipherSuite());
        System.out.println("   Protocol = " + ss.getProtocol());
    }
}
