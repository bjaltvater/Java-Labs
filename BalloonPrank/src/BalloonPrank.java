import java.util.Scanner;

public class BalloonPrank {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
			
		// get the balloon radius
		System.out.print("Enter the balloon radius (inches): ");
		double balloonRadius = keyboard.nextDouble();
		
		System.out.print("Enter the length of the room radius (feet): ");
		double lengthRoom = keyboard.nextDouble();
		
		System.out.print("Enter the width of the room radius (feet): ");
		double widthRoom = keyboard.nextDouble();
		
		System.out.print("Enter the height of the room radius (feet): ");
		double heighthRoom = keyboard.nextDouble();
		
		balloonRadius /= 12.0; //convert inches to feet
		//compute the balloon and room values
		
		double balloonVolume = Sphere.volume(balloonRadius);
		double bedroomVolume = Box.volume(lengthRoom, widthRoom, heighthRoom);
		
		//compute balloonRequire
		double balloonsRequired = bedroomVolume / balloonVolume;
		
		System.out.printf("Using balloons of a radius %.0f inches, " + " you will need %.0f balloons"
		, balloonRadius*12, balloonsRequired);

	}

}
