package Persones.Plantilla.Tecnics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PreparadorFisic extends Tecnics {

    public PreparadorFisic(String dNI, String nom, String cognom, String dataNaixament, String correu, int telefon,
            int numSerguretatSocial, double souBase, int anysExp) {
        super(dNI, nom, cognom, dataNaixament, correu, telefon, numSerguretatSocial, souBase, anysExp);
    }

    public PreparadorFisic() {
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

        System.out.print("\n Anys Experiencia: ");
        int anysExp = teclat.nextInt();
        this.setAnysExp(anysExp);

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
            calculSou(souBase);
        }

        System.out.println("Vols modificar el anys experiencia?(s/n)");
        opcio = teclat.next();

        if (opcio.equals("s")) {
            System.out.print("\n Anys Experiencia: ");
            int anysExp = teclat.nextInt();
            this.setAnysExp(anysExp);
        }

        this.setSou(calculSou(this.getSouBase()));
    }

}
