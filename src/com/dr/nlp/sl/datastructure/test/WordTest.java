package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.Word;

public class WordTest {

	@Test
	public void testWord() {
		assertEquals(null, new Word().getWord());
		assertEquals("", new Word("").getWord());
		assertEquals("word", new Word("word").getWord());
		assertEquals("Word", new Word().getXMLTagName());
		assertNotEquals("Punctuation", new Word("SomeWord").getWord());
		Word word = new Word();
		word.setWord("test");
		assertEquals("test", word.getWord());
	}
}
