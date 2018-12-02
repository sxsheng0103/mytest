package com.comparsort;

public class DateForm implements Comparable<DateForm>{
	
	String dateStamps = "";
	
	String year = "";
	String month = "";
	String date = "";
	String hour = "";
	String min = "";
	String second = "";
	public DateForm() {}
	public DateForm(String year,String month,String date,
			String hour,String min,String second) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.min = min;
		this.second = second;
		setDateStamps();
	}

	public void setDateStamps() {
		this.dateStamps = this.year+"-"+this.month +"-"+this.date+" "+this.hour+":"+this.min+":"+this.second;
	}
	@Override
	public String toString() {
		return "DateForm [dateStamps=" + dateStamps + ", year=" + year + ", month=" + month + ", date=" + date
				+ ", hour=" + hour + ", min=" + min + ", second=" + second + "]";
	}
	public int compareTo(DateForm o) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(this.year) > Integer.parseInt(o.year)) {
			return 1;
		}else if(Integer.parseInt(this.year) < Integer.parseInt(o.year)) {
			return -1;
		}else if(Integer.parseInt(this.month) > Integer.parseInt(o.month)) {
			return 1;
		}else if(Integer.parseInt(this.month) < Integer.parseInt(o.month)) {
			return -1;
		}else if(Integer.parseInt(this.date) > Integer.parseInt(o.date)) {
			return 1;
		}else if(Integer.parseInt(this.date) < Integer.parseInt(o.date)) {
			return -1;
		}else
		return 0;
	}
}
