package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.NamedEntity;

public class NamedEntityTest {

	@Test
	public void testNamedEntity() {
		assertEquals("test", new NamedEntity("test").getNamedEntity());
		assertEquals(null, new NamedEntity().getNamedEntity());
		NamedEntity namedEntity = new NamedEntity();
		namedEntity.setNamedEntity("test2");
		assertEquals("test2", namedEntity.getNamedEntity());
		assertEquals("NamedEntity", namedEntity.getXMLTagName());
	}
}
