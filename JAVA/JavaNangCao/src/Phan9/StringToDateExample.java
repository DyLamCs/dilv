package Phan9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateExample {
	public static void main(String[] args) throws Exception {
		String stringDate = "22/01/2016";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
		System.out.println(stringDate + "\t" + date1);
		}


}
