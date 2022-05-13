package Persones;

import java.io.Serializable;
import java.time.LocalDate;

abstract public class Persona implements Serializable {

    private String DNI;
    private String nom;
    private String cognom;
    private LocalDate dataNaixament;
    private String correu;
    private int telefon;

    public Persona(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon) {
        DNI = dNI;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaixament = LocalDate.parse(dataNaixament);
        this.correu = correu;
        this.telefon = telefon;
    }

    public Persona() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public LocalDate getDataNaixament() {
        return dataNaixament;
    }

    public void setDataNaixament(LocalDate dataNaixament) {
        this.dataNaixament = dataNaixament;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "DNI=" + DNI + ", cognom=" + cognom + ", correu=" + correu + ", dataNaixament=" + dataNaixament
                + ", nom=" + nom + ", telefon=" + telefon;
    }

}
