package com.dr.nlp.sl.config;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @author Stan Livshin
 * 
 * abstract class Config which holds number of common
 * features such as static DEBUG variable. Setting to true
 * will produce debug output.
 * 
 * Charset variable which is used when reading input files
 */
public abstract class Config {
	
	//produces debug output to console if true
	public final static boolean DEBUG = false;
	//used while reading in files
	private Charset charset = Charset.forName("UTF-8");

	/**
	 * @return Charset used while reading in files
	 * default is set to UTF-8
	 */
	public Charset getCharset() {
		return charset;
	}
	
	public abstract File getInputFile();
	public abstract File getOutputFile();
}
