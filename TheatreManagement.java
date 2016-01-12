import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreManagement {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line = " ";
		try {
			br = new BufferedReader(new FileReader(args[0]));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}		
		}
		catch (IOException e) {
			e.printStackTrace();
		} 		
		finally {
			try {
				if (br != null)
					br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
