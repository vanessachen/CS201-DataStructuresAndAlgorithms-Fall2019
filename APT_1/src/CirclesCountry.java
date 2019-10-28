/**
 * https://www2.cs.duke.edu/csed/newapt/circlescountry.html
 */

/**
 * Constraints:
 * x will contain between 1 and 50 elements, inclusive.
 * x, y and r will each contain the same number of elements.
 * Each element of x and y will be between -1000 and 1000, inclusive.
 * Each element of r will be between 1 and 1000, inclusive.
 * x1, y1, x2 and y2 will be between -1000 and 1000, inclusive.
 * No two circumferences will have common points.
 * The points (x1,y1) and (x2,y2) will not lie on any of the circumferences.
 */

/**
 * Note: If point A is INSIDE a circle, and point B is not in the same circle, point A must exit A's circle (+1)
 * If point B is IN a different circle than point A, point A must cross point B's circle (+1)
 */



public class CirclesCountry {

    /**
     * Returns true if a point is inside a circle and
     * returns false otherwise.
     * @param x is x-coordinate of point
     * @param y is y-coordinate of point
     * @param cx is center of circle x-coordinate
     * @param cy is center of circle y-coordinate
     * @param r is radius of circle
     * @return true if (x,y) is inside circle, returns
     * false if (x,y) is on or outside circle
     */
    public boolean isInside(int x, int y, int cx, int cy, int r){
        /**
         * Note: If any circle is within a circle, unless their both in that circle, then they must cross that circle
         */
        //quicker to do this than square root, for a computer
        double dist = (x-cx)*(x-cx) + (y-cy)*(y-cy); // this also is an equation of a circle: (x-h)^2 + (y-k)^2 = r^2 //this is the squared version of the distance formula: sqrt((x-x_1)^2 + (y-y_1)^2)
        double radSquared = r*r; //r^2
        return dist < radSquared; //if our distance is less than the r^2, we are in that circle, return TRUE or FALSE
    }

    public int leastBorders(int[] x, int[] y, int[] r,
                            int x1, int y1, int x2, int y2) {
        // you write code here
        /**
         * int crosses = 0;
         * 	for(Circle c : input parameters){
         * 		if (isInside(x1,y1,c) && ! isInside(x2,y2,c) {
         * 			crosses += 1;
         *                }* 	}
         * 	return crosses;
         *
         * 	for(int k=0; k < x.length; k += 1) {
         *     if (isInside(x1,y1,x[k],y[k],r[k]) && (!isInside(...) {...}
         * }
         */
        int crosses = 0;
        for (int i=0; i<x.length; i+=1){
            /**
            boolean A_InCircle = isInside(int x[i], int y[i], int x1, int y1, int r);
            boolean B_InCircle = isInside(int x[i], int y[i], int x2, int y2, int r);
            if ((A_InCircle && B_InCircle) || (! A_InCircle && !B_InCircle)){

            }
            else if (A_InCircle || B_InCircle){
                crosses +=1;
            }
             */
            if (isInside(x1,y1,x[i],y[i],r[i]) && (!isInside(x2,y2,x[i],y[i],r[i]))){
                crosses+=1;
            }
            else if (!isInside(x1,y1,x[i],y[i],r[i]) && (isInside(x2,y2,x[i],y[i],r[i]))){
                crosses+=1;
            }

        }

        return crosses;
    }
}
