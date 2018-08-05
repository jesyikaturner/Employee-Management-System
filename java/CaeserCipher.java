package sci_work;
//http://technojeeves.com/index.php/93-caesar-cipher-in-java

public class CaeserCipher {	
	public char Shift(char input, int i) {
		i %= 26;
		
		if(input >= 'a' && input <= 'z') {
			input += i;
	        if (input > 'z') {
	            // correct overflow
	        	input = (char) ((input - 'z' + 'a') - 1);
	        } else if (input < 'a') {
	            // correct underflow
	        	input = (char) (('z' + input) - 'a' + 1);
	        }
		}
		
		if(input >= 'A' && input <= 'Z') {
			input += i;
	        if (input > 'Z') {
	            // correct overflow
	        	input = (char) ((input - 'Z' + 'A') - 1);
	        } else if (input < 'A') {
	            // correct underflow
	        	input = (char) (('Z' + input) - 'A' + 1);
	        }
		}
		return input;
	}
	
	// print all function
	public void PrintDecryptAll(String input) {
		for(int i = 0; i < 27; i++) {
			System.out.print("Shift by "+i+": ");
			for(int c = 0; c < input.length(); c++) {
				
				System.out.print(Shift(input.charAt(c),i));
			}
			System.out.println();
		}
		for(int i = 0; i > -27; i--) {
			System.out.print("Shift by "+i+": ");
			for(int c = 0; c < input.length(); c++) {
				
				System.out.print(Shift(input.charAt(c),i));
			}
			System.out.println();
		}
		System.out.printf("\n\n");
	}
	
	// encrypt input string by shift
	public String Encrypt(String input, int shift) {
		String result = "";
		for(int c = 0; c < input.length(); c++) {
			result+=Shift(input.charAt(c),shift);
		}
	
		return result;
	}

}
