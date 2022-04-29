package chaedie.calendar;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class FileDatabase {

	public void makeFile(String date, ArrayList schedulesOfDay)
	{
		try (
				FileWriter fw = new FileWriter("Schedule.txt", true); 
				BufferedWriter bw = new BufferedWriter(fw);
		) 
		{
			bw.write(date + " ");
			bw.write(schedulesOfDay.toString());
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			// TODO: handle exception
		}
		File f = new File("Schedule.txt");
	}

}
