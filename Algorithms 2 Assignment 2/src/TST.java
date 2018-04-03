import java.util.LinkedList;


public class TST<Value> 
{

	/*
	 * Bus Service Questions:
	 * 1. How many unique destinations is there in the file?
	 *    171
	 * 2. Is there a bus going to the destination "SOUTHSIDE"?
	 *    FALSE
	 * 3. How many records is there about the buses going to the destination beginning with "DOWN"?
	 *    70 note: there is a destination LANDSODWNE 
	 *    not included here because it does not begin with down as the other entries do
	 *
	 * Google Books Common Words Questions:
	 * 4. How many words is there in the file?
	 *    97565
	 * 5. What is the frequency of the word "ALGORITHM"?
	 *    14433021
	 * 6. Is the word "EMOJI" present?
	 *    TRUE
	 * 7. IS the word "BLAH" present?
	 *    FALSE
	 * 8. How many words are there that start with "TEST"?
	 *    39
	 */




	/* A Node in your trie containing a Value val and a pointer to its children */
	private static class trieNode<Value> 
	{
		private char c;                       	 // character
		private trieNode<Value> left, mid, right;  		 // left, middle, and right subtries
		private Value val;                    	 // value associated with string
	}

	/* a pointer to the start of your trie */
	private trieNode<Value> root = new trieNode<Value>();
	/* size of the ternary search tree */
	private int size;



	/**
	 * Returns the number of words in the trie
	 * @return number of words int the trie
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the word is in the trie
	 * @returns true if the word is in the trie, false otherwise
	 */
	public boolean contains(String key) {
		if(key == null)
			return false;
		return get(key) != null;
	}

	/*
	 * return the value stored in a node with a given key, returns null if word is not in trie
	 */
	public Value get(String key) {
		if(key == null)
		{
			System.out.println("Key cannot be null");
			return null;
		}
		if(key.length() == 0 )
		{
			System.out.println("Key length must be >= 1");
			return null;
		}
		trieNode<Value> x = get(root, key, 0);
		if( x == null) return null;
		return x.val; 
	} 
	
	//return subtrie corresponding to given key
	private trieNode<Value> get(trieNode<Value> x, String key, int d) {
		if (x == null) return null;
		char c = key.charAt(d);
		if      (c < x.c)              return get(x.left,  key, d);
		else if (c > x.c)              return get(x.right, key, d);
		else if (d < key.length() - 1) return get(x.mid,   key, d+1);
		else                           return x;
	}

	/*
	 * stores the Value val in the node with the given key
	 */
	public void put(String key, Value val)  
	{
		if(key == null) 
		{
			System.out.println("Key cannot be null");
			return;
		}
		if(key.length() == 0)
		{
			System.out.println("Key length must be >= 1");
			return;
		}
		if(!contains(key)) size++;
		root = put(root, key, val, 0);
	}
 
	private trieNode<Value> put(trieNode<Value> x, String key, Value val, int d)
	{
		char c = key.charAt(d);
		if( x == null) {
			x = new trieNode<Value>();
			x.c = c;
		}
		if		(c<x.c) 			x.left = put(x.left, key, val, d);
		else if (c>x.c) 			x.right = put(x.right, key, val, d);
		else if (d<key.length()-1)	x.mid = put(x.mid, key, val, d+1);
		else 						x.val = val;
		return x;
	}
 
	/*
	 * returns the linked list containing all the keys present in the trie
	 * that start with the prefix passes as a parameter, sorted in alphabetical order
	 */
	public LinkedList<String> keysWithPrefix(String prefix) 
	{
		if(prefix == null)
		{
			System.out.println("Prefix cannot be null");
			return null;
		}
		if(prefix.length() == 0)
		{
			System.out.println("Prefix length must be >= 1");
			return null;
		}
		LinkedList<String> list = new LinkedList<String>();
		trieNode<Value> x = get(root, prefix, 0);
		if (x == null) return list; 
		if (x.val != null) list.add(prefix);
		gatherKeys(x.mid, new StringBuilder(prefix), list);
		return list;
	}

	private void gatherKeys(trieNode<Value> x, StringBuilder prefix, LinkedList<String> list) {
		if (x == null) return;
		gatherKeys(x.left,  prefix, list);
		if (x.val != null) list.add(prefix.toString() + x.c);
		gatherKeys(x.mid,   prefix.append(x.c), list);
		prefix.deleteCharAt(prefix.length() - 1);
		gatherKeys(x.right, prefix, list);
	}

}