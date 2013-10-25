
public class Circle {
	/**
	 * Circle.java is a public class that has area, circumference, and volume methods
	 * @param radius, (double)
	 * @return the result of either the area formula, circumference formula, or volume formula
	 */
	
	public static double Area(double radius){
		return Math.PI * Math.pow(radius, 2);		
	}
	
	public static double Circumference(double radius){
		return 2 * Math.PI * radius;
	}
	
	public static double Volume(double radius){
		return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
	}

}
