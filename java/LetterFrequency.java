package sci_work;

public class LetterFrequency {
	
	private String _alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int[] _numberfreq = new int[26];
	private String _encrpytedMessage;
	private String _currMessage;
	
	public LetterFrequency(String input) {
		this._encrpytedMessage = input;
		this._currMessage = input;
		fillNumberFreq();
	}
	
	private void fillNumberFreq() {
		for(int letter = 0; letter < this._numberfreq.length-1; letter++) {
			for(int i = 0; i < this._encrpytedMessage.length();i++) {
				if(this._encrpytedMessage.charAt(i) == this._alphabet.charAt(letter)) {
					_numberfreq[letter]++;
				}
			}
		}
	}
	
	public int[] getnumberFreq() {
		return this._numberfreq;
	}
	
	public void numberFreqToString() {
		for(int i = 0; i < this._numberfreq.length; i++) {
			System.out.printf("%s : %d\n",this._alphabet.charAt(i),this._numberfreq[i]);	
		}
		System.out.println();
	}
	
	public String SwapLetters(char first, char second) {
		char[] encryptedMessageChars = this._currMessage.toCharArray();
		for(int i = 0; i < encryptedMessageChars.length; i++) {
			if(encryptedMessageChars[i] == first) {
				encryptedMessageChars[i] = second;
			}else if(encryptedMessageChars[i] == second) {
				encryptedMessageChars[i] = first;
			}
		}
		this._currMessage = String.valueOf(encryptedMessageChars);
		return this._currMessage;
	}
	
	
}
