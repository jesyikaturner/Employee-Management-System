package sci_work;
import java.math.*;

public class SignedMessageEncryption {
	
	/*
	 * Encryption and Decryption of signed messages using the RSA algorithm. 
	 */
	
	public static void main(String[] args) {
		SignedMessageEncryption sme = new SignedMessageEncryption();
		BigInteger p = new BigInteger("10009");
		BigInteger q = new BigInteger("9739");
		BigInteger e = new BigInteger("5737");
		
		BigInteger message = new BigInteger("7001");
		
		BigInteger[] publicKeys = sme.generatePublicKeys(p, q, e);
		BigInteger privateKey = sme.generatePrivateKey(p, q, e);
		
		BigInteger signedEncryptedMessage = sme.sMessageEncryption(privateKey, message, publicKeys[0]);
		BigInteger decryptedSignedMessage = sme.decryptSMessage(publicKeys, signedEncryptedMessage);
		System.out.println(signedEncryptedMessage);
		System.out.println(decryptedSignedMessage);
	}
	
	// return [0] n, [1] is e
	public BigInteger[] generatePublicKeys(BigInteger p, BigInteger q, BigInteger e) {
		BigInteger[] temp = new BigInteger[2];
		temp[0] = p.multiply(q);
		temp[1] = e;
		return temp;
	}
	
	public BigInteger generatePrivateKey(BigInteger p, BigInteger q, BigInteger e) {
		//u(n) = (p-1).(q-1)
		BigInteger a = (p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));
		//e^-1 mod u(n)
		BigInteger b = e.modPow(BigInteger.valueOf(-1), a);
		
		return b;
	}
	
	// m^d mod n, where m is Message, d is privateKey and n is publicKey[0]
	public BigInteger sMessageEncryption(BigInteger privateKey, BigInteger message, BigInteger n) {
		return message.modPow(privateKey, n);
	}
	
	// s^e mod n, where s is the sMessage, e is publicKey[1] and n is publicKey[0]
	public BigInteger decryptSMessage(BigInteger[] publicKeys, BigInteger sMessage) {
		return sMessage.modPow(publicKeys[1], publicKeys[0]);
	}

}
