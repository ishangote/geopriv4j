/*
 * This is a Spatial Cloaking Algorithm Example Class
 */

package geopriv4j;

import java.io.IOException;
import java.util.ArrayList;
import exception.RadiusException;
import geopriv4j.utils.DataHandler;
import geopriv4j.utils.LatLng;

public class SpatialCloakingAlgorithmExample {

	public static void main(String[] args) throws RadiusException, ClassNotFoundException, IOException {

		// specify the sensitive location
		LatLng sensitive = new LatLng(35.3123, -80.7432);

		// specify the radius r in meters
		int r = 500;

		// specify the radius R in meters
		int R = 1000;

		// instantiating the algorithm
		SpatialCloakingAlgorithm algorithm = new SpatialCloakingAlgorithm(sensitive, r, R);

		// change this variable to pick 1000, 5000, 10000 synthetic points
		int data = 10000;

		ArrayList<LatLng> locations = DataHandler.readData("data/" + data + ".txt");

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < locations.size(); i++) {

			LatLng generated_location = algorithm.generate(locations.get(i));

			// if(spatialCloaked_location!=null) System.out.println("Generated location: "+
			// generated_location);
			// else System.out.println("Generated location inside the larger radius R ");
		}

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("run time : " + totalTime);
	}
}
