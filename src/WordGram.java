import java.util.Arrays;

/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		int index = 0;
		
		for (int i = start; i < start + size; i++) {
			myWords[index] = source[i];
			index +=1 ;
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		int counter = 0;
		
		for (int i = 0; i < myWords.length; i++ ) {
			counter +=1; 
		}
		return counter;
	}


	@Override
	public boolean equals(Object o) {
		
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		
		WordGram wg = (WordGram) o;		
		
		return Arrays.equals(wg.myWords, this.myWords);
	}

	@Override
	public int hashCode(){
		if (myHash == 0) {
			return myHash = myWords.toString().hashCode();
		}
		
		return 0;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		
		for (int i = 0; i < myWords.length -1; i++) {
			wg.myWords[i] = myWords[i+1];
		}
		
		wg.myWords[myWords.length -1] = last;
		
		return wg;
	}

	@Override
	public String toString(){
		if (myToString == null) {
			myToString = String.join(" ", myWords);
			}
		return myToString;
		}
}
