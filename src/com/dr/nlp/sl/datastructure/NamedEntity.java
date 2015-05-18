package com.dr.nlp.sl.datastructure;

import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - NamedEntity
 * NamedEntity data structure is created by
 * Sentence and responsible for identifying
 * named entities in a sentence.
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
public class NamedEntity extends SentenceItem implements XMLTagable {
	
	//holds named entity in a String
	private String namedEntity;
	
	/**
	 * Default constructor initializes namedEntity to null;
	 */
	public NamedEntity() {
		this.namedEntity = null;
	}
	
	/**
	 * Constructor
	 * @param namedEntity - String
	 */
	public NamedEntity(String namedEntity) {
		this.namedEntity = namedEntity;
	}

	/**
	 * @return namedEntity String
	 */
	public String getNamedEntity() {
		return namedEntity;
	}

	/**
	 * Sets named entity to the String parameter
	 * @param namedEntity String
	 */
	public void setNamedEntity(String namedEntity) {
		this.namedEntity = namedEntity;
	}

	/**
	 * Used for XML Output tag
	 * @return "NamedEntity" string
	 */
	@Override
	public String getXMLTagName() {
		return "NamedEntity";
	}
}
