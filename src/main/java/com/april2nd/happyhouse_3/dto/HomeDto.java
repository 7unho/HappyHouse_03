package com.april2nd.happyhouse_3.dto;

public class HomeDto {
	String apt_code;
	String apt_name;
	int floor;
	String area;
	String dong_name;
	String deal_amount;
	int deal_year, deal_month, deal_day;
	String lng, lat;

	public String getApt_code() {
		return apt_code;
	}
	public void setApt_code(String apt_code) {
		this.apt_code = apt_code;
	}
	public String getApt_name() {
		return apt_name;
	}
	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDong_name() {
		return dong_name;
	}
	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}
	public String getDeal_amount() {
		return deal_amount;
	}
	public void setDeal_amount(String deal_amount) {
		this.deal_amount = deal_amount;
	}
	public int getDeal_year() {
		return deal_year;
	}
	public void setDeal_year(int deal_year) {
		this.deal_year = deal_year;
	}
	public int getDeal_month() {
		return deal_month;
	}
	public void setDeal_month(int deal_month) {
		this.deal_month = deal_month;
	}
	public int getDeal_day() {
		return deal_day;
	}
	public void setDeal_day(int deal_day) {
		this.deal_day = deal_day;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "HomeDto [apt_code=" + apt_code + ", apt_name=" + apt_name + ", floor=" + floor + ", area=" + area
				+ ", dong_name=" + dong_name + ", deal_amount=" + deal_amount + ", deal_year=" + deal_year
				+ ", deal_month=" + deal_month + ", deal_day=" + deal_day + ", lng=" + lng + ", lat=" + lat + "]";
	}






}
