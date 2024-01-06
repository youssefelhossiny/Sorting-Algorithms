package sortingAlgorithms;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
//Works Cited: 
// Quick Sort: https://www.geeksforgeeks.org/quick-sort/ 
// Selection sort: https://www.geeksforgeeks.org/selection-sort/
// Insertion Sort: https://www.geeksforgeeks.org/insertion-sort/
// Random number generator between a specific range: https://www.geeksforgeeks.org/how-do-i-generate-random-integers-within-a-specific-range-in-java/
// used to Calculate elapsed time: https://stackify.com/heres-how-to-calculate-elapsed-time-in-java/


public class Main {
	public static void main(String[] args) {
		
		Main main = new Main();
		main.sortAlgorithm();
	}
	
	public void sortAlgorithm() {
		float nums[] = new float[50]; // array with 50 indexes
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 'Manual' to choose the values of the array or 'Random' to randomize the values of the array");
		String input = scan.nextLine().toLowerCase();
		
		int length = nums.length;
		if (input.contains("random")) {
			for (int i = 0; i < length; i++)
			{
				nums[i] = ThreadLocalRandom.current().nextInt(-100, 101); // create random numbers between -100 and 100
			}
		}
		if (input.contains("manual")) {
			for (int i = 0; i < length; i++)
			{
				int valueNum = i+1;
				float numVerify = 200;
				while(numVerify < -100 || numVerify > 100) // if value entered is below -100 or above 100, the user reinputs the value
				{
					System.out.println("Enter value number " + valueNum + " of the array, such that the value is between -100 and 100");
					String manualArray = scan.nextLine().toLowerCase();
					numVerify =  Float.parseFloat(manualArray);
				}
				nums[i] = numVerify;
			}
		}
		
		System.out.println("Choose one of the sorting algorithms from the list below by entering the corresponding number of the algorithm");
		System.out.println("1. Bubble Sort");
		System.out.println("2. Quick Sort");
		System.out.println("3. Selection Sort");
		System.out.println("4. Insertion Sort");
		String algorithm = scan.nextLine().toLowerCase();
		int algorithmNum = Integer.parseInt(algorithm);
		
		Sort sort = new Sort();
		if(algorithmNum == 1)
		{
			long start = System.nanoTime();
			sort.bubbleSort(nums);
			long end = System.nanoTime();
			long elapsedTime = end - start; 
			for (int i = 0; i < length; i++) 
			{
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			System.out.println("The elapsed time to sort the algorithm is " + elapsedTime + " nanoseconds.");
		} 
		else if (algorithmNum == 2) 
		{
			long start = System.nanoTime();
			sort.quickSort(nums, 0, nums.length - 1);
			long end = System.nanoTime();
			long elapsedTime = end - start; 
	        for(float a :  nums) {
	            System.out.print(a + " ");
	        } 
	        System.out.println();
			System.out.println("The elapsed time to sort the algorithm is " + elapsedTime + " nanoseconds.");
		}
		else if (algorithmNum == 3) {
			long start = System.nanoTime();
			sort.selectionSort(nums);
			long end = System.nanoTime();
			long elapsedTime = end - start; 
	        for (int i = 0; i < length; i++) {
	            System.out.print(nums[i]+ " ");
	        }
	        System.out.println();
			System.out.println("The elapsed time to sort the algorithm is " + elapsedTime + " nanoseconds.");
		}
		else if (algorithmNum == 4) {
			long start = System.nanoTime();
			sort.insertionSort(nums);
			long end = System.nanoTime();
			long elapsedTime = end - start; 
	        for (int i = 0; i < length; i++) {
	            System.out.print(nums[i] + " ");
	        }
	        System.out.println();
	        System.out.println("The elapsed time to sort the algorithm is " + elapsedTime + " nanoseconds.");
		}
	}
}