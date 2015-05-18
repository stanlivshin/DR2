package com.dr.nlp.sl.config;

import java.io.File;

/**
 * FeatureOneConfig extends abstract Config class
 * overriding getInputFile() and getOutputFile()
 * methods.
 * 
 * This config class is used for feature one of the
 * coding challenge. 
 * 
 * @see Config
 * @author Stan Livshin
 */
public class FeatureOneConfig extends Config {

	/**
	 * @return returns input File
	 * @see File
	 */
	@Override
	public File getInputFile() {
		return new File("nlp_data.txt");
	}

	/**
	 * @return returns output File
	 * @see File
	 */
	@Override
	public File getOutputFile() {
		return new File("output.xml");
	}
}
