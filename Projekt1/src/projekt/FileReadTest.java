package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FileReadTest {

	@Test
	void test() {
		FileRead file = new FileRead("FileReadTest.txt");
		ArrayList<String> fileContent = file.readFile();
		assertEquals(fileContent.get(0), "Ala ma kota.");
		assertEquals(fileContent.get(1), "Ala ma 2 koty.");
		//fail("Not yet implemented");
	}

}
