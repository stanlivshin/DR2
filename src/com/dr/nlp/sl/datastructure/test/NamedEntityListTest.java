package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;

public class NamedEntityListTest {

	@Test
	public void testNamedEntityList() {
		NamedEntitiyList.INSTANCE.init(null);
		assertEquals(null, NamedEntitiyList.INSTANCE.getNamedEntityList());
		NamedEntitiyList.INSTANCE.init(new ArrayList<String>());
		assertEquals(0, NamedEntitiyList.INSTANCE.getNamedEntityList().size());
		ArrayList<String> namedEntity = new ArrayList<>();
		namedEntity.add("NamedEntity1");
		NamedEntitiyList.INSTANCE.init(namedEntity);
		assertEquals(1, NamedEntitiyList.INSTANCE.getNamedEntityList().size());
		assertArrayEquals(namedEntity.toArray(), NamedEntitiyList.INSTANCE.getNamedEntityList().toArray());
		assertEquals("NamedEntity1", NamedEntitiyList.INSTANCE.getNamedEntityList().get(0));
		namedEntity.add("NamedEntity2");
		NamedEntitiyList.INSTANCE.init(namedEntity);
		assertEquals(2, NamedEntitiyList.INSTANCE.getNamedEntityList().size());
	}
}
