import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/*
 *
 * 	Algorithm Performance Results 
 * 							insert		Quick		Merge		
 * 						|	
 * 	10 random			|	0.0000055	0.0000188	0.0000539
 *	100 random			|	0.0000617	0.0000709	0.0001096
 *	1000 random			|	0.0062385	0.0007777	0.0001151
 *	1000 few unique		|	0.0012566	0.0002870	0.0005674
 *	1000 nearly ordered	|	0.0002535	0.0001776	0.0003971
 *	1000 reverse order	|	0.0012643	0.0001249	0.0003048
 *	1000 sorted			|	0.0000090	0.0001017	0.0002696
 * 
 * 						|	Shell		Selection	Bubble
 * 						|
 * 	10 random			|	0.0000136	0.0000069	0.0000076
 *	100 random			|	0.0000696	0.0000902	0.0001657
 *	1000 random			|	0.0001093	0.0031234	0.0065362
 *	1000 few unique		|	0.0009226	0.0001965	0.0038145
 *	1000 nearly ordered	|	0.0005443	0.0001702	0.0012173
 *	1000 reverse order	|	0.0003793	0.0010710	0.0010741
 *	1000 sorted			|	0.0002263	0.0008275	0.0009513
 * 
 * 1. Which of the sorting algorithms does the order of input have an impact on? Why?
 * ANS: Insertions sort and Selection sort were affected by order of the input. 
 * This is because both of these can be seriously affected by a reverse ordered list, also 
 * a sorted list is the best case scenario for insertion sort
 *  
 * 
 *	2. Which algorithm has the biggest difference between the best and worst performance, based
 *	on the type of input, for the input of size 1000? Why?
 *	ANS: Insertion sort had the biggest difference in result between the different types of 1000
 *	element arrays. Because with insertion sort all elements behind the one currently being sorted 
 *	are guaranteed to be ordered that means the best case is for an already sorted array in which 
 *	case the runtime is (O) n 
 *	But with a reversed ordered insertion sort has to move every element the whole way along the 
 *	array, this is the worst case and the run time is (O) n^2
 *
 *	3. Which algorithm has the best/worst scalability, ie, the difference in performance time based
 *	on the input size? Please consider only input files with random order for this answer.
 *	ANS: Bubble sort was the worst affected by order of magnitude of the input. This is 
 * 	because bubble sort has to go through every element and swap it along the array until 
 * 	it finds an element smaller than it, worst case runtime is (O) n^2  
 *
 *	4. Which algorithm is the fastest for each of the 7 input files?
 *	
 *	ANS:
 *	10 random			|	Insertion Sort
 *	100 random			|	Insertion Sort
 *	1000 random			|	Shell Sort
 *	1000 few unique		|	Selection Sort
 *	1000 nearly ordered	|	Selection Sort
 *	1000 reverse order	|	Quick Sort
 *	1000 sorted			|	Insertion Sort
 * 
 * 	All my answers are based off the data collected using my algorithms 
 * 	and run on my own laptop.
 * 
 */
//-------------------------------------------------------------------------



