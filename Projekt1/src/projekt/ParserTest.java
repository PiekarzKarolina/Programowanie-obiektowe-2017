package projekt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void test() throws Exception {
		FileRead file = new FileRead("ParserTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
		FileStringAccumulator file4 = new FileStringAccumulator(file2);
		CleanBibTexFile file5 = new CleanBibTexFile(file4 ,file3);
		Parser file6 = new Parser(file5);
		Base base = file6.parse();
		base.print();
		assertEquals(base.getBase().get("aaa").getFields().get("author"), "Ala");
		assertEquals(base.getBase().get("aaa").getFields().get("title"), "Ala ma kota");
	}

}
