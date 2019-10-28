import java.util.*;
import java.io.*;

//often in this class, there are things online for us to submit our code, and it runs it for us, not in IntelliJ
public class Gravity {
    /*
    public static void main(String[] args){
        System.out.println(falling(3,0));
    }
     */
    //add public static double falling (){ if above is not commented out
    public double falling(double time, double velo) {
        // fill in code here
        double gravity = 9.8;
        // d = v_0*t + 0.5*a*t^2
        return velo * time + 0.5 * gravity * time * time;
    }

}