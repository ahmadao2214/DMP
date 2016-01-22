import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TheaterManagement {
	public static void main(String[] args) {
		try {
			TheaterManagement theaterManager = new TheaterManagement();
			System.out.println(theaterManager.printCurrentDate() + "\n");
			theaterManager.readFile(args[0]);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private BufferedReader bReader = null;

	private Calendar now = Calendar.getInstance();
	private String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",	"Saturday" };
	private int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);

	//Military Time
	private final String WEEKDAY_OPEN = "11:00";
	private final String WEEKDAY_CLOSE = "23:00";
	private final String WEEKEND_OPEN = "11:30";
	private final String WEEKEND_CLOSE = "23:30";

	private void readFile(String fileName) throws IOException {
		String bLine = "";
		bReader = new BufferedReader(new FileReader(fileName));
		bReader.readLine();
		while ((bLine = bReader.readLine()) != null) {
			createShowTimes(bLine);
		}
	}

	private void createShowTimes(String singleMovie) {
		String singleMovieSplitArray[] = singleMovie.split(",");
		String formattedTitle = " ";
		int movieDuration = 0;
		formattedTitle = singleMovieSplitArray[0] + " - Rated " + singleMovieSplitArray[2] + ", "+ singleMovieSplitArray[3];
		movieDuration = convertIntoMinutes(singleMovieSplitArray[3]);
		System.out.println(formattedTitle);
		timeScheduler(movieDuration, isWeekend(dayOfWeek));
	}

	private int convertIntoMinutes(String md) {
		int minutes = 0;
		md = md.trim();
		String[] arr = md.split(":");
		minutes = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
		return minutes;
	}
	
	private String minutesToTime(int min) {
		String startTime = "00:00";
		String newtime;
		int h = min / 60 + Integer.valueOf(startTime.substring(0, 1));
		int m = min % 60 + Integer.valueOf(startTime.substring(3, 4));
		newtime = h + ":" + m;
		return newtime;
	}

	
	private boolean isWeekend(int day) {
		return (day == 1 || day == 6 || day == 7);
	}

	private String printCurrentDate() {
		return strDays[now.get(Calendar.DAY_OF_WEEK) - 1] +
				" " + (now.get(Calendar.MONTH) + 1) + 
				"/"	+ now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR);
	}

	private void timeScheduler(int movieDuration, boolean weekend) {
		int weekdayOpenInMinutes = convertIntoMinutes(WEEKDAY_OPEN) + 60; // 720 minutes
		int weekdayClosedInMinutes = convertIntoMinutes(WEEKDAY_CLOSE); // 1380 minutes
		int weekendOpenInMinutes = convertIntoMinutes(WEEKEND_OPEN) + 60; // 690 minutes
		int weekendClosedInMinutes = convertIntoMinutes(WEEKEND_CLOSE); // 1410 minutes

		if (weekend) {
			doSchedule(weekendOpenInMinutes, weekendClosedInMinutes, movieDuration);
		} else {
			doSchedule(weekdayOpenInMinutes, weekdayClosedInMinutes, movieDuration);
		}

		System.out.println();
	}

	private void doSchedule(int openMins, int closedMins, int movieDuration) {
		ArrayList<String> minutesArray = new ArrayList<String>();
		int totalMoviePlays = (closedMins - openMins) / movieDuration;
		int tmp = closedMins;
		for (int i = 0; i < totalMoviePlays; i++) {
			tmp = prefferedTime(tmp - movieDuration);
			if (tmp > openMins) {
				try {
					minutesArray.add(formatTime(minutesToTime(tmp)) + " - " + formatTime(minutesToTime(tmp + movieDuration)));
				} catch (Exception e) {
					System.out.println(e);
				}
				tmp -= 35;
			}
		}
		printReversedArrayList(minutesArray);
	}

	private String formatTime(String twentyFour) throws ParseException {
		SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
		SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
		Date _24HourDt = _24HourSDF.parse(twentyFour);
		String nTime = _12HourSDF.format(_24HourDt);
		return nTime;
	}

	private int prefferedTime(int orginalTime) {
		orginalTime -= (orginalTime % 5);
		return orginalTime;
	}

	private void printReversedArrayList(ArrayList<String> arrayList) {
		for (int i = (arrayList.size() - 1); i >= 0; i--) {
				System.out.println(arrayList.get(i));
		}
	}
}
