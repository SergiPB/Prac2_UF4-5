package Persones.Plantilla.Tecnics;

import java.time.LocalDate;

import Persones.Plantilla.Plantilla;

abstract public class Tecnics extends Plantilla {

    private int anysExp;

    public Tecnics(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            int numSerguretatSocial, double souBase, int anysExp) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon, numSerguretatSocial, souBase);
        this.anysExp = anysExp;
    }

    public Tecnics() {
    }

    @Override
    protected double calculSou(double souBase) {

        double sou = souBase + (anysExp * 20);

        return sou;
    }

    public int getAnysExp() {
        return anysExp;
    }

    public void setAnysExp(int anysExp) {
        this.anysExp = anysExp;
    }

}
