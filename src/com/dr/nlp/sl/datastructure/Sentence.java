package com.dr.nlp.sl.datastructure;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;
import com.dr.nlp.sl.datastructure.helper.XMLTagable;
/**
 * NLP Data Structure - Sentence
 * 
 * Sentence data structure is created by Paragraph
 * and responsible for splitting input string into
 * SentenceItem(s) items and storing them into
 * array list by using non-word regular expression:
 * "\W"
 * 
 * SentenceItem are subclassed into Word(s),
 * Punctuation(s) and NamedEntity(es).
 * 
 * This class also implements XMLTagable interface for
 * XML output
 * 
 * @see SentenceItem
 * @see Paragraph
 * @see Word
 * @see NamedEntity
 * @see Punctuation
 * @see XMLTagable
 * @author Stan Livshin
 */
public class Sentence implements XMLTagable {
	
	private final String NON_WORD_REGEX = "\\W"; //match any non-word character
	private ArrayList<SentenceItem> sentenceItemArray;
	
	/**
	 * Default constructor
	 */
	public Sentence() {
		this.sentenceItemArray = new ArrayList<>();
	}
	
	/**
	 * Processing string input splitting it into Word(s),
	 * Punctuation(s) and/or NamedEntity(es) using non-word
	 * regular expression
	 * 
	 * @param string - Input String
	 */
	public void processString(String string) {
		if (Config.DEBUG)
			System.out.println(string);
		
		while (containsNamedEntity(string)) { //loop while string still contains named entities to identify
			for (String namedEntity : NamedEntitiyList.INSTANCE.getNamedEntityList()) { //loop through named entity list
				int namedEntityStartIndex = string.indexOf(namedEntity); //find index of named entity
				while (namedEntityStartIndex >= 0) { //there might be more than one named entity in a string
					//since we are looping through named entity list this does not guarantee that
					//that first named entity found in a string is really first one, there might be
					//named entities before it, this if check makes sure that we haven't skipped any
					if (!containsNamedEntity(string.substring(0, namedEntityStartIndex))) {
						addWordOrPunctuation(string.substring(0, namedEntityStartIndex)); //add regular words or punctuation before named entity
						//add named entity
						sentenceItemArray.add(new NamedEntity(string.substring(namedEntityStartIndex, namedEntityStartIndex + namedEntity.length())));
						//update string by removing added parts
						string = string.substring(namedEntityStartIndex + namedEntity.length());
						//find more named entities in the string
						namedEntityStartIndex = string.indexOf(namedEntity);
					} else
						break; //if named entity found is not the first one then break out of the loop to find first one
				}
			}
		}
		//no more named entities, process the rest of the words/punctuations
		addWordOrPunctuation(string);
	}
	
	//helper method tells if there are named entities in the string
	private boolean containsNamedEntity(String string) {
		for (String namedEntity : NamedEntitiyList.INSTANCE.getNamedEntityList())
			if (string.contains(namedEntity))
				return true;
		return false;
	}
	
	/**
	 * Processes words and punctuation in a string
	 * @param string - String to be processed
	 */
	public void addWordOrPunctuation(String string) {
		
		int beginIndex = 0;
		Matcher matcher = Pattern.compile(NON_WORD_REGEX).matcher(string);
		while (matcher.find()) {
			if (beginIndex != matcher.start()) {
				sentenceItemArray.add(new Word(string.substring(beginIndex, matcher.start())));
				beginIndex = matcher.end();
			} else
				beginIndex++;
			
			sentenceItemArray.add(new Punctuation(matcher.group()));
		}
	}
	
	/**
	 * @return SentenceItem array list holding Word(s) and Punctuation(s)
	 */
	public ArrayList<SentenceItem> getSentenceItemArray() {
		return sentenceItemArray;
	}

	/**
	 * Used for XML Output tag
	 * @return "Sentence" string
	 */
	@Override
	public String getXMLTagName() {
		return "Sentence";
	}
}
