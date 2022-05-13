package Persones.Plantilla;

import java.time.LocalDate;

import Persones.Persona;

abstract public class Plantilla extends Persona implements Comparable<Plantilla> {

    private static int numEmpleatFix = 1;
    private int numEmpleat;
    private int numSerguretatSocial;
    private double souBase;
    private double sou;

    public Plantilla(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            int numSerguretatSocial, double souBase) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon);
        this.numSerguretatSocial = numSerguretatSocial;
        this.souBase = souBase;

        numEmpleat = numEmpleatFix++;

        this.sou = calculSou(souBase);
    }

    public Plantilla() {
    }

    public static int getNumEmpleatFix() {
        return numEmpleatFix;
    }

    public static void setNumEmpleatFix(int numEmpleatFix) {
        Plantilla.numEmpleatFix = numEmpleatFix;
    }

    abstract protected double calculSou(double souBase);

    public double getSou() {
        return sou;
    }

    abstract public void alta(int tamanyArray);

    public int getNumEmpleat() {
        return numEmpleat;
    }

    public void setNumEmpleat() {

        numEmpleat = numEmpleatFix++;

    }

    public int getNumSerguretatSocial() {
        return numSerguretatSocial;
    }

    public void setNumSerguretatSocial(int numSerguretatSocial) {
        this.numSerguretatSocial = numSerguretatSocial;
    }

    public double getSouBase() {
        return souBase;
    }

    public void setSouBase(double souBase) {
        this.souBase = souBase;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    abstract public void modificar();

    @Override
    public int compareTo(Plantilla plantilla) {

        return this.getClass().getSimpleName().compareToIgnoreCase(plantilla.getClass().getSimpleName());

    }

    @Override
    public String toString() {
        return super.toString() + " numEmpleat=" + numEmpleat + ", numSerguretatSocial=" + numSerguretatSocial
                + ", sou=" + sou
                + ", souBase=" + souBase;
    }

}
