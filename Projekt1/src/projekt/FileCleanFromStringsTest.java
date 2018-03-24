package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FileCleanFromStringsTest {

	@Test
	void test() {
		FileRead file = new FileRead("FileCleanFromStringsTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
		ArrayList<String> fileWithoutStrings = file3.cleanFile();
		assertEquals(fileWithoutStrings.get(0), "@BOOK{");
		assertEquals(fileWithoutStrings.get(1), "}");
		//fail("Not yet implemented");
	}

}
