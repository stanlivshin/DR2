package com.dr.nlp.sl.datastructure;

import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - Punctuation
 * Punctuation data structure is created by
 * Sentence and responsible for identifying
 * non-word sentence items such as punctuation.
 * Example: white-space , . ! ? " ' ( ) * @ # $ % ^ & *
 * - _ = + { } [ ] ; : < > / ` ~ etc.
 * 
 * This class also implements XMLTagable interface for
 * XML output
 *  
 * @see Sentence
 * @see XMLTagable
 * @author Stan Livshin
 */
public class Punctuation extends SentenceItem implements XMLTagable {
	
	//holds string representation of punctuation
	private String punctuation;
	
	/**
	 * Default constructor
	 */
	public Punctuation() {
		this.punctuation = null;
	}
	
	/**
	 * Constructor which takes a String to initialize punctuation
	 * @param punctuation - String
	 */
	public Punctuation(String punctuation) {
		this.punctuation = punctuation;
	}

	/**
	 * 
	 * @return String represenation of punctuation
	 */
	public String getPunctuation() {
		return punctuation;
	}

	/**
	 * Set punctuation to a String
	 * @param punctuation - String
	 */
	public void setPunctuation(String punctuation) {
		this.punctuation = punctuation;
	}

	/**
	 * Used for XML Output tag
	 * @return "Punctuation" string
	 */
	@Override
	public String getXMLTagName() {
		return "Punctuation";
	}
}