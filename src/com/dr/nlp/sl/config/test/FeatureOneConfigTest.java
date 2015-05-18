package com.dr.nlp.sl.config.test;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;

import org.junit.Test;

import com.dr.nlp.sl.config.FeatureOneConfig;

public class FeatureOneConfigTest {

	@Test
	public void testFeatureOneConfig() {
		assertEquals("nlp_data.txt", new FeatureOneConfig().getInputFile().getName());
		assertEquals("output.xml", new FeatureOneConfig().getOutputFile().getName());
		assertEquals(Charset.forName("UTF-8"), new FeatureOneConfig().getCharset());
	}
}
