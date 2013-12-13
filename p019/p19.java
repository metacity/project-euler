import java.util.Calendar;

public class p19 {

	public static void main(String[] args) {
		Calendar start = Calendar.getInstance();
		start.clear();
		start.set(1901, 0, 1);
		
		Calendar end = Calendar.getInstance();
		end.set(2000, 11, 31);
		
		int firstOfMonthSundays = 0;
		while (start.before(end)) {
			if (start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				firstOfMonthSundays++;
			}
			start.add(Calendar.MONTH, 1);
		}
		System.out.println(String.valueOf(firstOfMonthSundays));
	
	}
}