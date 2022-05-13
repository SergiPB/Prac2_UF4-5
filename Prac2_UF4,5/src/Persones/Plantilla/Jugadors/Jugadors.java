package Persones.Plantilla.Jugadors;

import java.time.LocalDate;

import Persones.Plantilla.Plantilla;

abstract public class Jugadors extends Plantilla {

    private static int dorsalFix = 1;
    private int dorsal;
    private boolean titular;

    public Jugadors(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            int numSerguretatSocial, double souBase, boolean titular) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon, numSerguretatSocial, souBase);
        this.titular = titular;

        dorsal = dorsalFix++;

    }

    public Jugadors() {
    }

    public static int getDorsalFix() {
        return dorsalFix;
    }

    public static void setDorsalFix(int dorsalFix) {
        Jugadors.dorsalFix = dorsalFix;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

}
