import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class TheatreManagement {
	public static void main(String[] args) {
		try {
			System.out.println(strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " " +
					(now.get(Calendar.MONTH) + 1) + "/" + 
					now.get(Calendar.DATE) + "/" + 
					now.get(Calendar.YEAR) + " ");
			readFile(args[0]);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static BufferedReader bReader = null;
	static String bLine = "";
	static ArrayList<String> bLineArray = new ArrayList<String>();
	static String movieInfo[] = new String[200];
	
	static Calendar now = Calendar.getInstance();
	static String[] strDays = new String[] { 
			"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"
	};
	static int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
	static boolean weekend = false;

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
		movieInfo = movie.split(":", 1);
		createShowTimes(movieInfo);
	}

	public static void createShowTimes(String[] singleMovie) {
		String tmp[] = new String[200];
		String temp = " ";
		for (int i = 0; i < singleMovie.length; i++) {
			tmp = singleMovie[i].split(",");
			temp = tmp[0] + " - Rated " + tmp[2] + ", " + tmp[3];
			System.out.println(temp);
		}
	}
	
	public static boolean isWeekend(int day){
		if (day == 1 || day == 6 || day == 7)
			return true;
		return false;
	}
}
