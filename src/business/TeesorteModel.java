package business;

import java.io.BufferedWriter;
import java.io.FileWriter;

import fileCreatorsAlkadi.ConcreteCreatorAB;
import fileCreatorsAlkadi.Creator;
import fileCreatorsAlkadi.Product;

public class TeesorteModel {
	private Teesorte teesorte;

	public Teesorte getTeesorte() {
		return teesorte;
	}

	public void setTeesorte(Teesorte teesorte) {
		this.teesorte = teesorte;
	}

	public void leseAusDatei(String typ) throws Exception {
//		BufferedReader ein = new BufferedReader(new FileReader("Teesorte.csv"));
//		String[] zeile = ein.readLine().split(";");
//		this.teesorte = new Teesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
//		ein.close();
		
		Creator creator = new ConcreteCreatorAB();
		
		Product reader = creator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		
		this.teesorte = new Teesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
	
		reader.schliesseDatei();
	}

	public void schreibeTeesInCsvDatei() throws Exception {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
		aus.write(this.teesorte.gibTeesorteZurueck(';'));
		aus.close();
	}
}