//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author	Robert Leonard 16323797
 *  @version HT 2018
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	assertEquals("Checking insertionSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.insertionSort(empty)));

    	
    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	
    	assertEquals("Checking insertionSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(SortComparison.insertionSort(a)));
    	 
    }
    
    @Test
    public void testBubbleSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	assertEquals("Checking bubbleSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.bubbleSort(empty)));

    	
    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	
    	assertEquals("Checking bubbleSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(SortComparison.bubbleSort(a)));
    	
    }

    
    @Test
    public void testSelectionSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	assertEquals("Checking selectionSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.selectionSort(empty)));

    	
    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	
    	assertEquals("Checking selectionSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(SortComparison.selectionSort(a)));
    	
    }
    
    @Test
    public void testShellSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	assertEquals("Checking shellSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.shellSort(empty)));

    	
    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	SortComparison.shellSort(a);
    	assertEquals("Checking shellSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(SortComparison.shellSort(a)));
    	
    	try {
			a = readData("numbers1000.txt");
			aSorted = readData("numbersSorted1000.txt");
			a = SortComparison.shellSort(a);
	    	assertEquals("Checking shellSort() for an array of 1000 doubles", Arrays.toString(aSorted), Arrays.toString(a));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }
    
    @Test
    public void testMergeSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	//assertEquals("Checking mergeSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.mergeSort(empty)));

    	
    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	SortComparison.mergeSort(a);
    	assertEquals("Checking mergeSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(SortComparison.mergeSort(a)));
    	
    }
    
    @Test
    public void testQuickSort()
    {
    	double[] empty = {};
    	String emptyString = "[]";		// Brackets because of the square brackets added by toString()
    	assertEquals("Checking quickSort() for an empty array of doubles", emptyString, Arrays.toString(SortComparison.quickSort(empty)));

    	//Test included for code coverage
    	double[] one = {1.0};
    	double[] oneSorted = {1.0};
    	assertEquals("Checking quickSort() for an array of 1 double", Arrays.toString(oneSorted), Arrays.toString(SortComparison.quickSort(one)));

    	
    	double[] aSorted = {1, 2, 4.5, 5, 6.8};  
    	double[] a = {5, 1, 6.8, 2, 4.5};
    	a = SortComparison.quickSort(a);
    	assertEquals("Checking quickSort() for an array of 5 doubles", Arrays.toString(aSorted), Arrays.toString(a));
    	
    	try {
			a = readData("numbers1000.txt");
			aSorted = readData("numbersSorted1000.txt");
			a = SortComparison.quickSort(a);
	    	assertEquals("Checking quickSort() for an array of 1000 doubles", Arrays.toString(aSorted), Arrays.toString(a));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    
    public static double[] readData( String fileName) throws FileNotFoundException
    {
    	ArrayList<Double> list = new ArrayList<Double>();
    	Scanner scanner = new Scanner(new FileInputStream(fileName));
    	while(scanner.hasNext())
    	{
    		
    		list.add(scanner.nextDouble());
    	}
    	int arrLen =list.size();
    	double[] a = new double[arrLen];
    	for(int i = 0; i < arrLen; i++)
    		a[i] = list.get(i);
    	return a;
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
     */
    public static void main(String[] args) throws FileNotFoundException
    {
    	System.out.println("\nInsertion Sort");
    	insertionPerformance();
    	System.out.println("\nQuick Sort");
    	quickPerformance();
    	System.out.println("\nMerge Sort");
    	mergePerformance();
    	System.out.println("\nShell Sort");
    	shellPerformance();
    	System.out.println("\nSelection Sort");
    	selectionPerformance();
    	System.out.println("\nBubble Sort");
    	bubblePerformance();
    	
    	
    }
    


	public static void insertionPerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.insertionSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.insertionSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }
	
	public static void quickPerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.quickSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.quickSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }
	
	public static void mergePerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.mergeSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.mergeSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }
	
	public static void shellPerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.shellSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.shellSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }
	
	public static void selectionPerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.selectionSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.selectionSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }
	
	public static void bubblePerformance() throws FileNotFoundException{
    	double aTotal = 0;
    	double bTotal = 0;
    	double cTotal = 0;
    	double dTotal = 0;
    	double eTotal = 0;
    	double fTotal = 0;
    	double gTotal = 0;
    	
    	for(int j=0; j<3; j++)
    	{
    		System.out.print("Sort number " + j + "\n");


    		double[] a = readData("numbers10.txt");
    		double start = System.nanoTime();
    		SortComparison.bubbleSort(a);
    		aTotal += (System.nanoTime() - start)/1000000000;
    		


    		double[] b = readData("numbers100.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(b);
    		bTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] c = readData("numbers1000.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(c);
    		cTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] d = readData("numbers1000Duplicates.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(d);
    		dTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] e = readData("numbersNearlyOrdered1000.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(e);
    		eTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] f = readData("numbersReverse1000.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(f);
    		fTotal += (System.nanoTime() - start)/1000000000;
    		

    		double[] g = readData("numbersSorted1000.txt");
    		start = System.nanoTime();
    		SortComparison.bubbleSort(g);
    		gTotal += (System.nanoTime() - start)/1000000000;

    		

    	}


    	System.out.println("10 Random Average: " + aTotal/3);
    	System.out.println("100 Random Average: " + bTotal/3);
    	System.out.println("1000 Random Average: " + cTotal/3);
    	System.out.println("1000 Few Unique: " + dTotal/3);
    	System.out.println("1000 Nearly Ordered: " + eTotal/3);
    	System.out.println("1000 Reverse Order Average: " + fTotal/3);
    	System.out.println("1000 Sorted Average: " + gTotal/3);
    	
    }

}

