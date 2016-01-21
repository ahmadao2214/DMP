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
			System.out.println(printCurrentDate()+"\n");
			//System.out.println(convertIntoMinutes(dateString(weekendClose)));
			//System.out.println(minutesToTime(1410));
			//System.out.println(dateString(weekdayOpen) + "  - " + dateString(weekdayClose));
			//System.out.println(formatTime("20:46"));
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

	private static String weekdayOpen = "11:00";
	private static String weekdayClose = "23:00";
	private static String weekendOpen = "11:30";
	private static String weekendClose = "23:30";

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
		int movieDuration = 0;
		for (int i = 0; i < singleMovie.length; i++) {
			singleMovieTitleSplitArray = singleMovie[i].split(","); 
			formattedTitle = singleMovieTitleSplitArray[0] + " - Rated " + singleMovieTitleSplitArray[2] + ", " + singleMovieTitleSplitArray[3];
			movieDuration = convertIntoMinutes(singleMovieTitleSplitArray[3]);
			System.out.println(formattedTitle);
			timeScheduler(movieDuration, isWeekend(dayOfWeek));
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
	
	public static String minutesToTime(int min){
		String startTime = "00:00";
		String newtime;
		int h = min / 60 + Integer.valueOf(startTime.substring(0,1));
		int m = min % 60 + Integer.valueOf(startTime.substring(3,4));
		newtime = h+":"+m;
		return newtime;
	}
	
	public static String formatTime(String twentyFour)throws ParseException{
		SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
		SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
		Date _24HourDt = _24HourSDF.parse(twentyFour);
		String nTime = _12HourSDF.format(_24HourDt);
		return nTime;
	}

	private static boolean isWeekend(int day){
		if (day == 1 || day == 6 || day == 7)
			return true;
		else
			return false;
	}
	
	public static String printCurrentDate(){
		return strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " " + (now.get(Calendar.MONTH) + 1) + "/"
				+ now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR) + " ";
	}
	
	private static void timeScheduler(int movieDuration, boolean weekend){
		int weekendOpenInMinutes = convertIntoMinutes(weekendOpen) + 60; //690
		int weekendClosedInMinutes = convertIntoMinutes(weekendClose); //1410
		int weekdayOpenInMinutes = convertIntoMinutes(weekdayOpen) + 60; //720
		int weekdayClosedInMinutes = convertIntoMinutes(weekdayClose); //1380
		//int tmp = weekdayOpenInMinutes;
		
		if(weekend){
			doSchedule(weekendOpenInMinutes,weekendClosedInMinutes, movieDuration);
			/*while(weekendOpenInMinutes < weekendClosedInMinutes){
				weekendOpenInMinutes += movieDuration;
				prefferedTime(tmp);
				if(weekendOpenInMinutes < weekendClosedInMinutes){
					try{
						System.out.println(formatTime(minutesToTime(tmp)) + " - " + formatTime(minutesToTime(weekendOpenInMinutes)));
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				weekendOpenInMinutes += 35;
				tmp = weekendOpenInMinutes;
			}*/
		}
		else{
			doSchedule(weekdayOpenInMinutes,weekdayClosedInMinutes, movieDuration);
			/*while(weekdayOpenInMinutes < weekdayClosedInMinutes){
				weekdayOpenInMinutes += movieDuration;
				prefferedTime(tmp);
				if(weekdayOpenInMinutes < weekdayClosedInMinutes){
					try{
						System.out.println(formatTime(minutesToTime(tmp)) + " - " + formatTime(minutesToTime(weekdayOpenInMinutes)));
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				weekdayOpenInMinutes += 35;
				tmp = weekdayOpenInMinutes;
			}*/
		}
		
		System.out.println();
	}
	
		
	private static void doSchedule(int openMins, int closedMins, int movieDuration){
		int tmp = openMins;
		while(openMins < closedMins){
			openMins += movieDuration;
			prefferedTime(tmp);
			if(openMins < closedMins){
				try{
					System.out.println(formatTime(minutesToTime(tmp)) + " - " + formatTime(minutesToTime(openMins)));
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			openMins += 35;
			tmp = openMins;
		}
	}
	
	private static int prefferedTime(int orginalTime){
		while(orginalTime % 5 != 0){
			orginalTime += 1;
		}
		return orginalTime;
	}
}
