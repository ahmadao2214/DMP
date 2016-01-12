import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreManagement {
	
	static BufferedReader bReader = null;
	static String bLine = "";
	
	public static void main(String[] args) {
		try{
			readFile(args[0]);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public static void readFile(String fileName) throws IOException {
		bReader = new BufferedReader(new FileReader(fileName));
		while ((bLine = bReader.readLine()) != null) {
			System.out.println(bLine);
		}		
	}
}
