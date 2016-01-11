import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreManagement {
	public static void main(String[] args) {
		FileInputStream fileIStream = null;
		InputStreamReader iStreamReader = null;
		int intIStreamReader;

		try {
			fileIStream = new FileInputStream(args[0]);
			iStreamReader = new InputStreamReader(fileIStream);
			
			while ((intIStreamReader = iStreamReader.read()) != -1) {
				System.out.print((char) intIStreamReader);
			}		
		}
		catch (IOException e) {
			e.printStackTrace();
		} 		
		finally {
			try {
				if (fileIStream != null)
					fileIStream.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
