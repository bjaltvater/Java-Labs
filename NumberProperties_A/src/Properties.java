/**
 * Properties.java is the method library for testing a positive integer
 * 
 */
public class Properties {

	public static boolean isEven(int number) {
		if (number % 2 == 0) {
		} else {
			return false;
		}
		return true;
	}

	public static boolean isOdd(int number) {
		boolean odd = isEven(number);
		if (odd != true) {
		} else {
			return false;
		}
		return true;
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i <= number - 1; i++) {
			int prime = number % i;
			if (prime == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPerfectSquare(int number) {
		for (int i = 1; i <= number; i++) {
			int perfect = (int) Math.pow(i, 2);
			if (perfect == number) {
				return true;
			}if (perfect > number){
				return false;
			}
		}
		return false;
	}

	public static boolean isPerfectNumber(int number) {
		for (int i = 2; i <= number; i++) {
			if (isPrime(i)) {
				int perfectNumber = (int) Math.pow(2, i - 1)
						* (int) (Math.pow(2, i) - 1);
				if (perfectNumber == number) {
					return true;
				}if (perfectNumber > number){
					return false;
				}
			}
		}
		return false;
	}

	public static boolean isFactorialNumber(int number) {
		for (int i = 1; i <= number; i++) {
			int test = Factor(i);
			if (test == number) {
				return true;
			}if (test > number){
				return false;
			}
		}
		return false;
	}

	public static boolean isFibonacciNumber(int number) {
		int x = 0;
		int y = 1;
		if (number == 1) {
			return true;
		} else {
			for (int i = 0; i <= number; i++) {
				int z = x + y;
				x = y;
				y = z;
				if (z == number) {
					return true;
				}
			}
		}
		return false;
	}

	private static int Factor(int number) {
		int answer = number;
		while (number > 1) {
			answer *= --number;
		}
		return answer;
	}
}