package com.dr.nlp.sl.datastructure;

import java.util.ArrayList;

import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - TextFile
 * 
 * TextFile data structure represents
 * a single text file which was read into
 * this program. TextFile is responsible
 * for splitting text file input string
 * into Paragarph(s) and storing them in
 * the array list based on regular
 * expression: "\n\n"
 * 
 * This class also implements XMLTagable interface for
 * XML output
 * 
 * @see Paragraph
 * @see XMLTagable
 * @author Stan Livshin
 */
public class TextFile implements XMLTagable {
	
	private ArrayList<Paragraph> paragraphArray;
	private String textFileName;
	
	/**
	 * Constructor
	 * @param textFileName text file which this
	 * TextFile object represents
	 */
	public TextFile(String textFileName) {
		this.textFileName = textFileName;
		this.paragraphArray = new ArrayList<>();
	}
	
	/**
	 * @return Paragraph array list
	 */
	public ArrayList<Paragraph> getParagraphArray() {
		return paragraphArray;
	}
	
	/**
	 * @param string splits this input string
	 * into Paragraph(s)
	 */
	public void processString(String string) {
		if (!string.equals("")) {
			String[] paragraphStringArray = string.split("\\n\\n");
			//split input string into Paragraph(s)
			for (String stringParagraph : paragraphStringArray) {
				Paragraph paragraph = new Paragraph();
				paragraph.processString(stringParagraph);
				paragraphArray.add(paragraph);
			}
		}
	}
	
	/**
	 * @return text file name which this TexFile
	 * object represents
	 */
	public String getTextFileName() {
		return textFileName;
	}

	/**
	 * Used for XML Output tag
	 * @return "TextFile" string
	 */
	@Override
	public String getXMLTagName() {
		return "TextFile";
	}
}
