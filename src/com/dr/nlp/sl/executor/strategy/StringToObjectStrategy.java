package com.dr.nlp.sl.executor.strategy;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.datastructure.Paragraph;
import com.dr.nlp.sl.datastructure.Punctuation;
import com.dr.nlp.sl.datastructure.Sentence;
import com.dr.nlp.sl.datastructure.SentenceItem;
import com.dr.nlp.sl.datastructure.TextFile;
import com.dr.nlp.sl.datastructure.Word;

/**
 * converts String into com.dr.nlp.sl.datastructure.* Objects
 * starting with TextFile to Paragarph(s) to Sentence(s) to
 * SentenceItem(s) such as Word(s), Punctuation(s) and
 * NamedEntity(es)
 * 
 * @see TextFile
 * @see Paragraph
 * @see Sentence
 * @see SentenceItem
 * @see Word
 * @see Punctuation
 * @see NamedEntity
 * @author Stan Livshin
 *
 */
public class StringToObjectStrategy implements ExecutorStrategy<TextFile> {
	
	private TextFile resultTextFile;
	private String string;
	
	/**
	 * Constructor
	 * @param config - config which holds input file name
	 * @param string - String contents of input file
	 */
	public StringToObjectStrategy(Config config, String string) {
		this.resultTextFile = new TextFile(config.getInputFile().getName());
		this.string = string;
	}

	/**
	 * empty
	 */
	@Override
	public void beforeExecute() {}

	/**
	 * Start processing input string by passing it
	 * to the TextFile
	 */
	@Override
	public void execute() {
		resultTextFile.processString(string);
	}

	/**
	 * empty
	 */
	@Override
	public void afterExecute() {}

	/**
	 * @return TextFile
	 */
	@Override
	public TextFile getResult() {
		return resultTextFile;
	}
}
