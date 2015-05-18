# Digital Reasoning Remote Programming Exercise

Digital Reasoning Remote Programming Exercise - Feature One, Feature Two

Additional Questions:
---------------------
*Describe any assumptions you make in your implementation.*

1. Assuming that implementation should be information lossless. Meaning that all
the original document structure should be preserved. This includes: paragraphs,
sentences, words, punctuations, white space characters. The input file should
be completely recreatable from the stored Java Object representation.
2. Assuming input files are relatively small.
3. Assuming named entitiy list is relatively small.

*What are the limitations of your approach?*

Two main limitation:

1. Input files are read and stored as String(s). If the input files are large
memory issues could occur.

2. Identifying NamedEntity algorigthm is not very efficient and runs O(N^2) best
case senario. If a large named entity list is used processing can suffer. 

*What other approaches might be possible?*

Processing input files in a stream line by line approach might be better
if the input files are large.

## Feature Two Assignment

2. Modify your program from #1 to add rudimentary recognition of proper nouns
("named entities") in the input, and print a list of recognized named entities
when it runs. The list of named entities is in the file "NER.txt". Enhance your
data structures and output schema to store information about which portions of
the text represent named entities.

### Implementation - Feature Two

#### New Classes

New classes have been added to implement feature two of the programming
exercise:

`FeatureTwoConfig` - stores reference to NER.txt input file.

`FeatureTwoTask` - new task which reads in named entity list into an singleton
Enum class.

`NamedEntityList` - singleton Enum class which stores named entity list in an
`ArrayList<String>`

`FileToArrayListStrategy` - strategy to read in a list of named entities and
pass them into `NamedEntityList`.

`NamedEntity` - data structure which now also extends `SentenceItem` abstract
class.

#### Modified Classes

`com.dr.nlp.sl.Main` - now runs two tasks `FeatureTwoTask` first and then
`FeatureOneTask` which now depends on the `NamedEntityList` being initialized.

`Sentence` - now also splits and holds `NamedEntity` Strings in the
ArrayList<SentenceItem> on top of `Word` and `Punctuation` classes.

#### JUnit 4 Test Suite

`com.dr.nlp.sl.test.TestSuite.java` - holds a number of Unit Tests.

```java

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

```

## Feature One Assignment

1. Write a program that identifies sentence boundaries and tokenizes the text
in the file "nlp_data.txt" into words. It should correctly process all symbols,
including punctuation and whitespace. Every word must fall into a sentence.
Create data structures that efficiently express the data you have processed.
When your program runs it should output an XML representation of your Java
object model.

### Implementation - Feature One

#### `Main`, `TaskRunner`, `Task` Interface

The program can be started by running main in the following package:
`com.dr.nlp.sl.Main`

Main class is responsible for instantiating a `FeatureOneTask` based on `Task`
interface and then using `TaskRunner` class to add and execute this task.

`TaskRunner` can store and execute a number of Tasks at any given time.
Once the `TaskRunner` executes the tasks they will be removed from the queue
allowing more tasks to be added for execution. Tasks are executed by called
`runTask()` method.

#### `FeatureOneTask`, `Config`, `Executor`, `ExecutorStrategy`

`FeatureOneTask` is responsible for instantiating `FeatureOneConfig` which
extends abstract class `Config`. `Config` class holds `Charset`, which by
default is set to "UTF-8". This `Charset` is used when reading in contents of
files. `Config` class also holds `static boolean DEBUG` variable which can be
set to `true` for the program to produce debug information to the console.
`Config` class also defines two abstract methods for input and output files.

`FeatureOneConfig` input file is set to: "nlp_data.txt" while output file is
set to: "output.xml"

`FeatureOneTask` also initialized a number of "Strategy" sub-tasks which can be
executed using `Executor` class. `Executor` utilized Strategy-Desgn Pattern to
execute various sub-task stategies which are based on `ExecutorStrategy`
interface. `ExecutorStrategy` contains a number of template methods to make
stategies felxable and extensible.

```java

public interface ExecutorStrategy<R> {
    public void beforeExecute();
    public void execute();
    public void afterExecute();
    public R getResult();
}

``` 

`Executor` executes stategy methods in the following order:

1. beforeExecute()
2. execute()
3. afterExecute()
4. getResult()

`FeaureOneTask` executes the following strategies to accomplish the Feature One
assignment:

1. `FileToStringStrategy` - reads in file specified in the `FeatureOneConfig`
and store it into a String variable
2. `StringToObjectStrategy` - converts String variable into object
data-structures located in the following package: `com.dr.nlp.sl.datastructure.*`
3. `ObjectToXMLStrategy` - converts `com.dr.nlp.sl.datastructure.*`
data-structures into a XML `Document` object
4. `XMLToFileStrategy` - save `Document` into `FeatureOneConfig` output file
and print the `Document` to console.

#### Data-Structures `com.dr.nlp.sl.datastructure.*`

`TextFile` - holds any number of `Paragraph`(s) from the input file. Uses
regular expression `"\n\n"` to split String into `Paragraph`(s).
`Paragraph` - holds any number of `Sentence`(s) from the input file. Uses
regular expression `"(\.|\?|\!|\."|\.'|\?"|\?'|\!"|\!')\s+[A-Z|"|']"` to find
`Sentence` boundaries.
`Sentence` - holds any number of `SentenceItem`(s). Uses "\W" non-word regular
expression to split input String into `Word`(s) and `Punctuation`(s).
`SencenteItem` - abstract class which is subclassed by `Word` and `Punctuation`
`Word` - holds String words.
`Punctuation` - holds String punctuations.

#### JUnit 4 Test Suite

`com.dr.nlp.sl.test.TestSuite.java` - holds a number of Unit Tests.

```java

@Suite.SuiteClasses({
   FeatureOneConfigTest.class,
   ParagraphTest.class,
   PunctuationTest.class,
   SentenceTest.class,
   TextFileTest.class,
   WordTest.class,
   FileToStringStrategyTest.class,
   ObjectToXMLStrategyTest.class,
   StringToObjectStrategyTest.class,
   TaskRunnerTest.class
   
})

```

## Author

[Stan Livshin](http://www.stanlivshin.com)

## License

Free for private use.