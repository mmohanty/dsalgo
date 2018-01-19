package org.manas.dsalgo.problems;

public class TrieDictionary {

	private int alphabetSize;
	private TrieNode root;
	private char startAlphabet;
	
	public TrieDictionary() {
		startAlphabet = 'a';
		alphabetSize = 26;
		root = new TrieNode();
	}
	public void insert(String key) {
		TrieNode pCrawl = root;
		for(int level=0; level<key.length(); level++) {
			int index = key.charAt(level) - this.startAlphabet;
			if(pCrawl.children[index] == null) {
				pCrawl.children[index]= new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfWord = true;
	}
	
	public boolean search(String key) {
		TrieNode pCrawl = root;
		for(int level = 0; level < key.length(); level++) {
			int index = key.charAt(level) - this.startAlphabet;
			if(pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isEndOfWord);
	}
	
	public void deleteKey(String key) {
		deleteHelper(root, key, 0, key.length());
	}
	private boolean deleteHelper(TrieNode pNode, String key, int level, int length) {
		if(pNode != null) {
			if(level == length) {
				if(pNode.isEndOfWord) {
					pNode.isEndOfWord = false;
					
					// If empty, node to be deleted
	                if( isItFreeNode(pNode) )
	                {
	                    return true;
	                }
	 
	                return false;
				}
			}else // Recursive case
	        {
	            int index = key.charAt(level) - this.startAlphabet;
	 
	            if( deleteHelper(pNode.children[index], key, level+1, length) )
	            {
	                // last node marked, delete it
	                pNode.children[index] = null;
	 
	                // recursively climb up, and delete eligible nodes
	                return ( !pNode.isEndOfWord && isItFreeNode(pNode) );
	            }
	        }
		}
		return false;
		
	}
	
	private boolean isItFreeNode(TrieNode pNode) {
	    for(int i = 0; i < this.alphabetSize; i++)
	    {
	        if( pNode.children[i] != null)
	            return false;
	    }
	 
	    return true;
	}
	public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
      
        TrieDictionary dictionary = new TrieDictionary();
        // Construct trie
        for (int i = 0; i < keys.length ; i++)
        	dictionary.insert(keys[i]);
      
        // Search for different keys
        if(dictionary.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(dictionary.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(dictionary.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(dictionary.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
        
        String keys2[] = {"she", "sells", "sea", "shore", "the", "by", "sheer"};
        TrieDictionary dictionary2 = new TrieDictionary();
        // Construct trie
        for (int i = 0; i < keys2.length ; i++)
        		dictionary2.insert(keys2[i]);
        
        if(dictionary2.search("she") == true)
            System.out.println("she --- " + output[1]);
        else System.out.println("she --- " + output[0]);
        
        dictionary2.deleteKey(keys2[0]);
        
        if(dictionary2.search("she") == true)
            System.out.println("she --- " + output[1]);
        else System.out.println("she --- " + output[0]);
        
    }
	
	class TrieNode{
		boolean isEndOfWord;
		TrieNode[] children = new TrieNode[alphabetSize];
		
		public TrieNode() {
			isEndOfWord = false;
			for(int i=0; i< alphabetSize; i++) {
				children[i] = null;
			}
		}
	}
	
}
