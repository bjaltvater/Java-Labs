/*
 * Calculation.java will calculate the energy using Einstien's Formula
 */
public class Calculation {
	
/** Energy calculation
 * @param mass, (double) mass of the object
 * @return energy, (double) engery using Einstien's Formula
 */
	final static long light = 299792458;
	
	public static long energy(long mass){
		return (long) (mass * Math.pow(light, 2));
	}
	
	
}
