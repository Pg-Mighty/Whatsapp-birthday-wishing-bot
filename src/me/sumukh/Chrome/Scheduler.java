package me.sumukh.Chrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class Scheduler {
	
	static StringBuilder str = new StringBuilder();
	String s =null;
	
	DateTimeFormatter fo= DateTimeFormatter.ISO_LOCAL_DATE;
	LocalDateTime time = LocalDateTime.now();
   
    
	public Scheduler() throws Exception {
		
		InputStream in= Scheduler.class.getResourceAsStream("Dates.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		while((s=reader.readLine()) != null) {
			
			str.append(s).append("\n");
	
		
		}
		
		int total = Integer.parseInt(getJsonKey("Total"));
		
		String index = getJsonIndex(isBirthday(total));
		
		Sleeper(index);
		
		
	}
	
	public static String getJsonKey(String wantedkey) {
		
		Pattern pa = Pattern.compile("\""+wantedkey+"\": \".*\"");
		Matcher ma = pa.matcher(str);
		
		if(ma.find() == true) {
			
			return ma.group().split("\"")[3];
		}
		
		
		return null;
		
	}
	
		public static String getJsonIndex(String key) {
		
		Pattern pa = Pattern.compile("\".*\": \""+key+"\"");
		Matcher ma = pa.matcher(str);
		
		if(ma.find() == true) {
			
			return ma.group().split("\"")[1].replace("Date", "");
		}
		
		
		return null;
		}
		
		
	
	public void Sleeper(String index) throws Exception {
		
		String name = getJsonKey("Name"+index);
		String date = getJsonKey("Date"+index);
		String num = getJsonKey("Number"+index);


	if(index != null) {
		
		new Launch(name , num);
			

	}else {Thread.sleep((long) 8.64e+7);
	
		new Scheduler();
	
	}

	}
	
	
	public String isBirthday(int total) {
		
		
		
		ArrayList<String> list = new ArrayList<String>();


		for (int i =1  ; i<=total ; i++) {
			
			String date_value = getJsonKey("Date"+i);
			list.add(date_value);
		}
		
		Iterator it = list.iterator();
		
		while(it.hasNext() ) {
			
			String s = (String) it.next();
			if (s.equals(fo.format(time).toString().replace("2022-", ""))) {
				
				return s;
			}
			
		}
		
		
		return null;
		
		
	}
	

	public static void main(String[] args)throws  Exception  {
		
	new Scheduler();
		
		
		
	}
}
