package com.dr.nlp.sl.datastructure.helper;

import java.util.ArrayList;

import com.dr.nlp.sl.datastructure.NamedEntity;

/**
 * NamedEntityList is a singleton
 * Enum which holds an array list
 * of NamedEntities
 *  
 * @see NamedEntity
 * @author Stan Livshin
 */
public enum NamedEntitiyList {
	
	INSTANCE; //singleton
	
	//holds named entities in an array list
	private ArrayList<String> namedEntityList;
	
	/**
	 * Used to initialize named entity array list
	 * @param namedEntityList - array list which
	 * holds named entities
	 */
	public void init(ArrayList<String> namedEntityList) {
		this.namedEntityList = namedEntityList;
	}
	
	/**
	 * @return array list containing named entities
	 */
	public ArrayList<String> getNamedEntityList() {
		return namedEntityList;
	}
}
