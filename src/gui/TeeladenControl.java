package gui;

import java.io.IOException;

import business.Teesorte;
import business.TeesorteModel;
import javafx.stage.Stage;

public class TeeladenControl {
	private TeesorteModel teesorteModel;
	private TeeladenView teeladenView;

	public TeeladenControl(Stage primaryStage) {
		super();
		this.teesorteModel = new TeesorteModel();
		this.teeladenView = new TeeladenView(teesorteModel, this, primaryStage);
	}

	public void leseAusDatei(String typ) {
		try {
			this.teesorteModel.leseAusDatei(typ);
			this.teeladenView.zeigeInformationsfensterAn("Erfolgreich gelesen!");
//			this.teeladenView.zeigeTeesorteAn();
		} catch (IOException exc) {
			teeladenView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			teeladenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeTeesInCsvDatei() {
		try {
			this.teesorteModel.schreibeTeesInCsvDatei();
			this.teeladenView.zeigeInformationsfensterAn("Erfolgreich!");
		} catch (IOException exc) {
			teeladenView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			teeladenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void nehmeTeeAuf() {
		try {
			this.teesorteModel.setTeesorte(new Teesorte(Integer.parseInt(teeladenView.getTxtIdentnummer().getText()),
					teeladenView.getTxtBezeichnung().getText(), teeladenView.getTxtKategorie().getText(),
					teeladenView.getTxtMitKoffein().getText(),
					teeladenView.getTxtEnthalteneKraeuter().getText().split(";")));
			teeladenView.zeigeInformationsfensterAn("Die Teesorte wurde aufgenommen!");
		} catch (Exception exc) {
			teeladenView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

}
