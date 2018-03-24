package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FileCleanerTest {

	@Test
	void test() {
		FileRead file = new FileRead("FileCleanerTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		ArrayList<String> fileCleaned = file2.cleanFile();
		assertEquals(fileCleaned.get(0), "@BOOK{ bbc");
		assertEquals(fileCleaned.get(1), "a{a}");
		assertEquals(fileCleaned.get(2), "a");
		assertEquals(fileCleaned.get(3), "}");
		assertEquals(fileCleaned.get(4), "@BOOK{ }");
		//fail("Not yet implemented");
	}

}
