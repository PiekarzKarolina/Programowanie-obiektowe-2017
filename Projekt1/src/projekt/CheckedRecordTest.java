package projekt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckedRecordTest {

	@Test
	void test() throws Exception {
		FileRead file = new FileRead("CheckedRecordTest.txt");
		FileCleaner file2 = new FileCleaner(file);
		FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
		FileStringAccumulator file4 = new FileStringAccumulator(file2);
		CleanBibTexFile file5 = new CleanBibTexFile(file4 ,file3);
		Parser file6 = new Parser(file5);
		Base base = file6.parse();
		for(Record record : base.getBase().values()) {
			GetRecordType file7 = new GetRecordType();
			CheckedRecord file8 = file7.getType(record);
			file8.getRequired();
			file8.getOptional();
			file8.checkAndSet();
		}
	}

}
