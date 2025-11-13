package fileCreatorsAlkadi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	BufferedReader br;

	public ConcreteProductA() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("Teesorte.csv"));

	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub

		String[] ergebnisZeile = br.readLine().split(";");

		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		br.close();
	}

}
