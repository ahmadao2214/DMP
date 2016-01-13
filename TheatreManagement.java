import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TheatreManagement {
	public static void main(String[] args) {
		try {
			readFile(args[0]);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static BufferedReader bReader = null;
	static String bLine = "";
	static ArrayList<String> bLineArray = new ArrayList<String>();
	static String movieInfo[] = new String[200];
	static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	public static void readFile(String fileName) throws IOException {
		bReader = new BufferedReader(new FileReader(fileName));
		while ((bLine = bReader.readLine()) != null) {
			bLineArray.add(bLine);
		}
		bLineArray.remove(0);
		for (int i = 0; i < bLineArray.size(); i++)
			getSingleMovie(bLineArray.get(i));
	}

	public static void getSingleMovie(String movie) {
		movieInfo = movie.split(",");
		for (int i = 0; i < movieInfo.length; i++) {
			System.out.print(movieInfo[i] + " ");
		}
	}

	public static void createShowTimes(String[] singleMovie) {

	}
}
