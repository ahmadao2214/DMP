import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TheatreManagement {
	public static void main(String[] args) {
		try {
			System.out.println(printCurrentDate());
			//System.out.println(convertIntoMinutes(dateString(weekdayClose)));
			//System.out.println(dateString(weekdayOpen) + "  - " + dateString(weekdayClose));
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
	static String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };
	static int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	static Date day = new Date();

	static String weekdayOpen = "11:00";
	static String weekdayClose = "23:00";
	static String weekendOpen = "11:30";
	static String weekendClose = "23:30";
	
	
	
 
	public static void readFile(String fileName) throws IOException {
		bReader = new BufferedReader(new FileReader(fileName));
		while ((bLine = bReader.readLine()) != null) {
			bLineArray.add(bLine);
		}
		for (int i = 1; i < bLineArray.size(); i++)
			getSingleMovie(bLineArray.get(i));
	}

	public static void getSingleMovie(String movie) {
		movieInfo = movie.split(":", 1);
		createShowTimes(movieInfo);
	}

	public static void createShowTimes(String[] singleMovie) {
		String singleMovieTitleSplitArray[] = new String[200];
		String formattedTitle = " ";
		//int movieDuration = 0;
		for (int i = 0; i < singleMovie.length; i++) {
			singleMovieTitleSplitArray = singleMovie[i].split(","); 
			formattedTitle = singleMovieTitleSplitArray[0] + " - Rated " + singleMovieTitleSplitArray[2] + ", " + singleMovieTitleSplitArray[3];
			//movieDuration = convertIntoMinutes(singleMovieTitleSplitArray[3]);
			System.out.println(formattedTitle);
			System.out.println("Schedule goes here");
			if(!isWeekend(dayOfWeek)){
				System.out.println("It's not the weekend\n");
				}
			else{
				System.out.println("IT'S THE WEEKEND\n");
			}
		}
	}
	
	public static String dateString(String theatreHours)throws ParseException{
		day = sdf.parse(theatreHours);
		String workDayHours = sdf.format(day);
		return workDayHours;
	}

	public static int convertIntoMinutes(String md){
		int minutes=0;
		md = md.trim();
	    String[] arr= md.split(":");
	    minutes=Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
		return minutes;
	}

	public static boolean isWeekend(int day){
		if (day == 1 || day == 6 || day == 7)
			return true;
		else
			return false;
	}
	
	public static String printCurrentDate(){
		return strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " " + (now.get(Calendar.MONTH) + 1) + "/"
				+ now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR) + " ";
	}
}
