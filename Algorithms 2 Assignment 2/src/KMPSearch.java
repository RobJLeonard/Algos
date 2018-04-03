public class KMPSearch 
{

	/*
	 * Bus Service Questions:
	 *
	 * 1. How many total vehicles is there information on?
	 *    987
	 *
	 * 2. Does the file contain information about the vehicle number 16555?
	 *    Yes, at char index 52,432
	 *
	 * 3. Locate the first record about a bus heading to HAMPTON PARK
	 *    Position of HAMPTON PARK in data: 19774
	 *
	 * 4. Does the file contain information about the vehicle number 9043409?
	 *    Contains info on vehicle no. 9043409: false
	 *	  Contains any info on 9043409: false
	 */



	/**
	 * This method creates the DFA for the pattern string.
	 * 
	 * @param pat the pattern string being processed.
	 */
	private static int[][] DFA(String pat)
	{
		int Radix = 256;
		int M = pat.length();
		int[][] dfa = new int[Radix][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int X = 0, j = 1; j < M; j++)
		{
			for(int c = 0; c < Radix; c++)
				dfa[c][j] = dfa[c][X];
			dfa[pat.charAt(j)][j] = j+1;
			X = dfa[pat.charAt(j)][X];
		}
		return dfa;
	}

	/**
	 * The method checks whether a pattern pat occurs at least once in String txt.
	 * 
	 * @param text the text string
	 * @param pat pattern to search for in the text
	 * @return if the pattern string is contained in the text string
	 * 
	 */
	public static boolean contains(String txt, String pat) 
	{
		// Empty strings are invalid.
		if(pat.length() == 0 || txt.length() == 0) return false;
		// Creates DFA
		int[][] dfa = DFA(pat);
		//Perform KMP search to see if the txt contains the pattern.
		int pLen = pat.length();
		int tLen = txt.length();
		int i, j;
		for(i = 0,  j = 0; i < tLen && j < pLen; i++)
			j = dfa[txt.charAt(i)][j];
		if(j == pLen) return true;
		else return false;
	}

	/**
	 * The method returns the index of the first ocurrence of a pattern pat in String txt.
	 * It should return -1 if the pat is not present
	 * 
	 * @param text the text string
	 * @param pat pattern to search for in the text
	 * @return index of the first ocurrence of a pattern pat in String txt or -1 if 
	 * the pat is not present
	 * 
	 */
	public static int searchFirst(String txt, String pat) 
	{
		// Empty strings are invalid.
		if(pat.length() == 0 || txt.length() == 0) return -1;
		// Creates DFA
		int[][] dfa = DFA(pat);
		//Perform KMP search to find index of first occurence of pattern.
		int pLen = pat.length();
		int tLen = txt.length();
		int i, j;
		for(i = 0,  j = 0; i < tLen && j < pLen; i++)
			j = dfa[txt.charAt(i)][j]; 
		if(j == pLen) return i - pLen;
		else return -1;
	}

	/**
	 * The method returns the number of non-overlapping occurences of a pattern pat in String txt.
	 * 
	 * @param text the text string
	 * @param pat pattern to search for in the text
	 * @return number of non-overlapping occurences of a pattern pat in String txt.
	 */
	public static int searchAll(String txt, String pat) 
	{
		// Empty strings are invalid.
		if(pat.length() == 0 || txt.length() == 0) return 0;

		int occurences = 0;
		// Creates DFA
		int[][] dfa = DFA(pat);
		//Perform KMP search to find index of first occurence of pattern.
		int pLen = pat.length();
		int tLen = txt.length();
		int i, j;
		for(i = 0,  j = 0; i < tLen; i++)
		{
			j = dfa[txt.charAt(i)][j]; 
			if(j == pLen)
			{
				occurences += 1;
				j = 0;
				//i += pLen; 
			}
		}
		return occurences;

	}
}