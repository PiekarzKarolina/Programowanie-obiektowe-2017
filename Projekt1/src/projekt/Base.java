package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Podstawowa klasa ��cz�ca ze sob� wszystkie rekordy w baz�.
 * @author Karolina Piekarz
 */
public class Base {
		/**
		 * Baza rekord�w zapisanych w HashMapie za pomoc� unikalanej warto�ci dla ka�dego rekordu znajduj�cego si� w bazie - jego klucza.
		 */
		private HashMap<String, Record> base;

		/**
		 * @return Zwraca baz� rekord�w.
		 */
		public HashMap<String, Record> getBase() {
			return base;
		}

		/**
		 * Przypisuje do zmiennej base baz� rekord�w.
		 * @param base Baza rekord�w.
		 */
		public void setBase(HashMap<String, Record> base) {
			this.base = base;
		}

		/**
		 * Tworzy obiekt klasy Base.
		 * @param base Baza rekord�w.
		 */
		public Base(HashMap<String, Record> base) {
			this.base = base;
		}
		/**
		 * Wypisuje baz�, ka�dy rekord w bazie jest wypisywany osobno.
		 * @see Record#toString()
		 */
		public void print() {
			for(String s : base.keySet()) {
				System.out.println(base.get(s).toString());
			}
		}
		/**
		 * Wypisuje baz�, u�ywaj�c do tego podanego znaku, ka�dy rekord w bazie jest wypisywany osobno.
		 * @param a Znak u�yty do narysowania obramowania tabeli.
		 * @see Record#toString(char)
		 */
		public void print(String a){
			char b = a.charAt(0);
			for(String s : base.keySet()) {
				System.out.println(base.get(s).toString(b));
			}
		}
		
		/**
		 * Wyszukuje w bazie wszystkie rekordy o podanym typie, ka�dy rekord w bazie, spe�niaj�cy warunki, jest wypisywany osobno. Je�eli nie ma danego typu rekordu w bazie wypisuje komunikat.
		 * @param s Typ rekordu, podany jako napis.
		 * @param a Znak u�yty do narysowania obramowania tabeli.
		 * @see Record#toString(char)
		 * @see Type#toString()
		 */
		public void searchType(String s, String a){
			boolean results = false;
			char b = a.charAt(0);
			for(Record record : base.values()) {
				if(s.equalsIgnoreCase(record.getType().toString())) {
					System.out.println(record.toString(b));
					results = true;
				}
			}
			if(!results) System.out.println("Search gave no results.");
		}
		/**
		 *  Wyszukuje w bazie wszystkie rekordy o podanym typie, ka�dy rekord w bazie, spe�niaj�cy warunki, jest dodawany do listy, kt�ra jest zwracana na ko�cu wykonania tej metody. 
		 * @param s Typ rekordu, podany jako napis.
		 * @return Lista posiadaj�ca tylko rekordy danego typu.
		 * @see Type#toString()
		 */
		public ArrayList<Record> searchType2(String s) {
			ArrayList<Record> result = new ArrayList<Record>();
			for(Record record : base.values()) {
				if(s.equalsIgnoreCase(record.getType().toString())) {
					result.add(record);
				}
			}
			return result;
		}
		/**
		 *  Wyszukuje w bazie wszystkie rekordy w kt�rych wyst�puje autor/edytor o podanym nazwisku, ka�dy rekord w bazie, spe�niaj�cy warunki, jest wypisywany osobno. Je�eli nie ma danego typu rekordu w bazie wypisuje komunikat.
		 * @param s Nazwisko, podane jako napis.
		 * @param a Znak u�yty do narysowania obramowania tabeli.
		 * @see InterpretNames
		 * @see Record#toString(char)
		 */
		public void searchAuthorName(String s, String a){
			char b = a.charAt(0);
			boolean results = false;
			for(Record record : base.values()) {
				if(record.getFields().get("author")==null) {}
				else {
					InterpretNames interpreter = new InterpretNames(record); 
					ArrayList<String> names = interpreter.refactorNames("author");
					for(int i=2; i<names.size(); i+=4) {
						if(s.equalsIgnoreCase(names.get(i).trim())) {
							System.out.println(record.toString(b));
							results = true;
						}
					}
				}
				if(record.getFields().get("editor")==null) {}
				else {
					InterpretNames interpreter = new InterpretNames(record); 
					ArrayList<String> names2 = interpreter.refactorNames("editor");
					for(int i=2; i<names2.size(); i+=4) {
						if(s.equalsIgnoreCase(names2.get(i).trim())) {
							System.out.println(record.toString(b));
							results = true;
						}
					}
				}
				
			}
			if(!results) System.out.println("Search gave no results.");
		}
		
		
		
}
