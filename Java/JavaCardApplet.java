package classicapplet1;

import javacard.framework.*;

public class JavaCardApplet extends Applet {
    private byte[] received;
    private static final short MAX_LENGTH = 256;
    private static final byte[] helloFidesmo = {(byte)'H',(byte)'e',(byte)'l',(byte)'l',(byte)'o',(byte)' ',(byte)'F',(byte)'i',(byte)'d',(byte)'e',(byte)'s',(byte)'m',(byte)'o',(byte)'!'};
    
public static void install(byte[] bArray, short bOffset, byte bLength) {
        new JavaCardApplet();
    }
    
    protected JavaCardApplet() {
        received = new byte[MAX_LENGTH];
        register();
    }
    public void process(APDU apdu) {
        byte buffer[] = apdu.getBuffer();
        short length = (short) helloFidesmo.length;
        Util.arrayCopyNonAtomic(helloFidesmo, (short)0, buffer, (short)0, (short)length);
        apdu.setOutgoingAndSend((short)0, length);
    }
}
