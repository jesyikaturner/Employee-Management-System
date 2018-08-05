package sci_work;

//Ref: https://coderanch.com/t/676882/java/Double-Transposition

public class DoubleTransposition {
	public void printMatrix(char[][] input) {
		for (char[] x : input){
		   for (char y : x){
		        System.out.print(y+" ");
		   }
		   System.out.println();
		}
		System.out.printf("\n\n");
	}
	
	public char[][] fillMatrix (String input, String spaceChar, int row, int col) {
		int counter = 0;
		int difference = (row*col) - input.length(); 
		
		if(difference > 0) {
			for(int i = 0; i < difference; i++) {
				input += spaceChar;
			}
		}
		
		char[][] result = new char[row][col];
		for(int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				result[r][c] = input.charAt(counter);
				counter++;
			}
		}
		return result;
	}
	

	public char[][] swapCol(char[][] input, int first, int second){
		for(int r = 0; r < input.length; r++) {
			char temp = input[r][first-1];
			input[r][first-1] = input[r][second-1];
			input[r][second-1] = temp;
		}
		return input;
	}
	
	public char[][] swapRow(char[][] input, int first, int second){
		for(int c = 0; c < input[0].length; c++) {
			char temp = input[first-1][c];
			input[first-1][c] = input[second-1][c];
			input[second-1][c] = temp;
		}
		return input;
	}
		
}
