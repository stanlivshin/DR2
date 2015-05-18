package com.dr.nlp.sl.executor.strategy;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.dr.nlp.sl.config.Config;

/**
 * Output XML Document to a file
 * output file name is stored in Config
 * object
 * 
 * @see Config
 * @author Stan Livshin
 */
public class XMLToFileStrategy implements ExecutorStrategy<Void> {
	
	private Config config;
	private Document document;
	
	/**
	 * Constructor
	 * @param config - config file which holds output file name
	 * @param document - document to be saved
	 */
	public XMLToFileStrategy(Config config, Document document) {
		this.config = config;
		this.document = document;
	}

	/**
	 * empty
	 */
	@Override
	public void beforeExecute() {}

	/**
	 * Save document contents into a file and output contents to the console
	 */
	@Override
	public void execute() {
		try {
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(config.getOutputFile());
			transformer.transform(source, result);

			// Output to console
			System.out.println("Saved " + config.getOutputFile().getName() + " file with the following XML contents:");
			StreamResult resultSysOut = new StreamResult(System.out);
			transformer.transform(source, resultSysOut);
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * empty
	 */
	@Override
	public void afterExecute() {}

	/**
	 * empty
	 */
	@Override
	public Void getResult() {
		return null;
	}
}
