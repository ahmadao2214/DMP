import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreManagement {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		int i;
		String c;

		try {
			fis = new FileInputStream(args[0]);
			isr = new InputStreamReader(fis);
			
			while ((i = isr.read()) != -1) {
				System.out.print((char) i);
			}		
		}
		catch (IOException e) {
			e.printStackTrace();
		} 		
		finally {
			try {
				if (fis != null)
					fis.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
