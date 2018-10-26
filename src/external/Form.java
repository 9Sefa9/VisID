package external;

import controllers.FormController;
import controllers.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Form {

        public SimpleStringProperty name;
        public SimpleStringProperty mobil;
        public SimpleStringProperty email;
        public SimpleStringProperty firma;
        public SimpleStringProperty vorgesetzter;
        public SimpleStringProperty strasse;
        public SimpleStringProperty plzOrt;
        public SimpleStringProperty notwendigeArbeitsbereiche;
        public SimpleStringProperty vonDatum;
        public SimpleStringProperty bisDatum;
        public SimpleStringProperty kreuz0;
        public SimpleStringProperty kreuz1;
        public SimpleStringProperty kreuz2;
        public SimpleStringProperty kreuz3;
        public SimpleStringProperty kreuz00;
        public SimpleStringProperty kreuz01;
        public SimpleStringProperty kreuz02;
        public SimpleStringProperty kreuz10;
        public SimpleStringProperty kreuz11;
        public SimpleStringProperty kreuz12;
        public SimpleStringProperty kreuz20;
        public SimpleStringProperty kreuz21;
        public SimpleStringProperty kreuz22;

        public Form(){
            this.name = new SimpleStringProperty();
            this.mobil = new SimpleStringProperty();
            this.email  = new SimpleStringProperty();
            this.firma  = new SimpleStringProperty();
            this.vorgesetzter= new SimpleStringProperty();
            this.strasse= new SimpleStringProperty();
            this.plzOrt = new SimpleStringProperty();
            this.notwendigeArbeitsbereiche = new SimpleStringProperty();
            this.vonDatum = new SimpleStringProperty();
            this.bisDatum = new SimpleStringProperty();
            this.kreuz0 = new SimpleStringProperty();
            this.kreuz1= new SimpleStringProperty();
            this.kreuz2 = new SimpleStringProperty();
            this.kreuz3 = new SimpleStringProperty();
            this.kreuz00 = new SimpleStringProperty();
            this.kreuz01  = new SimpleStringProperty();
            this.kreuz02  = new SimpleStringProperty();
            this.kreuz10 = new SimpleStringProperty();
            this.kreuz11  = new SimpleStringProperty();
            this.kreuz12 = new SimpleStringProperty();
            this.kreuz20  = new SimpleStringProperty();
            this.kreuz21  = new SimpleStringProperty();
            this.kreuz22  = new SimpleStringProperty();

        }


}
