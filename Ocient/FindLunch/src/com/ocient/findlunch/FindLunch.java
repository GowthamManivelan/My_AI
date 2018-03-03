package com.ocient.findlunch;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
public class FindLunch {
	static ArrayList<Restaurant> restaurants;
	static Double PI_RAD = Math.PI / 180.0;
	FindLunch findDistance = new FindLunch();
	public static void main(String[] args) throws IOException {
		int start =0;
		Double ocientLat = 41.884452; 
		Double ocientLong = -87.638741;
		restaurants = new ArrayList<Restaurant>();
		DataInputStream input = new DataInputStream(new FileInputStream(
				"restaurants.dat"));

		while (input.available() > 0) {

			String x = input.readLine();
			try {
				if(start!=0) {
					String[] data = x.split(",");
					Restaurant restaurant = new Restaurant();
					restaurant.setId(Integer.parseInt(data[0]));
					restaurant.setName(data[1]);
					restaurant.setLongitude(Double.parseDouble(data[2]));
					restaurant.setLat(Double.parseDouble(data[3]));
					restaurant.setRating(Double.parseDouble(data[4]));
					restaurant.setDistance(greatCircleInMiles(restaurant.getLat(),restaurant.getLongitude(),ocientLat,ocientLong));
					restaurants.add(restaurant);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			start++;
		}



		input.close();
		initateInput();
	}
	private static void initateInput() {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of restaurants to print");
		Scanner in = new Scanner(System.in);
		int res_num= in.nextInt();
		System.out.println("Enter distance or rating");
		String choice = in.next();
		switch(choice) {
		case "distance":
			Collections.sort(restaurants, new Comparator<Restaurant>() {
				@Override
				public int compare(Restaurant o1, Restaurant o2) {
					// TODO Auto-generated method stub
					return o1.getDistance().compareTo(o2.getDistance());
				}
			});
			break;
		case "rating":
			Collections.sort(restaurants, new Comparator<Restaurant>() {
				@Override
				public int compare(Restaurant o1, Restaurant o2) {
					// TODO Auto-generated method stub
					return o2.getRating().compareTo(o1.getRating());
				}
			});
			break;

		}
		for(int i=0;i<res_num;i++) {
			System.out.println(restaurants.get(i).getId()+" "+restaurants.get(i).getName()+" "+restaurants.get(i).getDistance()*1609.34+"meters "+restaurants.get(i).getRating());
		}


	}
	public static Double greatCircleInMiles(Double lat1, Double long1, Double lat2, Double long2) {
		Double phi1 = lat1 * PI_RAD;
		Double phi2 = lat2 * PI_RAD;
		Double lam1 = long1 * PI_RAD;
		Double lam2 = long2 * PI_RAD;

		return 3958.75 * acos(sin(phi1) * sin(phi2) + cos(phi1) * cos(phi2) * cos(lam2 - lam1));
	}
}

