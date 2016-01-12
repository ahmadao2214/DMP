import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TheatreManagement {
	public static void main(String[] args) {
		try{
			readFile(args[0]);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	static BufferedReader bReader = null;
	static String bLine = "";
	static ArrayList<String> bLineArray = new ArrayList<String>();
	static String singleMovie[] = new String[200];
	static DateFormat df = new SimpleDateFormat("H:m");
	
	public static void readFile(String fileName) throws IOException {
		bReader = new BufferedReader(new FileReader(fileName));
		while ((bLine = bReader.readLine()) != null) {
			//System.out.println(bLine);
			bLineArray.add(bLine);
		}	
		getSingleMovie(bLineArray);
	}
	
	public static void getSingleMovie(ArrayList<String> movies){
		for(String movie : movies){
			singleMovie = movie.split(",");
			for(int i = 0; i < singleMovie.length; i++){
				System.out.print(singleMovie[i] + " ");
			}
		}
	}
	
	public static void createShowTimes(String[] singleMovie){
		
	}
}
