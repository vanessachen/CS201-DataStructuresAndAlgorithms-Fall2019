

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
        private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}

	/**
	 * Return x-position of this Body.
	 * @return value of x-position.
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * Return y-position of this Body.
	 * @return value of y-position.
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * Return x-velocity of this Body.
	 * @return value of x-velocity.
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * Return mass of this Body.
	 * @return value of mass.
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * Return file name of this Body.
	 * @return value of this body's file name.
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double deltaX = (b.getX() - myXPos); //the other body's x-position subtracted by this body's x-position
		double deltaY = (b.getY() - myYPos);
		double distance = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
		return distance;
	}

	/**
	 * Return the force exerted on this body by the body (b) specified as the parameter.
	 * @param b: the other body exerting force onto this body
	 * @return the value of the force exerted on this body by body b
	 */
	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double gravitationalConstant = 6.67*1e-11;
		double mass1 = myMass; //this body's mass
		double mass2 = b.getMass(); // the other body's mass
		double radius = this.calcDistance(b);//calculate distance btw ourself (this body) and the other body b
		//use equation F = G* (m1*m2/r^2)
		double force = gravitationalConstant*mass1*mass2/(radius*radius);
		return force;
	}

	/**
	 * Return the force exerted by other body (b) on this body in the X direction
	 * @param b: the other body exerting force on this body (in the X direction)
	 * @return the value of the force exerted on this body in the X direction by the other body b
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		double force = this.calcForceExertedBy(b);
		double deltaX = (b.getX()-myXPos);
		double radius = this.calcDistance(b); //distance between this body and the other body b
		double forceX = force*deltaX/radius;
		//use equation F_x = F*(dx/r); due to roundoff error, we use this equation vs F*r/dx
		return forceX;
	}
	/**
	 * Return the force exerted by other body (b) on this body in the Y direction
	 * @param b: the other body exerting force on this body (in the Y direction)
	 * @return the value of the force exerted on this body in the Y direction by the other body b
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		double force = this.calcForceExertedBy(b);
		double deltaY = (b.getY()-myYPos);
		double radius = this.calcDistance(b); //distance between this body and the other body b
		double forceY = force*deltaY/radius;
		//use equation F_x = F*(dy/r); due to roundoff error, we use this equation vs F*r/dx
		return forceY;
	}

	/**
	 * This method returns the total/net force (in the x-direction) exerted on this body by all the bodies in the array parameter (CelestialBody array called bodies).
	 * @param bodies is the array that contains Celestial Bodies
	 * @return the net force exerted on this body (in the x-direction) by all celestial bodies in the array bodies
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double netForceX = 0;
		for (CelestialBody b : bodies){
			//if the body is not this body (we can't include the force exerted by a body on itself)
			if (! b.equals(this)){
				//add each individual F_x (see calcForceExertedByX method) on this body to the double netForceX (besides itself)
				netForceX = netForceX + this.calcForceExertedByX(b);
			}
		}
		return netForceX;
	}

	/**
	 * This method returns the total/net force exerted on this body (in the y-direction) by all the bodies in the array parameter (CelestialBody array called bodies).
	 * @param bodies is the array that contains Celestial Bodies
	 * @return the net force exerted on this body (in the y-direction) by all celestial bodies in the array bodies
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double netForceY = 0;
		for (CelestialBody b : bodies){
			//if the body is not this body (we can't include the force exerted by a body on itself)
			if (! b.equals(this)){
				//add each individual F_y (see calcForceExertedByY method) on this body to the double netForceY (besides itself)
				netForceY = netForceY + this.calcForceExertedByY(b);
			}
		}
		return netForceY;
	}

	/**
	 * This mutator method updates the state/instance variables of the CelestialBody object that it is being called on.
	 * Method is called during the simulation to update the body's position and velocity with small time steps (deltaT)
	 * The parameters will use the results of calcNetForceExertedByX (or Y) to get xforce and yforce
	 * @param deltaT: the small time steps in which are used to update the body's position and velocity
	 * @param xforce: the net force exerted on this body by all other bodies in the simulation (in the x-direction)
	 * @param yforce: the net force exerted on this body by all other bodies in the simulation (in the y-direction)
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		//note: a_x = F_x/m & a_y = F_y/m
		double aX = xforce/myMass;
		double aY = yforce/myMass;
		//update the new velocity of the CelestialBody using equation: nvx = myXVel + deltaT*ax
		double nvx = myXVel + deltaT*aX;
		double nvy = myYVel + deltaT*aY;
		//use nvx and nvy to calculate the new values for position using equation: nx = myXPos + deltaT*nvx.
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		//assign these new velocities and positions to my(velocity/position)
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;

	}

	/** <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	 * This method implements a method called 'picture' in class StdDraw that will show a non-moving image for each body
	 * in the class (when called in NBody main() after looping through all the bodies).
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
