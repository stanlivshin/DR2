package com.dr.nlp.sl.config.test;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;

import org.junit.Test;

import com.dr.nlp.sl.config.FeatureTwoConfig;

public class FeatureTwoConfigTest {

	@Test
	public void testFeatureTwoConfig() {
		assertEquals("NER.txt", new FeatureTwoConfig().getInputFile().getName());
		assertEquals(null, new FeatureTwoConfig().getOutputFile());
		assertEquals(Charset.forName("UTF-8"), new FeatureTwoConfig().getCharset());
	}
}
