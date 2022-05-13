package Persones.Plantilla.Jugadors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Porters extends Jugadors {

    private int golsAturars;
    private int golsRebuts;

    public Porters(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            int numSerguretatSocial, double souBase, boolean titular, int golsAturars,
            int golsRebuts) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon, numSerguretatSocial, souBase, titular);
        this.golsAturars = golsAturars;
        this.golsRebuts = golsRebuts;
    }

    public Porters() {
    }

    public int getGolsAturars() {
        return golsAturars;
    }

    public void setGolsAturars(int golsAturars) {
        this.golsAturars = golsAturars;
    }

    public int getGolsRebuts() {
        return golsRebuts;
    }

    public void setGolsRebuts(int golsRebuts) {
        this.golsRebuts = golsRebuts;
    }

    @Override
    protected double calculSou(double souBase) {

        double sou = souBase + (golsAturars * 150);

        return sou;
    }

    @Override
    public void alta(int tamanyArray) {
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
            System.out.print("\n Introdueix Data Neixement(DD.MM.AAAA):");
            try {

                this.setDataNaixament((LocalDate.parse(teclat.next(), formatter)));
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

        System.out.print("\n Num Seguretat Social: ");
        int numSerguretatSocial = teclat.nextInt();
        this.setNumSerguretatSocial(numSerguretatSocial);

        System.out.print("\n Sou Base: ");
        double souBase = teclat.nextDouble();
        this.setSouBase(souBase);

        System.out.print("\n Titular: ");
        boolean titular = teclat.nextBoolean();
        this.setTitular(titular);

        System.out.print("\n Atacs Aturats: ");
        int golsAturars = teclat.nextInt();
        this.setGolsAturars(golsAturars);

        System.out.print("\n Balons Recuperats: ");
        int golsRebuts = teclat.nextInt();
        this.setGolsRebuts(golsRebuts);

        this.setNumEmpleat();
        this.setSou(calculSou(this.getSouBase()));
    }

    @Override
    public void modificar() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Inserta el seguents elements");

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

        System.out.println("Vols modificar el data naixement?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            // Data de Naixement
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            boolean dataCorrecta;

            do {
                dataCorrecta = true;
                System.out.print("\n Introdueix Data Neixement(DD.MM.AAAA):");
                try {

                    this.setDataNaixament((LocalDate.parse(teclat.next(), formatter)));
                } catch (Exception ex) {
                    dataCorrecta = false;
                }

            } while (!dataCorrecta);
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

        System.out.println("Vols modificar el num seguretat social?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Num Seguretat Social: ");
            int numSerguretatSocial = teclat.nextInt();
            this.setNumSerguretatSocial(numSerguretatSocial);
        }

        System.out.println("Vols modificar el sou base?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Sou Base: ");
            double souBase = teclat.nextDouble();
            this.setSouBase(souBase);
        }

        System.out.println("Vols modificar els gols rebuts?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Gols Rebuts: ");
            int golsRebuts = teclat.nextInt();
            this.setGolsRebuts(golsRebuts);
        }

        System.out.println("Vols modificar els gols aturats?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Gols Aturatsa: ");
            int golsAturars = teclat.nextInt();
            this.setGolsAturars(golsAturars);
        }

        this.setSou(calculSou(this.getSouBase()));

    }

}
