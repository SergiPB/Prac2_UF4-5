package Persones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Soci extends Persona implements Comparable<Soci> {

    private static int numSociFix = 1;
    private static int numLocalitatFix = 500;
    private int numSoci;
    private int numLocalitat;
    private double quotaAnual;

    public Soci(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            double quotaAnual) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon);
        this.quotaAnual = quotaAnual;

        numSoci = numSociFix++;
        numLocalitat = numLocalitatFix++;
    }

    public Soci() {

    }

    public static int getNumLocalitatFix() {
        return numLocalitatFix;
    }

    public static void setNumLocalitatFix(int numLocalitatFix) {
        Soci.numLocalitatFix = numLocalitatFix;
    }

    public static int getNumSociFix() {
        return numSociFix;
    }

    public static void setNumSociFix(int numSociFix) {
        Soci.numSociFix = numSociFix;
    }

    public int getNumLocalitat() {
        return numLocalitat;
    }

    public double getQuotaAnual() {
        return quotaAnual;
    }

    public void altaSocis(int tamanyArray) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Inserta el seguents elements");

        System.out.print(" DNI: ");
        String DNI = teclat.next();
        this.setDNI(DNI);

        System.out.print("\n Nom: ");
        String nom = teclat.next();
        this.setNom(nom);

        System.out.print("\n Cognom: ");
        String cognom = teclat.next();
        this.setCognom(cognom);

        // Data de Naixement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        boolean dataCorrecta;

        do {
            dataCorrecta = true;
            System.out.print(" Introdueix Data Neixement(DD.MM.AAAA):");
            try {
                this.setDataNaixament(LocalDate.parse(teclat.next(), formatter));
            } catch (Exception ex) {
                dataCorrecta = false;
            }

        } while (!dataCorrecta);

        System.out.print("\n Correu: ");
        String correu = teclat.next();
        this.setCorreu(correu);

        System.out.print("\n Telefon: ");
        int telefon = teclat.nextInt();
        this.setTelefon(telefon);

        System.out.print("\n Quota Anual: ");
        this.quotaAnual = teclat.nextInt();

        numSoci = numSociFix++;
        numLocalitat = numLocalitatFix++;

    }

    public void modificacioSocis() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Vols modificar el nom?(s/n)");
        String opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Nom: ");
            String nom = teclat.next();
            this.setNom(nom);
        }

        System.out.println("Vols modificar el cognom?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Cognom: ");
            String cognom = teclat.next();
            this.setCognom(cognom);
        }

        System.out.println("Vols modificar el correu?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Correu: ");
            String correu = teclat.next();
            this.setCorreu(correu);
        }

        System.out.println("Vols modificar el telefon?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Telefon: ");
            int telefon = teclat.nextInt();
            this.setTelefon(telefon);
        }

        System.out.println("Vols modificar el quotaAnual?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Quota Anual: ");
            int quotaAnual = teclat.nextInt();
            this.quotaAnual = quotaAnual;
        }

    }

    @Override
    public int compareTo(Soci soci) {

        return this.getCognom().compareToIgnoreCase(soci.getCognom());

    }

    @Override
    public String toString() {
        return super.toString() + " numLocalitat=" + numLocalitat + ", numLocalitatFix=" + numLocalitatFix
                + ", numSoci=" + numSoci
                + ", numSociFix=" + numSociFix + ", quotaAnual=" + quotaAnual;
    }

}
