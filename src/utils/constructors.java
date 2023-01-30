package utils;

import java.util.Random;

public class constructors {
	public static boolean chance(double chance){
		Random rand = new Random();
	    double random1 = rand.nextDouble() * 100.0D;
	    if (random1 <= chance) {
	    	return true;
	    }
	    return false;
	}
	
	
	private static final Random rand = new Random();
	
	public static int getRandInt(int min, int max) throws IllegalArgumentException { return rand.nextInt(max - min + 1) + min; }
}
