package com.dr.nlp.sl.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.dr.nlp.sl.config.test.FeatureOneConfigTest;
import com.dr.nlp.sl.config.test.FeatureTwoConfigTest;
import com.dr.nlp.sl.datastructure.test.NamedEntityListTest;
import com.dr.nlp.sl.datastructure.test.NamedEntityTest;
import com.dr.nlp.sl.datastructure.test.ParagraphTest;
import com.dr.nlp.sl.datastructure.test.PunctuationTest;
import com.dr.nlp.sl.datastructure.test.SentenceTest;
import com.dr.nlp.sl.datastructure.test.TextFileTest;
import com.dr.nlp.sl.datastructure.test.WordTest;
import com.dr.nlp.sl.executor.strategy.test.FileToArrayListStrategyTest;
import com.dr.nlp.sl.executor.strategy.test.FileToStringStrategyTest;
import com.dr.nlp.sl.executor.strategy.test.ObjectToXMLStrategyTest;
import com.dr.nlp.sl.executor.strategy.test.StringToObjectStrategyTest;
import com.dr.nlp.sl.task.test.TaskRunnerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   FeatureOneConfigTest.class,
   FeatureTwoConfigTest.class,
   NamedEntityTest.class,
   ParagraphTest.class,
   PunctuationTest.class,
   SentenceTest.class,
   TextFileTest.class,
   WordTest.class,
   NamedEntityListTest.class,
   FileToArrayListStrategyTest.class,
   FileToStringStrategyTest.class,
   ObjectToXMLStrategyTest.class,
   StringToObjectStrategyTest.class,
   TaskRunnerTest.class
   
})
public class TestSuite {   
}  