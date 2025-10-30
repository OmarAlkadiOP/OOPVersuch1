package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import ownUtil.MeldungsfensterAnzeiger;

public class TeesorteModel {
	private Teesorte teesorte;

	public Teesorte getTeesorte() {
		return teesorte;
	}

	public void setTeesorte(Teesorte teesorte) {
		this.teesorte = teesorte;
	}

	public void leseAusDatei(String typ) throws Exception {
		BufferedReader ein = new BufferedReader(new FileReader("Teesorte.csv"));
		String[] zeile = ein.readLine().split(";");
		this.teesorte = new Teesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
		ein.close();
	}

	public void schreibeTeesInCsvDatei() throws Exception {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
		aus.write(this.teesorte.gibTeesorteZurueck(';'));
		aus.close();
	}
}
