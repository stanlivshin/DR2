package com.dr.nlp.sl.executor.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

import com.dr.nlp.sl.config.Config;

/**
 * This strategy is used to read in text files
 * into a String
 * 
 * @author Stan Livshin
 */
public class FileToStringStrategy implements ExecutorStrategy<String> {
	
	private Config config; //holds input file name
	private BufferedReader reader; //opens/reads file
	private StringBuilder sb; //holds file contents
	
	/**
	 * @param config holds input file name
	 */
	public FileToStringStrategy(Config config) {
		this.config = config;
		this.sb = new StringBuilder();
	}

	/**
	 * before executing strategy open file
	 */
	@Override
	public void beforeExecute() {
		try {
			reader = Files.newBufferedReader(config.getInputFile().toPath(), config.getCharset());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	/**
	 * read line by line into StringBuilder
	 */
	@Override
	public void execute() {
		try {
			String line = null;
			while ((line = reader.readLine()) != null)
				sb.append(line).append("\n"); //preserve new line characters to identify paragraphs
				
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}

	/**
	 * close file after executing strategy
	 */
	@Override
	public void afterExecute() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return String - contents of the input file
	 */
	@Override
	public String getResult() {
		return sb.toString();
	}
}
