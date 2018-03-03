package com.ocient.findlunch;

public class Restaurant {
Double lat;
Double longitude;
Double rating;
Double distance;
String name;
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getLat() {
	return lat;
}
public void setLat(Double lat) {
	this.lat = lat;
}
public Double getLongitude() {
	return longitude;
}
public void setLongitude(Double longitude) {
	this.longitude = longitude;
}
public Double getRating() {
	return rating;
}
public void setRating(Double rating) {
	this.rating = rating;
}
public Double getDistance() {
	return distance;
}
public void setDistance(Double distance) {
	this.distance = distance;
}
}
