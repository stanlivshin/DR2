package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.Punctuation;

public class PunctuationTest {
	
	@Test
	public void testPunctuation() {
		assertEquals("!", new Punctuation("!").getPunctuation());
		assertEquals(null, new Punctuation().getPunctuation());
		assertNotEquals("?", new Punctuation("!").getPunctuation());
	}
}
