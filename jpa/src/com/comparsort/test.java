package com.comparsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class test {
	
	public static void main(String[] args) {
		DateForm df1 = new DateForm("2018","11","28","14","28","51");
		DateForm df2 = new DateForm("2018","11","28","14","98","11");
		DateForm df3 = new DateForm("2014","11","28","44","28","11");
		DateForm df4 = new DateForm("2018","11","27","14","28","11");
		DateForm df5 = new DateForm("2018","12","28","14","28","11");
		DateForm df6 = new DateForm("2016","11","28","14","28","11");
		List<DateForm> list = new ArrayList<DateForm>();
		list.add(df1);
		list.add(df2);
		list.add(df3);
		list.add(df4);
		list.add(df5);
		list.add(df6);
		Iterator<DateForm> itor = list.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		System.out.println("Íê±Ï1");
		Collections.sort(list);
		itor = list.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		System.out.println("Íê±Ï2");
	}

}
