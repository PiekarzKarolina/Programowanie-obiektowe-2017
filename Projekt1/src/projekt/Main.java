package projekt;


/**
 * 
 * Klasa odpowiadaj¹ca za wykonanie programu.
 * Obsu³uguje argumenty podane przy uruchomieniu programu.
 * @author Karolina Piekarz
 * 
 */
public class Main {

	/**
	 * W zaleznoœci od liczby argumentów wykonywane s¹ ró¿ne mo¿liwoœci. Je¿eli argumanty s¹ podane poprawnie tworzona jest baza pozycji i na niej wykonywane s¹ dalsze dzia³ania.
	 * @param args Argumenty podane przy uruchomieniu programu.
	 */
	public static void main(String[] args){
		if(args.length==0) {
			System.out.println("filename - prints base\n"
					+ "filename a  - prints base with char a\n"
					+ "filename a -a name - prints records with autor name witch char a\n"
					+ "filename -a name - prints records with autor name \n"
					+ "filename -t type - prints records with autor name witch char a\n"
					+ "filename a -t type - prints records with autor name witch char a\n");
		}
		else if(args.length == 1) {
			BaseGenerator generator = new BaseGenerator(args[0]);
			Base base = generator.generate();
			base.print("-");
		}
		else if(args.length==2) {
			BaseGenerator generator = new BaseGenerator(args[0]);
			Base base = generator.generate();
			base.print(args[1]);
		}
		else if(args.length==3) {
			if(args[1].equals("-a")) {
				BaseGenerator generator = new BaseGenerator(args[0]);
				Base base = generator.generate();
				base.searchAuthorName(args[2], "-");
			}
			else if(args[1].equals("-t"))
			{
				BaseGenerator generator = new BaseGenerator(args[0]);
				Base base = generator.generate();
				base.searchType(args[2], "-");
				
			}
			else {
				System.out.println("filename - prints base\n"
						+ "filename a  - prints base with char a\n"
						+ "filename a -a name - prints records with autor name witch char a\n"
						+ "filename -a name - prints records with autor name \n"
						+ "filename -t type - prints records with autor name witch char a\n"
						+ "filename a -t type - prints records with autor name witch char a\n");
			}
		}
		else if(args.length==4) {
			if(args[2].equals("-a")) {
				BaseGenerator generator = new BaseGenerator(args[0]);
				Base base = generator.generate();
				base.searchAuthorName(args[3], args[1]);
				}
			else if(args[2].equals("-t"))
			{
				BaseGenerator generator = new BaseGenerator(args[0]);
				Base base = generator.generate();
				base.searchType(args[3], args[1]);
			}
			else {
				System.out.println("filename - prints base\n"
						+ "filename a  - prints base with char a\n"
						+ "filename a -a name - prints records with autor name witch char a\n"
						+ "filename -a name - prints records with autor name \n"
						+ "filename -t type - prints records with autor name witch char a\n"
						+ "filename a -t type - prints records with autor name witch char a\n");
			}
		}
		else {
			System.out.println("filename - prints base\n"
					+ "filename a  - prints base with char a\n"
					+ "filename a -a name - prints records with autor name witch char a\n"
					+ "filename -a name - prints records with autor name \n"
					+ "filename -t type - prints records with autor name witch char a\n"
					+ "filename a -t type - prints records with autor name witch char a\n");
		}
		
	}

}
