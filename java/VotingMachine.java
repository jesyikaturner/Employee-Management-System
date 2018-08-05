package sci_work;
import java.math.*;

public class VotingMachine {
	
	/*
	 * Uses the Paillier cryptosystem to encrypt and decrypt messages.
	 * Using BigInteger to handle the huge numbers -- could be better optimised...
	 */
	
	public static void main(String[] args) {
		VotingMachine vm = new VotingMachine();
		
		BigInteger p, q, g;
		
		int a = 59, b = 97;
		
		p = new BigInteger(""+a);
		q = new BigInteger(""+b);
		g = new BigInteger("5724");
		
		// Generating the public and private keys.
		BigInteger[] publicKeys = vm.GeneratePublicKeys(p,q,g);
		BigInteger[] privateKeys = vm.GeneratePrivateKeys(vm.findLCM(a-1,b-1),publicKeys);
		
		// generating all the votes and encrypting them.
		BigInteger[] votes = new BigInteger[7];
		votes[0] = vm.encryption(publicKeys,new BigInteger("8"), new BigInteger("90"));
		votes[1] = vm.encryption(publicKeys,new BigInteger("1"), new BigInteger("91"));
		votes[2] = vm.encryption(publicKeys,new BigInteger("8"), new BigInteger("92"));
		votes[3] = vm.encryption(publicKeys,new BigInteger("1"), new BigInteger("93"));
		votes[4] = vm.encryption(publicKeys,new BigInteger("8"), new BigInteger("94"));
		votes[5] = vm.encryption(publicKeys,new BigInteger("1"), new BigInteger("95"));
		votes[6] = vm.encryption(publicKeys,new BigInteger("8"), new BigInteger("96"));
		
		// adding all the encrypted messages together
		BigInteger encryptedKey = vm.addEncryptedMessagesTogether(votes,publicKeys[0]);
		
		// Decrypts the messages
		System.out.println(vm.decryption(privateKeys, encryptedKey, publicKeys[0]));
	}
	
	// Takes in p, q, g. Returns [0] N and [1] G.
	public BigInteger[] GeneratePublicKeys(BigInteger a, BigInteger b, BigInteger c) {
		BigInteger[] temp = new BigInteger[2];
		temp[0] = a.multiply(b);
		temp[1] = c;
		return temp;
	}
	
	// takes in lcm of p-1 and q-1, and the public keys. Returns [0] lcm and [1] u
	public BigInteger[] GeneratePrivateKeys(long lcm, BigInteger[] publicKeys) {
		if(publicKeys.length != 2)
			return null;
		BigInteger[] temp = new BigInteger[2];
		
		temp[0] = BigInteger.valueOf(lcm);
		//(g^lcm) mod n^2
		BigInteger ltemp = publicKeys[1].modPow(temp[0], publicKeys[0].pow(2));
		temp[1] = lFunc(ltemp, publicKeys[0]);
		temp[1] = temp[1].modPow(new BigInteger("-1"),publicKeys[0]);
		return temp;
	}
	
	// l(x) = (x-1)/n
	private BigInteger lFunc(BigInteger num, BigInteger n) {
		return (num.subtract(new BigInteger("1"))).divide(n);
	}
	
	// finds the lowest common multiple for a and b.
	public long findLCM(long a, long b) {
		long lcm =  (a > b) ? a : b;
		
        while(true){
            if (lcm % a == 0 && lcm % b == 0) {
                break;
            }
            lcm++;
        }
		
		return lcm;
	}
	
	//g^m.r^n mod n^2
	public BigInteger encryption(BigInteger[] publicKeys, BigInteger m, BigInteger r) {
		return ((publicKeys[1].pow(m.intValue())).multiply(r.pow(publicKeys[0].intValue()))).mod(publicKeys[0].pow(2));
	}
	
	// (L(c^lcm mod n^2)).u mod n, where c is the encrypted message
	public BigInteger decryption(BigInteger[] privateKeys, BigInteger c, BigInteger n) {
		return ((lFunc((c.pow(privateKeys[0].intValue())).mod(n.pow(2)),n)).multiply(privateKeys[1])).mod(n);
	}
	
	// v1 * v2 * v3 ... mod n^2
	public BigInteger addEncryptedMessagesTogether(BigInteger[] voteArray, BigInteger n) {
		BigInteger temp = new BigInteger("1");
		for(int i = 0; i < voteArray.length; i++) {
			temp = temp.multiply(voteArray[i]);
		}
		return temp.mod(n.pow(2));
	}
	
}
