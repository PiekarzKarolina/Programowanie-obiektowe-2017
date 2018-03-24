package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FileStringAccumulatorTest {

	@Test
	void test() {
		FileRead file = new FileRead("FileStringAccumulatorTest.txt");
		FileCleaner file1 = new FileCleaner(file);
		FileStringAccumulator file2 = new FileStringAccumulator(file1);
		HashMap<String, String> accumulator = file2.getAccumulator();
		String[] keys = accumulator.keySet().toArray(new String[0]);
		String[] values = accumulator.values().toArray(new String[0]);
		if(keys.length != 2 || values.length != 2) fail("Fail.");
		assertEquals(keys[0], "aaa");
		assertEquals(keys[1], "bbb");
		assertEquals(values[0], "Ala ma kota.");
		assertEquals(values[1], "Alicja");
	}

}
