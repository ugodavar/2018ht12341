import java.util.Arrays;
import java.util.Scanner;

/**
 * This program finds the minimum number of platforms required
 * to accommodate the list of trains with given schedules.
 * 
 */

/**
 * @author umakanth.godavarthy (BITS ID: 2018HT12341)
 *
 */
public class MinimumPlatforms {
	//These are just example arrays	
	private int[] arr = {900,915,1030,1045};
	private int[] dep = {930,1300,1100,1145};
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinimumPlatforms minPlatforms = new MinimumPlatforms();
		Scanner sc = new Scanner(System.in);
		int[] arr=null, dep=null;
		try{
		 arr = getIntArray(sc.nextLine());
		 dep = getIntArray(sc.nextLine());
		}catch(Exception ex){
			System.out.println("Exception:" + ex);
		}
		if(arr == null || dep == null || (arr.length != dep.length)){
			System.out.println("Please enter correct Arrival and departure "
					+ "arrays with comma separated values of integers");
			System.out.println("Using example arrays...");
			System.out.println("arr = {900,915,1030,1045}");
			System.out.println("dep = {930,1300,1100,1145}");
		}else{
			minPlatforms.setArrivalArray(arr);
			minPlatforms.setDepartureArray(dep);
		}
		int numPlatforms = minPlatforms.findMinimumPlatforms();
		
		System.out.println("Minimum number of platforms required are: " + numPlatforms);
		sc.close();
	}
	/**
	 * Convert a line with comma separated integers to an int array
	 * @param line
	 * @return
	 */
	public static int[] getIntArray(String line){
		String strArray[] = line.split(",");
		int arr[] = new int[strArray.length];
		for(int i=0; i< arr.length;i++){
			arr[i] = Integer.parseInt(strArray[i]);
		}
		return arr;
	}
	/**
	 * This calculates the minimum number of platforms required
	 * to accommodate the trains.
	 * @return
	 */
	public int findMinimumPlatforms(){
		int platformCount = 0, i=0,j=0, maxPlatforms = platformCount;
		Arrays.sort(arr);
		Arrays.sort(dep);
		while(i < arr.length && j < dep.length){

			if(arr[i] <= dep[j]){
				platformCount++;
				//Update the maxValue
				if(platformCount > maxPlatforms)
					maxPlatforms = platformCount;
				i++;
			}else{
				platformCount--;
				j++;
			}
			
		}
		return maxPlatforms;
	}
	
	public void setArrivalArray(int[] arr){
		this.arr = arr;
	}

	public void setDepartureArray(int[] dep){
		this.dep = dep;
	}
}
