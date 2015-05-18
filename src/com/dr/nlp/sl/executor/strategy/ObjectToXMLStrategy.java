package com.dr.nlp.sl.executor.strategy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.dr.nlp.sl.datastructure.NamedEntity;
import com.dr.nlp.sl.datastructure.Paragraph;
import com.dr.nlp.sl.datastructure.Punctuation;
import com.dr.nlp.sl.datastructure.Sentence;
import com.dr.nlp.sl.datastructure.SentenceItem;
import com.dr.nlp.sl.datastructure.TextFile;
import com.dr.nlp.sl.datastructure.Word;


/**
 * converts com.dr.nlp.sl.datastructure.TextFile into XML Document
 * 
 * @see TextFile
 * @author Stan Livshin
 */
public class ObjectToXMLStrategy implements ExecutorStrategy<Document> {
	
	private TextFile textFile;
	private Document document;
	
	/**
	 * Constructor
	 * @param textFile - TextFile to be converted into XML Document
	 */
	public ObjectToXMLStrategy(TextFile textFile) {
		this.textFile = textFile;
	}

	/**
	 * empty
	 */
	@Override
	public void beforeExecute() {}

	/**
	 * Convert TextFile into XML Document
	 * using dom libraries: org.w3c.dom.* 
	 */
	@Override
	public void execute() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			// root elements
			this.document = documentBuilder.newDocument();
			Element rootElement = document.createElement(textFile.getXMLTagName());
			rootElement.setAttribute("fileName", textFile.getTextFileName());
			document.appendChild(rootElement);

			for (Paragraph paragraph : textFile.getParagraphArray()) { //add each paragraph
				Element paragraphElement = document.createElement(paragraph.getXMLTagName());
				rootElement.appendChild(paragraphElement);

				for (Sentence sentence : paragraph.getSentenceArray()) { //add each sentence
					Element sentenceElement = document.createElement(sentence.getXMLTagName());
					paragraphElement.appendChild(sentenceElement);
					
					for (SentenceItem sentenceItem : sentence.getSentenceItemArray()) { //loop through SentenceItems
						if (sentenceItem instanceof Word) { // add Words
							Word word = (Word)sentenceItem;
							Element wordElement = document.createElement(word.getXMLTagName());
							wordElement.appendChild(document.createTextNode(word.getWord()));
							sentenceElement.appendChild(wordElement);
						}
						else if (sentenceItem instanceof Punctuation) { // add Punctuations
							Punctuation punctuation = (Punctuation)sentenceItem;
							Element punctuationElement = document.createElement(punctuation.getXMLTagName());
							punctuationElement.appendChild(document.createTextNode(punctuation.getPunctuation()));
							sentenceElement.appendChild(punctuationElement);
						}
						else if (sentenceItem instanceof NamedEntity) { //add NamedEntities
							NamedEntity namedEntity = (NamedEntity)sentenceItem;
							Element namedEntityElement = document.createElement(namedEntity.getXMLTagName());
							namedEntityElement.appendChild(document.createTextNode(namedEntity.getNamedEntity()));
							sentenceElement.appendChild(namedEntityElement);
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * empty
	 */
	@Override
	public void afterExecute() {}

	/**
	 * @return - returns XML Document
	 */
	@Override
	public Document getResult() {
		return document;
	}
}
