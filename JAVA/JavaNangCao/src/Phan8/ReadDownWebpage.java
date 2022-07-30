package Phan8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Câu 3:  Đọc và download một Webpage 
 *
 */
public class ReadDownWebpage {
	public static void main(String[] args) throws IOException {

		try {
			URL url = new URL("https://www.google.com/");

			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			BufferedWriter writer = new BufferedWriter(new FileWriter("C:/mydata/data.html"));

			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			reader.close();
			writer.close();
		} catch (MalformedURLException e) {
			System.out.println("Trang web khong ton tai");
		}

	}

}
