package projekt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class InterpertNamesTest {

	@Test
	void test() throws Exception{
		FileRead file = new FileRead("InterpretNamesTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
		FileStringAccumulator file4 = new FileStringAccumulator(file2);
		CleanBibTexFile file5 = new CleanBibTexFile(file4 ,file3);
		Parser file6 = new Parser(file5);
		Base base = file6.parse();
		for(Record record: base.getBase().values()) {
			InterpretNames interpreter = new InterpretNames(record); 
			ArrayList<String> fullName =  interpreter.refactorNames("author");
			/*if(fullName!=null) {
				int x = 0;
				for(String s: fullName) {
					if(x%4==0) {
						System.out.println("First: " + s);
					}
					else if(x%4==1) {
						System.out.println("von: " + s);
					}
					else if(x%4==2) {
						System.out.println("Last: " + s);
					}
					else {
						System.out.println("Jr: " + s);
						System.out.println("");
					}
					x++;
				}
			}*/
			assertEquals(fullName.get(0).trim(), "Michael");
			assertEquals(fullName.get(1).trim(), "");
			assertEquals(fullName.get(2).trim(), "Knuth");
			assertEquals(fullName.get(3).trim(), "");
		}
	}

}
