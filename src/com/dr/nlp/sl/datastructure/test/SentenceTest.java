package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureTwoConfig;
import com.dr.nlp.sl.datastructure.NamedEntity;
import com.dr.nlp.sl.datastructure.Sentence;
import com.dr.nlp.sl.datastructure.SentenceItem;
import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;
import com.dr.nlp.sl.executor.Executor;
import com.dr.nlp.sl.executor.strategy.FileToArrayListStrategy;

public class SentenceTest {

	@Test
	public void testSentence() {
		String text = "This contains 12 words and punctuations.";
		Sentence sentence = new Sentence();
		sentence.processString(text);
		assertEquals(12, sentence.getSentenceItemArray().size());
		
		text = "";
		Sentence sentence2 = new Sentence();
		sentence2.processString(text);
		assertEquals(0, sentence2.getSentenceItemArray().size());
		
		text = "~!@#$%^&*()+=-";
		Sentence sentence3 = new Sentence();
		sentence3.processString(text);
		assertEquals(14, sentence3.getSentenceItemArray().size());
	}
	
	@Test
	public void testNamedEntitiesInSentence() {
		//init config
		Config config = new FeatureTwoConfig();
				
		//read file into ArrayList<String> and store it in the singleton Enum object
		FileToArrayListStrategy fileToArrayListStrategy = new FileToArrayListStrategy(config);
		Executor<ArrayList<String>> fileToArrayListExecutor = new Executor<>(fileToArrayListStrategy);
		NamedEntitiyList.INSTANCE.init(fileToArrayListExecutor.execute());
		
		String text = "England Wales Powys.";
		Sentence sentence = new Sentence();
		sentence.processString(text);
		assertEquals(3, countNamedEntities(sentence));
		
		text = "Powys Wales England."; //reverse order
		Sentence sentence2 = new Sentence();
		sentence2.processString(text);
		assertEquals(3, countNamedEntities(sentence2));
		
		text = "Powys Word Wales AnotherWord England 3rdWord Ernst Haeckel."; //4 named entities, one named entity is two words
		Sentence sentence3 = new Sentence();
		sentence3.processString(text);
		assertEquals(4, countNamedEntities(sentence3));
	}
	
	//helper method, counts named entities in a sentnce
	private int countNamedEntities(Sentence sentence) {
		int count = 0;
		for (SentenceItem item : sentence.getSentenceItemArray()) {
			if (item instanceof NamedEntity)
				count++;
		}
		return count;
	}
}
