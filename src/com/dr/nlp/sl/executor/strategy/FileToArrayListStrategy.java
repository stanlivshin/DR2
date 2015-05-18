package com.dr.nlp.sl.executor.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;

/**
 * This strategy is used to read in text file
 * lines into an ArrayList<String>
 * 
 * @see NamedEntitiyList
 * @author Stan Livshin
 */
public class FileToArrayListStrategy implements ExecutorStrategy<ArrayList<String>> {

	private Config config; //holds input file name
	private BufferedReader reader; //opens/reads file
	private ArrayList<String> arrayList; //holds file contents
	
	/**
	 * @param config holds input file name
	 */
	public FileToArrayListStrategy(Config config) {
		this.config = config;
		this.arrayList = new ArrayList<>();
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
	 * read line by line into ArrayList<String>]
	 * will skip empty that are: line.trim().equals("")
	 */
	@Override
	public void execute() {
		try {
			String line = null;
			while ((line = reader.readLine()) != null)
				if (!line.trim().equals(""))
					arrayList.add(line.trim());
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
	 * @return ArrayList<String> - contents of the input file
	 */
	@Override
	public ArrayList<String> getResult() {
		return arrayList;
	}

}
