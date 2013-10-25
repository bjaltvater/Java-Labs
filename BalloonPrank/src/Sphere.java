/*
 * Sphere.java provides sphere related methods
 */
public class Sphere {
	/** Volume of a sphere (class method)
	 * @param radius, the (double) radius of the sphere
	 * @return the volume of a sphere with a radius 
	 */
	
	public static double volume(double radius)
	{
		return 4.0/3.0 * Math.PI * Math.pow(radius,3.0);
	}

	
	
}
