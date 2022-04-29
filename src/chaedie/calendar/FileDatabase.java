package chaedie.calendar;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;

public class FileDatabase {
	//TODO 
	//DONE 0. 일정 등록시 파일 생성 및 db에 일정 쓰는것 까진 됐다.
	//
	//DONE 2. 파일 읽기는 위에서 이미 필요했다. 
	// 1. 하지만 일정을 쓸때 기존 일정을 지우지 않고 계속 리스트에 있는걸 새로 적는다.
	// (파일 읽기 -> 리스트에 담고 -> file value 삭제-> value 어펜드 -> 파일 write ) 해야함
	
	public void readFile(String date, ArrayList schedulesOfDay) {
		try (
				FileReader fr = new FileReader("Schedule.txt");
//				FileReader frs = new FileReader("Schedule.txt"); 
				BufferedReader br = new BufferedReader(fr);
//				BufferedReader brs = new BufferedReader(frs);
		) 
		{
			String readLine = null;
			String[] readLines = {"",""};
			while((readLines[0] != null)) {
//				readLine = br.readLine();
				readLines = br.readLine().split(";");
				
				System.out.println(readLines[1]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
//		File f = new File("Schedule.txt");
	}
	
	public void writeFile(String date, ArrayList schedulesOfDay) {
		try (
				FileWriter fw = new FileWriter("Schedule.txt", true); 
				BufferedWriter bw = new BufferedWriter(fw);
		) 
		{
			bw.write(date + ";");
			bw.write(schedulesOfDay.toString());
			bw.newLine();
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		File f = new File("Schedule.txt");
	}
	
	
}
