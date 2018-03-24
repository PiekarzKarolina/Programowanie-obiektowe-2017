package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CleanBibTexFileTest {

	@Test
	void test() {
		FileRead file = new FileRead("CleanBibTexFileTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
		FileStringAccumulator file4 = new FileStringAccumulator(file2);
		CleanBibTexFile file5 = new CleanBibTexFile(file4 ,file3);
		ArrayList<String> cleanBibTexFile = file5.swapStrings();
		assertEquals(cleanBibTexFile.get(0), "@BOOK{");
		assertEquals(cleanBibTexFile.get(1), "author = Ala");
		assertEquals(cleanBibTexFile.get(2), "title = Ala ma kota");
		assertEquals(cleanBibTexFile.get(3), "}");
		}
}
