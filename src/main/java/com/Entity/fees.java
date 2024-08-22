package com.Entity;

public class fees {
	
	private int fees_id,stud_id,course_id;
	private long total_fees,amt_recieved,paid_fees,remaining_fees;
	private String payment_method,date;
	public int getFees_id() {
		return fees_id;
	}
	public void setFees_id(int fees_id) {
		this.fees_id = fees_id;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public long getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(long total_fees) {
		this.total_fees = total_fees;
	}
	public long getAmt_recieved() {
		return amt_recieved;
	}
	public void setAmt_recieved(long amt_recieved) {
		this.amt_recieved = amt_recieved;
	}
	public long getPaid_fees() {
		return paid_fees;
	}
	public void setPaid_fees(long paid_fees) {
		this.paid_fees = paid_fees;
	}
	public long getRemaining_fees() {
		return remaining_fees;
	}
	public void setRemaining_fees(long remaining_fees) {
		this.remaining_fees = remaining_fees;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
