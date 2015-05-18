package com.dr.nlp.sl.datastructure;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - Paragraph
 * 
 * Paragraph data structure is created by TextFile
 * and responsible for splitting input string into
 * Sentence(s) using regular expression as sentence
 * boundary:
 * (\.|\?|\!|\."|\.'|\?"|\?'|\!"|\!')\s+[A-Z|"|']
 * 
 * This regular expression will match punctuation
 * at the end of the sentence:
 * . ? ! ." .' ?" ?' !" !' then any number of white
 * space characters followed by uppercase A-Z characters
 * or " ' characters.
 * 
 * This class also implements XMLTagable interface for
 * XML output
 * 
 * @see Sentence
 * @see TextFile
 * @see XMLTagable
 * @author Stan Livshin
 */
public class Paragraph implements XMLTagable {
	
	private final String SENTENCE_BOUNDARY_REGEX = "(\\.|\\?|\\!|\\.\"|\\.'|\\?\"|\\?'|\\!\"|\\!')\\s+[A-Z|\"|\']";
	private ArrayList<Sentence> sentenceArray;
	
	/**
	 * Default constructor
	 */
	public Paragraph() {
		this.sentenceArray = new ArrayList<>();
	}
	
	/**
	 * @return ArrayList<Sentence> array list of sentences
	 */
	public ArrayList<Sentence> getSentenceArray() {
		return sentenceArray;
	}

	/**
	 * Processing string input splitting it into sentences
	 * using regular expression and adding each sentence
	 * into ArrayList<Sentence>
	 * @param string input string to be processed
	 */
	public void processString(String string) {
		if (!string.equals("")) {
			int startIndex = 0;
			Matcher matcher = Pattern.compile(SENTENCE_BOUNDARY_REGEX).matcher(string);
			while (matcher.find()) { //for each sentence boundary found add sentence to arraylist
				if (Config.DEBUG)
					System.out.println(Paragraph.class + " processString(): " + string.substring(startIndex, matcher.end() - 1));
				sentenceArray.add(createNewSentence(string.substring(startIndex, matcher.end() - 1)));
				startIndex = matcher.end() - 1;
			}
			//add leftovers, because last sentence in the string does not get triggered by regular expression
			sentenceArray.add(createNewSentence(string.substring(startIndex)));
		}
	}
	
	//create new sentence helper method
	private Sentence createNewSentence(String string) {
		Sentence sentence = new Sentence();
		sentence.processString(string);
		return sentence;
	}

	/**
	 * Used for XML Output tag
	 * @return "Paragraph" string
	 */
	@Override
	public String getXMLTagName() {
		return "Paragraph";
	}
}
