package concepts.socketprogram;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

/**
 * Created by pradeep on 17/6/16.
 */
public class HandshakeListener implements HandshakeCompletedListener {

    @Override
    public void handshakeCompleted(HandshakeCompletedEvent e) {
        System.out.println("Handshake succesful!");
    }
}