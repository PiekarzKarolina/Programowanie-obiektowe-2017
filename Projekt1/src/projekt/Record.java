package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa, w kt�rej przechowywane s� dane dotycz�ce pojedynczego rekordu.
 * @author Karolina Piekarz
 */
public class Record {
	/**
	 * Typ rekordu, pozwala na odczytanie p�l obowi�zkowych i opcjonalnych.
	 */
	private Type type;
	/**
	 * Klucz unikalny dla ka�dego rekordu.
	 */
	private String key;
	/**
	 * Pozycje w rekordzie zapisane w HashMapie, ich kluczem jest unikatowa nazwa pola.
	 */
	private HashMap<String, String> fields;
	
	/**
	 * @return Zwraca typ rekordu.
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type Typ rekordu.
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return Zwraca unikalny klucz rekordu.
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key Klucz rekordu.
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return Zwraca pola nale��ce do rekordu.
	 */
	public HashMap<String, String> getFields() {
		return fields;
	}
	/**
	 * @param fields Pola z kt�rych sk�ada si� rekord.
	 */
	public void setFields(HashMap<String, String> fields) {
		this.fields = fields;
	}
	/**
	 * Tworzy obiekt klasy Record.
	 * @param type Typ rekordu.
	 * @param key Uniklany klucz rekordu.
	 * @param fields Pola z kt�rych sk�ada si� rekord.
	 */
	public Record(Type type, String key, HashMap<String, String> fields) {
		this.type = type;
		this.key = key;
		this.fields = fields;
	}
	/**
	 * Zwraca Rekord przetworzony na jeden ci�g znak�w.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = " ";
		s+="\n" + type.toString() + "\n --- \n";
		s+=key;
		for(String hash : fields.keySet()) {
			s+= "\n"+ hash + "		 " + fields.get(hash); 
		}
		return s;
	}
	/**
	 * Przetwarza rekord na jeden ci�g znak�w u�ywaj�c do tego podanego znaku.
	 * @param a Znak u�yty do narysowania obramowania tabeli.
	 * @return Rekord przetworzony na jeden ci�g znak�w, tabel�, kt�rej obramowanie jest utworzone ze znak�w 'a', podanych jako argumenty.
	 */
	public String toString(char a) {
		String s = "";
		for(int i=0; i<=100; i++) s+=a;
		s+="\n" + type.toString() + " (";
		s+=key + ")\n";
		for(String hash : fields.keySet()) {
			for(int i=0; i<=100; i++) s+=a;
			if(hash.trim().equalsIgnoreCase("author")) {
				InterpretNames interpreter = new InterpretNames(this); 
				ArrayList<String> names = interpreter.refactorNames("author");
				s+="\n" + a + hash + "		";
				for(int i=0; i<names.size(); i++) {
					if(i%4==0 && i!=0) {
						s+= "\n\t\t";
					}
					s+= names.get(i);
				}
				s+="\n";
			}
			else if(hash.trim().equalsIgnoreCase("editor")) {
				InterpretNames interpreter = new InterpretNames(this); 
				ArrayList<String> names = interpreter.refactorNames("editor");
				s+="\n" + a + hash + "		";
				for(int i=0; i<names.size(); i++) {
					if(i%4==0 && i!=0) {
						s+= "\n\t\t";
					}
					s+= names.get(i);
				}
				s+="\n";
			}
			else {
				s+= "\n"+ a + hash + "		 " + fields.get(hash) + "\n"; 
			}
		}
		for(int i=0; i<=100; i++) s+=a;
		return s;
	}
	

}
