import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class TSTTest {

	@Test
	public void testSize(){
		TST<Integer> trie = new TST<>();
		assertEquals("Size of an empty trie should be 0",0, trie.size());
		trie.put("Hello", 0);
		assertEquals("Size of trie should be 1",1, trie.size());
		trie.put("Hello", 1);
		assertEquals("Size of trie should be 1 just value changed",1, trie.size());
		trie.put("Goodbye", 2);
		trie.put("Bonjour", 3);
		assertEquals("Size of trie should be 3",3, trie.size());
	}

	@Test
	public void testContains(){
		TST<Integer> trie = new TST<>();
		assertFalse("searching an empty trie should return false",trie.contains("Hello"));
		assertFalse("searching a trie for an empty key should return false",trie.contains(""));
		String test = null;
		assertFalse("searching a trie for an null key should return false",trie.contains(test));

		trie.put("Hello", 0);
		trie.put("Hello", 1);
		trie.put("Goodbye", 2);
		trie.put("Bonjour", 3);
		assertTrue("searching a trie for a word it contains should return true",trie.contains("Hello"));
		assertFalse("searching a trie for a word not in it should return false",trie.contains("Algorithm"));
	}

	@Test
	public void testGet(){
		TST<Integer> trie = new TST<>();
		assertNull("searching an empty trie should return null",trie.get("Hello"));
		assertNull("searching a trie for an empty key should return null",trie.get(""));
		String test = null;
		assertNull("searching a trie for an null key should return null",trie.get(test));

		trie.put("Hello", 0);
		trie.put("Hello", 1);
		trie.put("Goodbye", 2);
		trie.put("Bonjour", 3);
		assertEquals("searching a trie for a key it should return the value", (Integer) 1, trie.get("Hello"));
		assertNull("searching a trie for a word not in it should return null",trie.get("Algorithm"));
	}
	
	@Test
	public void testPut(){
		TST<String> trie = new TST<>();
		
		String testVal = null;
		trie.put("Hello", testVal);
		assertFalse("searching a trie for an null Value should return False",trie.contains("Hello"));

		 
		String testKey = null;
		trie.put(testKey, "1");
		assertFalse("searching a trie for an null key should return False",trie.contains(testKey));
		
		testKey = "";
		trie.put(testKey, "1");
		assertFalse("searching a trie for an null key should return False",trie.contains(testKey));

		trie.put("Hello", "0");
		trie.put("Hello", "1");
		trie.put("Goodbye", "2");
		trie.put("Bonjour", "3");
		assertEquals("searching a trie for a key it should return the value", "1", trie.get("Hello"));
		assertNull("searching a trie for a word not in it should return null",trie.get("Algorithm"));
	}



	@Test
	public void testKeysWithPrefix(){
		TST<String> trie = new TST<>();
		
		String testPrefix = null;
		trie.keysWithPrefix(testPrefix);
		assertNull("Searching a trie for keys with the prefix 'null' Value should return null",trie.keysWithPrefix(testPrefix));
		testPrefix = "";
		trie.keysWithPrefix(testPrefix);
		assertNull("Searching a trie for keys with the prefix empty Value should return null",trie.keysWithPrefix(testPrefix));

		 
		String testKey = null;
		trie.put(testKey, "1"); 
		assertFalse("searching a trie for an null key should return False",trie.contains(testKey));
		
		testKey = "";
		trie.put(testKey, "1");
		assertFalse("searching a trie for an null key should return False",trie.contains(testKey));

		try {
			trie = buildTST("google-books-common-words.txt");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Couldn't find file requested");
			e.printStackTrace();
		}
		
		LinkedList list = trie.keysWithPrefix("UNI");
		System.out.println(list.size());
		assertEquals("Number of words with the prefix 'UNI' Should be 164", 164, list.size()); 
		list = trie.keysWithPrefix("NOT-A-REAL-WORD");
		assertEquals("Number of words with the prefix 'NOT-A-REAL-WORD' Should be 0", 0, list.size());
		
	}






	private static TST<String> buildTST(String fileName) throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new FileInputStream(fileName));
		TST<String> trie = new TST<>();

		while(scanner.hasNext())
		{

			String word = scanner.next();
			String frequency = scanner.next();
			trie.put(word, frequency);

		}
		scanner.close();
		return trie;
	}


	private static TST<Integer> parseBusData(String fileName) throws ParseException, IOException
	{
		Reader reader = new FileReader(fileName);
		TST<Integer> trie = new TST<>();
		JSONParser parser = new JSONParser();
		Object parsedObj= parser.parse(reader);
		JSONArray jsonArr = (JSONArray) parsedObj; 

		int arrSize = jsonArr.size();

		// Loop over JSONArray elements  
		for(int i = 0; i < arrSize; i++)
		{
			JSONObject element = (JSONObject) jsonArr.get(i);
			//System.out.println(element.get("Destination"));
			String destination = (String) element.get("Destination");
			if(trie.contains(destination))
			{
				trie.put(destination, trie.get(destination)+1);
			}
			else
			{
				trie.put(destination, 1);
			}
		}
		return trie;
	}



	// @Test
	public void main()
	{
		try 
		{
			TST<String> trie = buildTST("google-books-common-words.txt");
			System.out.println("Number of words/trie size: " + trie.size());
			System.out.println("Frequency of the word 'ALGORITHM': " + trie.get("ALGORITHM"));
			System.out.println("Is the word 'EMOJI': " + trie.contains("EMOJI"));
			System.out.println("Is the word 'BLAH': " + trie.contains("BLAH"));
			System.out.println("Number of words starting with 'TEST': " + trie.keysWithPrefix("TEST").size());


			TST<Integer> busTrie = parseBusData("BUSES_SERVICE_0.json");
			System.out.println("Number of destinations/trie size: " + busTrie.size());

			System.out.println("Is there a bus going to 'SOUTHSIDE': " + busTrie.contains("SOUTHSIDE"));

			LinkedList downDestinations = busTrie.keysWithPrefix("DOWN");
			int totalDownBuses = 0;
			for (int i = downDestinations.size(); i>0; i--)
			{
				totalDownBuses =+ busTrie.get((String) downDestinations.get(i-1));
			}
			System.out.println("Number of buses going to the destination beginning with 'DOWN': " + totalDownBuses );


		} 
		catch (ParseException | IOException e) {
			System.out.println("File not found");

			e.printStackTrace();
		}

	}
}