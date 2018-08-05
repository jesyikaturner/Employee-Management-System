package sci_work;

public class PermuationsOfString {
	public static void main(String[] args) {
		PermuationsOfString ps = new PermuationsOfString();

		String letter = "EHIKLRST";
		
		String binary = "01";
		char[] result = new char[9];
		ps.permutation(result,0,binary);
		//System.out.println(new String(result));
	}
	
	private void permutation(char[] perm, int pos, String str) {
	    if (pos == perm.length) {
	        System.out.println(new String(perm));
	        
	        
	    } else {
	        for (int i = 0 ; i < str.length() ; i++) {
	            perm[pos] = str.charAt(i);
	            permutation(perm, pos+1, str);
	        }
	    }
	}
	
	
}
