/**
 * Institution: Bellevue College
 * Course: Fundamentals of Computer Science II
 * Quarter: Summer 2026
 * Student name: Paul Hoang
 * Program description: This class includes multiple useful recursion methods
 */



/** 
*This class include useful recursion methods.
* @author Paul Hoang
*/
public class MathematicsRec
{
    /**
     * The method returns a value which:
     * - Increases each of even decimal digits of n by one
     * - Decreases each of  odd decimal digits of n by one
     * @param theDecimalNumber the input decimal number (n)
     * @return the new decimal number after digit adjustments
     */
	
	public static long eduodd(long n) {
		if (n == 0) {
			return 1;
		}
		return eduoddHelper(n);
	}

	private static long eduoddHelper(long n)
	{	
		if (n == 0) {
			return n;
		} else {
			long m = n % 10;
			if (m % 2 == 0) {
				m++;
			} else {
				m--;
			}
			return eduoddHelper(n / 10) * 10 + m;
		}
	}
	

    /**
     * The method accepts non-negative integer and returns a value as described below
     * @param theDecimalNumber is a non-negative decimal number (n)
     * @return the value in following way:
     * - return 1 when n = 0
     * - return sum of fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
     */
	public static int fibby(int n)
	{		

		if (n == 0) {
			return 1;
		}
		return fibbyHelper(n);
	}
	
	private static int fibbyHelper(int n) {
		if (n == 0) {
			return 1;
		}
		return (fibbyHelper(n/4) + fibbyHelper((3 * n) / 4));
	}
	
	
	
    /**
     * The method prints all consecutive values of n and its fibby value
     * @param theLowerBound the lower bound (start)
     * @param theUpperBound the upper bound (end)
     */
	public static void stg(int lower, int upper) {
	    stgHelper(lower, upper, lower);
	}

	private static void stgHelper(int current, int upper, int first) {
	    if (current > upper) {
	        return;
	    }
	    if (current == first || fibby(current) != fibby(current - 1)) {
	        System.out.println(current + " " + fibby(current));
	    }

	    stgHelper(current + 1, upper, first);
	}
	
	
	
		
    /**
     * The method returns the median that split the array into 3 parts
     * @param theList the list of integers (a)
     * @return the median
     */
	public static double median3(int[] n)
	{	
		return medianHelper(n, 0, n.length);
	}
	
	private static double medianHelper(int[] array, int start, int end) {
		
		int length = end - start; 
		
		if (length == 1) {
			return array[start];
		}
		
		if (length == 2) {
			return (array[start] + array[end]) / 2;
		}
		
		int len1;
		int len2;
		
		if (length % 3 == 2) {
			len1 = (length + 2) / 3;
			len2 = (length + 2) / 3;
		} else {
			len1 = length / 3;
			len2 = length / 3;
		} 
		
		int leftStart = start;
		int leftEnd = start + len1;
		
		int midStart = leftEnd;
		int midEnd = end - len2;
		
		int rightStart = end - len2;
		int rightEnd = end;
		
		double medianLeft = medianHelper(array, leftStart, leftEnd);
		double medianMid = medianHelper(array, midStart, midEnd);
		double medianRight = medianHelper(array, rightStart, rightEnd);
		
		return calculateMedian(medianLeft, medianMid, medianRight);
		
		
	}
	
	private static double calculateMedian(double a, double b, double c) {
		
		if ((b <= a && a <= c) || (c <= a && a <= b)) {
			return a;
		} else if ((a <= b && b <= c) || (c <= b && b <= a)) {
			return b;
		} else {
			return c;
		}
		 
		
	}
	
}




