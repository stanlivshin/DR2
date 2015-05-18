package com.dr.nlp.sl.datastructure;

import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - Word
 * Word data structure is created by
 * Sentence and responsible for identifying
 * words in a sentence.
 * 
 * This class is a extends SentenceItem
 * 
 * This class also implements XMLTagable interface for
 * XML output
 *  
 * @see Sentence
 * @see XMLTagable
 * @author Stan Livshin
 */
public class Word extends SentenceItem implements XMLTagable {
	
	//holds word in a String
	private String word;
	
	/**
	 * Default constructor - initializes word to null
	 */
	public Word() {
		this.word = null;
	}
	
	/**
	 * Constructor
	 * @param word - String
	 */
	public Word(String word) {
		this.word = word;
	}
	
	/**
	 * @return String word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word - String
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Used for XML Output tag
	 * @return "Word" string
	 */
	@Override
	public String getXMLTagName() {
		return "Word";
	}

}
