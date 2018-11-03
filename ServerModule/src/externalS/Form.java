package externalS;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

import java.io.*;

public class Form {
        private transient Button button;
        private SimpleStringProperty name;
        private SimpleStringProperty mobil;
        private SimpleStringProperty email;
        private SimpleStringProperty firma;
        private SimpleStringProperty vorgesetzter;
        private SimpleStringProperty strasse;
        private SimpleStringProperty plzOrt;
        private SimpleStringProperty notwendigeArbeitsbereiche;
        private SimpleStringProperty vonDatum;
        private SimpleStringProperty bisDatum;
        private SimpleStringProperty kreuz0;
        private SimpleStringProperty kreuz1;
        private SimpleStringProperty kreuz2;
        private SimpleStringProperty kreuz3;
        private SimpleStringProperty kreuz00;
        private SimpleStringProperty kreuz01;
        private SimpleStringProperty kreuz02;
        private SimpleStringProperty kreuz10;
        private SimpleStringProperty kreuz11;
        private SimpleStringProperty kreuz12;
        private SimpleStringProperty kreuz20;
        private SimpleStringProperty kreuz21;
        private SimpleStringProperty kreuz22;

        public Form(){
            this.button = new Button("Download");
            this.name = new SimpleStringProperty("");
            this.mobil = new SimpleStringProperty("");
            this.email  = new SimpleStringProperty("");
            this.firma  = new SimpleStringProperty("");
            this.vorgesetzter= new SimpleStringProperty("");
            this.strasse= new SimpleStringProperty("");
            this.plzOrt = new SimpleStringProperty("");
            this.notwendigeArbeitsbereiche = new SimpleStringProperty("");
            this.vonDatum = new SimpleStringProperty("");
            this.bisDatum = new SimpleStringProperty("");
            this.kreuz0 = new SimpleStringProperty("");
            this.kreuz1= new SimpleStringProperty("");
            this.kreuz2 = new SimpleStringProperty("");
            this.kreuz3 = new SimpleStringProperty("");
            this.kreuz00 = new SimpleStringProperty("");
            this.kreuz01  = new SimpleStringProperty("");
            this.kreuz02  = new SimpleStringProperty("");
            this.kreuz10 = new SimpleStringProperty("");
            this.kreuz11  = new SimpleStringProperty("");
            this.kreuz12 = new SimpleStringProperty("");
            this.kreuz20  = new SimpleStringProperty("");
            this.kreuz21  = new SimpleStringProperty("");
            this.kreuz22  = new SimpleStringProperty("");

        }

