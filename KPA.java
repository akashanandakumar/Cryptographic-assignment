package KPA;

//import files needed
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// importing rotor file into COA file to use encdec method for decryption
import rotor96Crypto.Rotor96Crypto;

public class KPA {
	
	public static void main(String[] args) {
		// cipher text to decrypt 
		String ct  = "13sYIOk:q#9U5pQ{1Bqu?:c3ZpJJ+3Nox3)RD7gNvL`TZKy.<Fr4l4}tHuUoSa3UzAUV_I`d$ }Q>a\"{6bKO,}Z$IZ}1cv+ku(?_'Zu4GJ1$Cn"; 
	
		
		try {

			// importing password file to check with possible keys
	        File file = new File("file/passwords"); 

			FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
			String line;  // store the key value

			// while loop operations for compare two letters with password file 
	        while ((line = bufferedReader.readLine()) != null) {
								
				// decrypt method from rotor file encdec method 
				String pt = Rotor96Crypto.encdec(Rotor96Crypto.DEC, line, ct);

	        	if(pt.charAt(0)=='T' && pt.charAt(1)=='h') {	
	        		System.out.println(line);  // output possible key values
	        		System.out.println(pt);  // output possbile plaintext 
				} 
	        }

	    } catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}