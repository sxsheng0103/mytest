package com.comparsort;

import java.util.Comparator;

public class DateComparable implements Comparator<DateForm>{


	public int compare(DateForm o1, DateForm o2) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(o1.year) > Integer.parseInt(o2.year)) {
			return 1;
		}else if(Integer.parseInt(o1.year) < Integer.parseInt(o2.year)) {
			return -1;
		}else if(Integer.parseInt(o1.month) > Integer.parseInt(o2.month)) {
			return 1;
		}else if(Integer.parseInt(o1.month) < Integer.parseInt(o2.month)) {
			return -1;
		}else if(Integer.parseInt(o1.date) > Integer.parseInt(o2.date)) {
			return 1;
		}else if(Integer.parseInt(o1.date) < Integer.parseInt(o2.date)) {
			return -1;
		}else
		return 0;
	}

}
