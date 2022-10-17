package catchingDreams;

import java.util.Scanner;
import java.util.Locale;

public class ExceptionTraining {
	public static void main(String [] args) {
	        Scanner sc = new Scanner(System.in);
	        int numNum = sc.nextInt();
	        minMax(numNum);
	        sc.close();
	        
	    }
	    
	    public static void minMax(int numNum) {
	    	Scanner sc = new Scanner(System.in).useLocale(Locale.UK);	        
	        double numArr[] = new double[numNum];    
	        for (int i = 0; i < numNum; i++) {
	            numArr[i] = sc.nextDouble();
	        }
	        sc.close();
	        double min = 999;
	        double max = -999;
	        for (int i = 0; i < numNum; i++) {
	        	if (numArr[i] > max) {
	        		max = numArr[i];	
	        	}
	        	else if (numArr[i] < min) {
	        		min = numArr[i];
	        	}
	        }
	        System.out.println(min + " " + max);
	    }
}