    public Button getButton(){
            return this.button;
    }
    public void setButton(Button button){
            this.button = button;
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMobil() {
        return mobil.get();
    }

    public void setMobil(String mobil) {
        this.mobil.set(mobil);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getFirma() {
        return firma.get();
    }

    public void setFirma(String firma) {
        this.firma.set(firma);
    }

    public String getVorgesetzter() {
        return vorgesetzter.get();
    }

    public void setVorgesetzter(String vorgesetzter) {
        this.vorgesetzter.set(vorgesetzter);
    }

    public String getStrasse() {
        return strasse.get();
    }

    public void setStrasse(String strasse) {
        this.strasse.set(strasse);
    }

    public String getPlzOrt() {
        return plzOrt.get();
    }

    public void setPlzOrt(String plzOrt) {
        this.plzOrt.set(plzOrt);
    }

    public String getNotwendigeArbeitsbereiche() {
        return notwendigeArbeitsbereiche.get();
    }

    public void setNotwendigeArbeitsbereiche(String notwendigeArbeitsbereiche) {
        this.notwendigeArbeitsbereiche.set(notwendigeArbeitsbereiche);
    }

    public String getVonDatum() {
        return vonDatum.get();
    }

    public void setVonDatum(String vonDatum) {
        this.vonDatum.set(vonDatum);
    }

    public String getBisDatum() {
        return bisDatum.get();
    }

    public void setBisDatum(String bisDatum) {
        this.bisDatum.set(bisDatum);
    }

    public String getKreuz0() {
        return kreuz0.get();
    }

    public void setKreuz0(String kreuz0) {
        this.kreuz0.set(kreuz0);
    }

    public String getKreuz1() {
        return kreuz1.get();
    }

    public void setKreuz1(String kreuz1) {
        this.kreuz1.set(kreuz1);
    }

    public String getKreuz2() {
        return kreuz2.get();
    }

    public void setKreuz2(String kreuz2) {
        this.kreuz2.set(kreuz2);
    }

    public String getKreuz3() {
        return kreuz3.get();
    }

    public void setKreuz3(String kreuz3) {
        this.kreuz3.set(kreuz3);
    }

    public String getKreuz00() {
        return kreuz00.get();
    }

    public void setKreuz00(String kreuz00) {
        this.kreuz00.set(kreuz00);
    }

    public String getKreuz01() {
        return kreuz01.get();
    }

    public void setKreuz01(String kreuz01) {
        this.kreuz01.set(kreuz01);
    }

    public String getKreuz02() {
        return kreuz02.get();
    }

    public void setKreuz02(String kreuz02) {
        this.kreuz02.set(kreuz02);
    }

    public String getKreuz10() {
        return kreuz10.get();
    }

    public void setKreuz10(String kreuz10) {
        this.kreuz10.set(kreuz10);
    }

    public String getKreuz11() {
        return kreuz11.get();
    }

    public void setKreuz11(String kreuz11) {
        this.kreuz11.set(kreuz11);
    }

    public String getKreuz12() {
        return kreuz12.get();
    }

    public void setKreuz12(String kreuz12) {
        this.kreuz12.set(kreuz12);
    }

    public String getKreuz20() {
        return kreuz20.get();
    }

    public void setKreuz20(String kreuz20) {
        this.kreuz20.set(kreuz20);
    }

    public String getKreuz21() {
        return kreuz21.get();
    }

    public void setKreuz21(String kreuz21) {
        this.kreuz21.set(kreuz21);
    }

    public String getKreuz22() {
        return kreuz22.get();
    }

    public void setKreuz22(String kreuz22) {
        this.kreuz22.set(kreuz22);
    }


    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getMobil());
        out.writeObject(getEmail());
        out.writeObject(getFirma());
        out.writeObject(getVorgesetzter());
        out.writeObject(getStrasse());
        out.writeObject(getPlzOrt());
        out.writeObject(getNotwendigeArbeitsbereiche());
        out.writeObject(getVonDatum());
        out.writeObject(getKreuz0());
        out.writeObject(getKreuz0());
        out.writeObject(getKreuz1());
        out.writeObject(getKreuz2());
        out.writeObject(getKreuz3());
        out.writeObject(getKreuz00());
        out.writeObject(getKreuz01());
        out.writeObject(getKreuz02());
        out.writeObject(getKreuz10());
        out.writeObject(getKreuz11());
        out.writeObject(getKreuz12());
        out.writeObject(getKreuz20());
        out.writeObject(getKreuz21());
        out.writeObject(getKreuz22());
    }


    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = new SimpleStringProperty((String) in.readObject());
        this.mobil = new SimpleStringProperty((String) in.readObject());
        this.email  = new SimpleStringProperty((String) in.readObject());
        this.firma  = new SimpleStringProperty((String) in.readObject());
        this.vorgesetzter= new SimpleStringProperty((String) in.readObject());
        this.strasse= new SimpleStringProperty((String) in.readObject());
        this.plzOrt = new SimpleStringProperty((String) in.readObject());
        this.notwendigeArbeitsbereiche = new SimpleStringProperty((String) in.readObject());
        this.vonDatum = new SimpleStringProperty((String) in.readObject());
        this.bisDatum = new SimpleStringProperty((String) in.readObject());
        this.kreuz0 = new SimpleStringProperty((String) in.readObject());
        this.kreuz1= new SimpleStringProperty((String) in.readObject());
        this.kreuz2 = new SimpleStringProperty((String) in.readObject());
        this.kreuz3 = new SimpleStringProperty((String) in.readObject());
        this.kreuz00 = new SimpleStringProperty((String) in.readObject());
        this.kreuz01  = new SimpleStringProperty((String) in.readObject());
        this.kreuz02  = new SimpleStringProperty((String) in.readObject());
        this.kreuz10 = new SimpleStringProperty((String) in.readObject());
        this.kreuz11  = new SimpleStringProperty((String) in.readObject());
        this.kreuz12 = new SimpleStringProperty((String) in.readObject());
        this.kreuz20  = new SimpleStringProperty((String) in.readObject());
        this.kreuz21  = new SimpleStringProperty((String) in.readObject());
        this.kreuz22  = new SimpleStringProperty((String) in.readObject());
    }
}
