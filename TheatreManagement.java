import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TheatreManagement {
	public static void main(String[] args) {
		try {
			Date date = new Date();
			System.out.println(date.toString());
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
		String singleMovieTitleSplitArray[] = new String[200];
		String formattedTitle = " ";
		int movieDuration = 0;
		for (int i = 0; i < singleMovie.length; i++) {
			singleMovieTitleSplitArray = singleMovie[i].split(","); 
			formattedTitle = singleMovieTitleSplitArray[0] + " - Rated " + singleMovieTitleSplitArray[2] + ", " + singleMovieTitleSplitArray[3];
			movieDuration = convertIntoMinutes(singleMovieTitleSplitArray[3]);
			//System.out.println(formattedTitle + " = " + movieDuration + " minutes");
			if(!isWeekend(dayOfWeek)){
				
				}
			else{
			
			}
		}
	}
	
	public static int convertIntoMinutes(String md){
		int minutes=0;
		md = md.trim();
	    String[] arr= md.split(":");
	    if(arr.length==2){
	        minutes=Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
	    }
		return minutes;
	}
	
	public static boolean isWeekend(int day){
		if (day == 1 || day == 6 || day == 7)
			weekend = true;
		else
			weekend = false;
		return weekend;
	}
}
