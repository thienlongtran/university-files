public class DateFormatConverter{
	public static final String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
	public static String numbersToWords(String date){
		//Here we want to convert from the all numbers format to the monthname date, year format. 
		//04/25/1955 -> April 25, 1955
		String[] dates = date.split("/");
		int monthNum = Integer.parseInt(dates[0]);
		String month = monthName[monthNum - 1];
		String result = month + " " + Integer.parseInt(dates[1]) + ", "+dates[2];
		return result;
    }

    public static String wordsToNumbers(String date){
		//Here we want to convert from the all numbers format to the monthname date, year format. 
		// April 25, 1955 -> 04/25/1955
		String noCommaString = date.replace(",", "");
		String[] dates = noCommaString.split(" ");
		String month = "00";

		String[] arrayMonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		for (int i = 0; i < monthName.length - 1; i++){
			if(dates[0].equals(monthName[i])){
				month = arrayMonths[i];
			}
		}

		String result = month+"/"+String.format("%02d", Integer.parseInt(dates[1]))+"/"+dates[2];
		return result;
		
    }
	
	public static void main(String[] args){
		System.out.println(numbersToWords("04/25/1955")); //expected output: April 25, 1955
		System.out.println(wordsToNumbers("April 25, 1955")); //expected output: 04/25/1955
	}
}
