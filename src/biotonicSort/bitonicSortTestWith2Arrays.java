package biotonicSort;

import java.util.Arrays;
import java.util.Scanner;

public class bitonicSortTestWith2Arrays {
	
	private static int[]inputBiotonicArray1;
	private static int[]inputBiotonicArray2;
	private static int[]Result;
	private static int ArrPeek1;
	private static int ArrPeek2;

	public static void main(String[] args) {
		
		//Generate test case
		
		inputBiotonicArray1 = new int[6];
		inputBiotonicArray2 = new int[6];
		inputBiotonicArray1[0]=1;
		inputBiotonicArray1[1]=4;
		inputBiotonicArray1[2]=7;
		inputBiotonicArray1[3]=13;
		inputBiotonicArray1[4]=11;
		inputBiotonicArray1[5]=9;
		
		inputBiotonicArray2[0]=3;
		inputBiotonicArray2[1]=10;
		inputBiotonicArray2[2]=8;
		inputBiotonicArray2[3]=6;
		inputBiotonicArray2[4]=5;
		inputBiotonicArray2[5]=2;
		
		for (int i = 0;i<inputBiotonicArray1.length;i++) 
		{
			if(inputBiotonicArray1[i]>ArrPeek1) {
				ArrPeek1 = inputBiotonicArray1[i];
			}
		}
		System.out.println("Peek1 = "+ArrPeek1);
		
		for (int i = 0;i<inputBiotonicArray2.length;i++) 
		{
			
			if(inputBiotonicArray2[i]>ArrPeek2) {
				ArrPeek2 = inputBiotonicArray2[i];
			}
		}
		System.out.println("Peek2 = "+ArrPeek2);
		
		//start sortAlgorithm
		Result = new int[inputBiotonicArray1.length+inputBiotonicArray2.length];
		System.out.println(Arrays.toString(sortUp(0,0,0)));
	}
	
	private static int[] sortUp(int i, int j, int c) {
		
		if(inputBiotonicArray1[i]<ArrPeek1&&inputBiotonicArray2[j]<ArrPeek2)
		{
			if(inputBiotonicArray1[i]<=inputBiotonicArray2[j]) {
				Result[c]=inputBiotonicArray1[i];
				System.out.println(inputBiotonicArray1[i]+" added!");
				i++;
				c++;
				return sortUp(i,j,c);
			}
			else {
				Result[c]=inputBiotonicArray2[j];
				System.out.println(inputBiotonicArray2[j]+" added!");
				j++;
				c++;
				return sortUp(i,j,c);
			}
		}
		
		else if(inputBiotonicArray1[i]<ArrPeek1) {
			Result[c]=inputBiotonicArray1[i];
			System.out.println(inputBiotonicArray1[i]+" added!");
			i++;
			c++;
			return sortUp(i,j,c);
		}
		
		else if(inputBiotonicArray2[j]<ArrPeek2) {
			Result[c]=inputBiotonicArray2[j];
			System.out.println(inputBiotonicArray2[j]+" added!");
			j++;
			c++;
			return sortUp(i,j,c);
		}
		return sortDown(i,j,c);
	}
	
	private static int[] sortDown(int i, int j, int c) {
		
		if(i<inputBiotonicArray1.length&&j<inputBiotonicArray1.length)
		{
			if(inputBiotonicArray1[i]>inputBiotonicArray2[j]) {
				Result[c]=inputBiotonicArray1[i];
				System.out.println(inputBiotonicArray1[i]+" added!");
				i++;
				c++;
				return sortDown(i,j,c);
			}
			else {
				Result[c]=inputBiotonicArray2[j];
				System.out.println(inputBiotonicArray2[j]+" added!");
				j++;
				c++;
				return sortDown(i,j,c);
			}
		}
		
		else if(i<inputBiotonicArray1.length) {
			Result[c]=inputBiotonicArray1[i];
			System.out.println(inputBiotonicArray1[i]+" added!");
			i++;
			c++;
			return sortUp(i,j,c);
		}
		
		else if(j<inputBiotonicArray2.length) {
			Result[c]=inputBiotonicArray2[j];
			System.out.println(inputBiotonicArray2[j]+" added!");
			j++;
			c++;
			return sortDown(i,j,c);
		
		}
		return Result;
	}

}
