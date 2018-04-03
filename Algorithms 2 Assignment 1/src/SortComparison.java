import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author	Robert Leonard 16323797
 *  @version HT 2018
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
    	for(int i = 1; i < a.length ; i++)
    	{
    		int j = i; 
    		double index = a[i];
    		while((j > 0) && (a[j-1] > index))
    		{
    			a[j]=a[j-1];
    			j=j-1;
    		}
    		a[j] = index;
    	}
		return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort(double[] a)
    {
    	 
    	quickSort(a,0,a.length-1); 
    	
    	return a;
    }//end quicksort
    
    private static void quickSort(double[] a, int low, int high) 
    {
    	
    		if (a == null || a.length == 0)
    			return;
     
    		if (low >= high)
    			return; 
     
    		// pick the pivot
    		int middle = low + (high - low) / 2;
    		double pivot = a[middle];
     
    		// make left < pivot and right > pivot
    		int i = low, j = high;
    		while (i <= j) {
    			while (a[i] < pivot) {
    				i++;
    			}
     
    			while (a[j] > pivot) {
    				j--;
    			}
     
    			if (i <= j) {
    				double temp = a[i];
    				a[i] = a[j];
    				a[j] = temp;
    				i++;
    				j--;
    			}
    		}
     
    		// recursively sort two sub parts
    		if (low < j)
    			quickSort(a, low, j);
     
    		if (high > i)
    			quickSort(a, i, high);
    	}
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] mergeSort (double a[])
    {
    	if(a.length>1)
    	{
    		
    		int mid = a.length/2;
    		double[] left = Arrays.copyOfRange(a, 0, mid);
    		double[] right = Arrays.copyOfRange(a, mid, a.length);
    		mergeSort(left);
    		mergeSort(right);
    		mergeSort(a, left, right);

    	}
    	return a;

    	//TODO: implement the sort

    }//end mergesort

    static double[] mergeSort(double[] a, double[] left, double[] right)
    {
    	int total = left.length + right.length;
    	
    	int i, li, ri;
    	i = li = ri = 0;
    	while(i<total)
    	{
    		if ((li < left.length) && (ri<right.length)) {
    			if (left[li] < right[ri]) {
    				a[i] = left[li];
    				i++;
    				li++;
    			}
    			else {
    				a[i] = right[ri];
    				i++;
    				ri++;
    			}
    		}
    		else {
    			if (li >= left.length) {
    				while (ri < right.length) {
    					a[i] = right[ri];
    					i++;
    					ri++;
    				}
    			}
    			if (ri >= right.length) {
    				while (li < left.length) {
    					a[i] = left[li];
    					li++;
    					i++;
    				}
    			}
    		}
    	}
    	return a;
    }

    /**
     * Sorts an array of doubles using Shell Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] shellSort (double a[])
    {
		int len = a.length;
		int h = 1;
		
		while(h < len/3)
			h=3*h +1;
		
		while(h >= 1)
		{
			for(int i = h; i<len; i++)
			{
				for(int j = i; j >= h && (a[j]<a[j-h]); j-=h)
				{
					double temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
				}
			}
			h = h/3;
		}
    	return a;

		 //TODO: implement the sort
		 
    }//end shellsort

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[])
    { 
    	for(int i = 0 ; i < a.length; i++)
    	{
    		int minimumIndex = i;
    		for(int j = i+1; j < a.length; j++)
    			if(a[j] < a[minimumIndex])
    			{
    				minimumIndex = j;
    			}
    		double temp = a[minimumIndex];
    		a[minimumIndex] = a[i];
    		a[i] = temp;
    	}
    	return a;
    	
    }//end selectionsort

    /**
     * Sorts an array of doubles using Bubble Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] bubbleSort (double a[]){
    	double temp;
    	for(int i = 0; i<a.length; i++)
		{
			for(int j =1; j<a.length-i; j++)
			{
				if(a[j-1]>a[j])
				{
					temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}

		}
    	return a;

         
		 
    }//end bubblesort
    

// Commented out experiments for submission to web-cat

//    public static double[] readData( String fileName) throws FileNotFoundException
//    {
//    	ArrayList<Double> list = new ArrayList<Double>();
//    	Scanner scanner = new Scanner(new FileInputStream(fileName));
//    	while(scanner.hasNext())
//    	{
//    		
//    		list.add(scanner.nextDouble());
//    	}
//    	int arrLen =list.size();
//    	double[] a = new double[arrLen];
//    	for(int i = 0; i < arrLen; i++)
//    		a[i] = list.get(i);
//    	return a;
//    }
//
//    // ----------------------------------------------------------
//    /**
//     *  Main Method.
//     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
//     * @throws FileNotFoundException 
//     *
//     *	Commented out for submission to web-cat
//     *
//     */
//    public static void main(String[] args) throws FileNotFoundException
//    {
//    	System.out.println("\nInsertion Sort");
//    	insertionPerformance();
//    	System.out.println("\nQuick Sort");
//    	quickPerformance();
//    	System.out.println("\nMerge Sort");
//    	mergePerformance();
//    	System.out.println("\nShell Sort");
//    	shellPerformance();
//    	System.out.println("\nSelection Sort");
//    	selectionPerformance();
//    	System.out.println("\nBubble Sort");
//    	bubblePerformance();
//    	
//    	
//    }
//    
//
//
//	public static void insertionPerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.insertionSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.insertionSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
//	
//	public static void quickPerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.quickSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.quickSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
//	
//	public static void mergePerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.mergeSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.mergeSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
//	
//	public static void shellPerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.shellSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.shellSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
//	
//	public static void selectionPerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.selectionSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.selectionSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
//	
//	public static void bubblePerformance() throws FileNotFoundException{
//    	double aTotal = 0;
//    	double bTotal = 0;
//    	double cTotal = 0;
//    	double dTotal = 0;
//    	double eTotal = 0;
//    	double fTotal = 0;
//    	double gTotal = 0;
//    	
//    	for(int j=0; j<3; j++)
//    	{
//    		System.out.print("Sort number " + j + "\n");
//
//
//    		double[] a = readData("numbers10.txt");
//    		double start = System.nanoTime();
//    		SortComparison.bubbleSort(a);
//    		aTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//
//    		double[] b = readData("numbers100.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(b);
//    		bTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] c = readData("numbers1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(c);
//    		cTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] d = readData("numbers1000Duplicates.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(d);
//    		dTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] e = readData("numbersNearlyOrdered1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(e);
//    		eTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] f = readData("numbersReverse1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(f);
//    		fTotal += (System.nanoTime() - start)/1000000000;
//    		
//
//    		double[] g = readData("numbersSorted1000.txt");
//    		start = System.nanoTime();
//    		SortComparison.bubbleSort(g);
//    		gTotal += (System.nanoTime() - start)/1000000000;
//
//    		
//
//    	}
//
//
//    	System.out.println("10 Random Average: " + aTotal/3);
//    	System.out.println("100 Random Average: " + bTotal/3);
//    	System.out.println("1000 Random Average: " + cTotal/3);
//    	System.out.println("1000 Few Unique: " + dTotal/3);
//    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
//    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
//    	System.out.println("1000 Sorted Average: " + gTotal/3);
//    	
//    }
    

 }//end class

