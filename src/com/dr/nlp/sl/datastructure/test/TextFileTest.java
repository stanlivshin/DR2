package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.TextFile;

public class TextFileTest {

	@Test
	public void testTextFile() {
		TextFile textFile = new TextFile("test.txt");
		textFile.processString("");
		assertEquals("test.txt", textFile.getTextFileName());
		assertEquals(0, textFile.getParagraphArray().size());
		
		textFile.processString("one paragraph");
		assertEquals(1, textFile.getParagraphArray().size());
		
		TextFile textFile2 = new TextFile("test2.txt");
		textFile2.processString("One Paragarph. \n\n Two paragarph. \n\n Three Paragarph.");
		assertEquals("test2.txt", textFile2.getTextFileName());
		assertEquals(3, textFile2.getParagraphArray().size());
	}
}
