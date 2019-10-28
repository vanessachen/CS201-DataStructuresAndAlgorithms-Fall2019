	

/**
 * @author YOUR NAME THE STUDENT IN 201
 * 
 * Simulation program for the NBody assignment
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {
	
	/**
	 * Read the specified file and return the radius
	 * @param fname is name of file that can be openned
	 * @return the radius stored in the file
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static double readRadius(String fname) throws FileNotFoundException  {
		Scanner s = new Scanner(new File(fname)); //creating new scanner that produces values scanned from the specified file.
	
		// TODO: read values at beginning of file to
		// find the radius
		int numBodies = s.nextInt();
		double radius = s.nextDouble();
		
		s.close();
		
		// TODO: return radius read
		return radius;
	}
	
	/**
	 * Read all data in file, return array of Celestial Bodies
	 * read by creating an array of Body objects from data read.
	 * @param fname is name of file that can be open
	 * @return array of Body objects read
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static CelestialBody[] readBodies(String fname) throws FileNotFoundException {
		
			Scanner s = new Scanner(new File(fname));
			
			// TODO: read # bodies, create array, ignore radius
			int nb = s.nextInt(); // # bodies to be read
			double radiusIgnore = s.nextDouble();
			CelestialBody[] bodies = new CelestialBody[nb];
			
			for(int k=0; k < nb; k++) {
				
				// TODO: read data for each body
				// construct new body object and add to array
				// the first 4 variables are data points signifying the location of the body, thr 5th is the mass, and the last one is the filename
				bodies[k] = new CelestialBody(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble(), s.next());
			}
			
			s.close();
			
			// TODO: return array of body objects read
			return bodies;
	}

	/**
	 * This is the main method that runs the simulation.
	 * @param args is what is required as a parameter for a main() method in a .java file. It signifies a single argument of type String Array
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		double totalTime = 39447000.0;//39447000.0
		double dt = 25000.0;//25000.0
		
		String fname= "data/kaleidoscope.txt";
		if (args.length > 2) {
			totalTime = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			fname = args[2];
		}	
		
		CelestialBody[] bodies = readBodies(fname);
		double radius = readRadius(fname);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		//StdAudio.play("images/2001.wav");
	
		// run simulation until time up

		for(double t = 0.0; t < totalTime; t += dt) {
			
			// TODO: create double arrays xforces and yforces
			// to hold forces on each body
			double[] xforces = new double[bodies.length];
			double[] yforces = new double[bodies.length];
			
			// TODO: loop over all bodies, calculate netForcesX and Y
			// net forces and store in xforces and yforces
			for (int k = 0; k < bodies.length; k++){
				//CelestialBody body = new CelestialBody();
				//need another for loop
				CelestialBody body = bodies[k];
				xforces[k] = body.calcNetForceExertedByX(bodies);
				yforces[k] = body.calcNetForceExertedByY(bodies);

			}
			
			// TODO: loop over all bodies and call update
			// with dt and corresponding xforces, yforces values
			for (int k = 0; k < bodies.length; k++){
				//CelestialBody body = new CelestialBody();
				CelestialBody body = bodies[k];
				body.update(dt,xforces[k],yforces[k]);
			}

			StdDraw.picture(0,0,"images/starfield.jpg");
			
			// TODO: loop over all bodies and call draw on each one
			for (int k = 0; k < bodies.length; k++){
				CelestialBody body = bodies[k];
				body.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}
		
		// prints final values after simulation
		
		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              bodies[i].getX(), bodies[i].getY(), 
		                      bodies[i].getXVel(), bodies[i].getYVel(), 
		                      bodies[i].getMass(), bodies[i].getName());	
		}
	}
}
