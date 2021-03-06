package geopriv4j;

import java.io.IOException;
import java.util.ArrayList;

import geopriv4j.utils.DataHandler;

/* 
 * This is a Noise Algorithm Exmaple Class.
 * We implement noise by simply adding 2D, Gaussian noise to each measured 
 * latitude and longitude coordinate. For each point, we generate a noise vector with a 
 * random uniform direction over [0,2π ) and a Gaussian-distributed magnitude from N(0,σ)^2.
 * A negative magnitude reverses the direction of the noise vector. 
 * 
 * This method has been implemented from the paper by Krumm, John. 
 * "Inference attacks on location tracks." International Conference on Pervasive Computing. 
 * Springer, Berlin, Heidelberg, 2007.
 */

import geopriv4j.utils.LatLng;

public class NoiseAlgorithmExample {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		// specify the variance in meters
		double variance = 5000;

		NoiseAlgorithm algorithm = new NoiseAlgorithm(variance);

		// change this variable to pick 1000, 5000, 10000 synthetic points
		int data = 10000;

		ArrayList<LatLng> locations = DataHandler.readData("data/" + data + ".txt");

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < locations.size(); i++) {
			
			LatLng generated_location = algorithm.generate(locations.get(i));

			// System.out.println("Genereated location: "+ generated_location);
		}

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("run time : " + totalTime);

	}
}
