package COA;

//import files needed
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// importing rotor file into COA file to use encdec method for decryption
import rotor96Crypto.Rotor96Crypto;

public class COA {

	public static void main(String[] args) {
		// cipher text to decrypt 
		String ct = "a=gAxj#gL=/,<`\\Yy7>cpM[yfe&dNOJ=|=2;dOL|/=aRA<lCmKgc*$x(]2]Y8\\)E;K9w+ 9-jKsO8*#9K^V1hI\\NFp-[Y$_69cK'X#tLM:/xD_\\Y>XZ%d9*r,RMnIw_RuDJH5UCz//;Z)x)y(GI\"DDx)Q3fqaXBHT}]<S 6(cBlU;a#AJ>V'QEm~f.f|sH*K=cWc5QEc^N*xD`!mV4ZFC[5{FRMnrO5=|?uNEhRx7TXu}|X)DXCz*H=Y.9)YM!Bef{x+-RJNzbYu0s^9>a6 ]\\)5K@p{HHkGYRd+*dLLj7AVYo+p!>vY_Hy36nv#%IBQJCI<G&Uq+-2<\"a+6C[Y";
		
		// minimum cipher text needed 
		String ct2 = "a=gAxj#gL=/,<`\\Yy7>cpM[yfe&dNOJ=";	

		// all the possible alphabets and characters
		String condition = "[a-zA-Z0-9 '\"\\-\\(\\):\\?\\!;,\\.]+";
		try {
			// importing password file to check with possible keys
	        File file = new File("file/passwords"); 

	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String line; // store the key value

			// while loop operations for compare with password file
	        while ((line = bufferedReader.readLine()) != null) {
					
				// decrypt method from rotor file encdec method 
	        	String pt = Rotor96Crypto.encdec(Rotor96Crypto.DEC, line, ct2);	
	        		
				if (pt.matches(condition)) {
	        		System.out.println(line); // output possible key values
	        		System.out.println(pt); // output possbile plaintext 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
	    }
	
	}	 
		 
}

