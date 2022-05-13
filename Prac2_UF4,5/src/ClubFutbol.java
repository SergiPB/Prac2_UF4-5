import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

import Persones.Soci;
import Persones.Plantilla.Plantilla;
import Persones.Plantilla.Jugadors.Davanters;
import Persones.Plantilla.Jugadors.Defenses;
import Persones.Plantilla.Jugadors.Migcampistes;
import Persones.Plantilla.Jugadors.Porters;
import Persones.Plantilla.Tecnics.Entrenadors;
import Persones.Plantilla.Tecnics.PreparadorFisic;

public class ClubFutbol implements Serializable {

    private String nom;
    private String CIF;
    private String adreça;
    private String telefon;
    private String email;
    private String www;
    private double balanç;

    ArrayList<Plantilla> plantillas;
    ArrayList<Soci> socis;

    public ClubFutbol() {
        nom = "FC Barcelona";
        CIF = "G-08266298";
        adreça = "Arístides Maillol s/n, 08028 Barcelona";
        telefon = "902189900";
        email = "oab@fcbarcelona.cat";
        www = "https://www.fcbarcelona.es/es/";

        plantillas = new ArrayList<>();
        socis = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CIF=" + CIF + ", nom=" + nom + ", adreça=" + adreça + ", email=" + email + ", telefon=" + telefon
                + ", www=" + www;
    }

    public void menuClub() throws IOException {

        // insertaDadesClub();

        Scanner teclat = new Scanner(System.in);
        boolean sortirmenu = false;

        do {

            System.out.println("");
            System.out.println("********Menu Club Futbol********");
            System.out.println("");
            System.out.println("1.- Consulta Dades Club");
            System.out.println("2.- Gestio dels Socis");
            System.out.println("3.- Gestio de la Plantilla");
            System.out.println("4.- Dades Econòmiques");
            System.out.println("5.- Sortir");
            System.out.println("\nIntrodueix el numero de l'opció");

            int opcio = teclat.nextInt();

            switch (opcio) {

                case 1:
                    consultaDadesClub();
                    break;

                case 2:
                    menuSocis();
                    break;

                case 3:
                    menuPlantilla();
                    break;

                case 4:
                    dadesEconòmiques();
                    break;

                case 5:
                    sortirmenu = true;
                    break;

                default:
                    System.out.println("Opció no valida");

            }

        } while (!sortirmenu);

    }

    private void insertaDadesClub() {

        // Socis
        socis.add(new Soci("01878506G", "Paco", "Perez", "2001-06-27", "pacopm@gamil.com", 654926745, 1600.30));
        socis.add(new Soci("90610988G", "Marta", "Florensa", "2001-06-27", "marflo@gamil.com", 698745123, 1510.15));
        socis.add(new Soci("59497218J", "Marc", "Martin", "2001-06-27", "marcmg@gamil.com", 693582471, 1499.99));
        socis.add(new Soci("74621681K", "Paula", "Rubio", "2001-06-27", "paurub@gamil.com", 639528417, 1523.60));

        // Entrenador
        plantillas.add(new Entrenadors("78103615P", "Sergi", "Pont", "2003-08-25", "sergipontbala@gmail.com", 600382677,
                263721, 1300, 2, 1));

        // Preparado Fisic
        plantillas.add(new PreparadorFisic("15979230A", "Rogue", "Marin", "2000-04-26", "rogue@gmail.com",
                600355649, 263721, 1050, 3));

        // Porter
        plantillas.add(new Porters("80005968P", "Manolo", "Guimenez", "1982-04-10", "manolog@gmail.com", 654987321,
                2648931, 1300, true, 5, 4));

        // Defenses
        plantillas.add(new Defenses("47102760W", "Daniel", "Utrera", "2000-01-20", "dutre@gmail.com", 671493582,
                2648951, 1220, true, 3, 3));
        plantillas.add(new Defenses("38767663J", "Marc", "Puig", "2000-12-20", "puigm@gmail.com", 671415756, 2618631,
                1220, true, 5, 2));
        plantillas.add(new Defenses("76209021Q", "Sergio", "Rojo", "2000-01-20", "sergior@gmail.com", 671184322,
                2644511, 1220, false, 2, 1));

        // Mitjcampista
        plantillas.add(new Migcampistes("97777108Z", "Joel", "Guardiola", "1999-06-03", "joguar@gmail.com", 648461316,
                6914654, 1200, false, 4, 2));
        plantillas.add(new Migcampistes("16753239Q", "Gustabo", "Masana", "1999-06-03", "gusta@gmail.com", 641633411,
                6915254, 1200, true, 6, 2));
        plantillas.add(new Migcampistes("46978543P", "Miquel", "Canal", "1999-06-03", "mique@gmail.com", 648461316,
                6936754, 1200, true, 3, 2));

        // Davanters
        plantillas.add(new Davanters("46883547W", "Eric", "Orit", "2002-04-28", "erori@gmail.com", 615843534, 1656422,
                1250, true, 5, 2));
        plantillas.add(new Davanters("85263700D", "Eloi", "Farres", "2002-04-28", "fareti@gmail.com", 611564334, 165615,
                1250, true, 5, 2));
        plantillas.add(
                new Davanters("67382986R", "Eustaquio", "Martinez", "2002-04-28", "eumar@gmail.com", 615152534, 1564822,
                        1250, false, 3, 0));

    }

    private void consultaDadesClub() {
        System.out.println(this);
    }

    private void menuSocis() {
        Scanner teclat = new Scanner(System.in);
        boolean sortirmenu = false;

        do {

            System.out.println("");
            System.out.println("******** Menu Socis Club Futbol ********");
            System.out.println("");
            System.out.println("1.- Alta");
            System.out.println("2.- Modificació");
            System.out.println("3.- Baixa");
            System.out.println("4.- Visualitzacio");
            System.out.println("5.- Sortir");
            System.out.println("\nIntrodueix el numero de l'opció");

            int opcio = teclat.nextInt();

            switch (opcio) {

                case 1:
                    altaSocis();
                    break;

                case 2:
                    modificacioSocis();
                    break;

                case 3:
                    baixaSocis();
                    break;

                case 4:
                    visualitzacioSocis();
                    break;

                case 5:
                    sortirmenu = true;
                    break;

                default:
                    System.out.println("Opció no valida");

            }

        } while (!sortirmenu);

    }

    private void altaSocis() {

        Soci s1 = new Soci();

        s1.altaSocis(socis.size());

        socis.add(s1);

    }

    private void modificacioSocis() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Posa el DNI del Soci que vols modificar");
        String DNI = teclat.next();

        for (Soci soci : socis) {

            if (DNI.equals(soci.getDNI())) {
                soci.modificacioSocis();
            }

        }

    }

    private void baixaSocis() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Posa el DNI del Soci que vols donar de baixa");
        String DNI = teclat.next();

        for (Soci soci : socis) {

            if (DNI.equals(soci.getDNI())) {
                socis.remove(soci);
            }

        }

    }

    private void visualitzacioSocis() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("");
        System.out.println("******** Ordenados Por ********");
        System.out.println("");
        System.out.println("1.- Cognom i Nom");
        System.out.println("2.- Localitat");
        System.out.println("2.- Quota");

        System.out.println("\nIndica quina ordenacio vols");

        int opcio = teclat.nextInt();

        switch (opcio) {

            case 1:
                visualitzaCognom();
                break;

            case 2:
                visualitzaLocalitat();
                break;

            case 3:
                visualitzaQuota();
                break;

            default:
                System.out.println("Opció no valida");
        }

    }

    private void visualitzaLocalitat() {

        Collections.sort(socis, new Comparator<Soci>() {

            @Override
            public int compare(Soci s1, Soci s2) {
                return (s1.getNumLocalitat() - s2.getNumLocalitat());
            }

        });

        for (Soci soci : socis) {
            System.out.println(soci);
        }

    }

    private void visualitzaQuota() {

        Collections.sort(socis, new Comparator<Soci>() {

            @Override
            public int compare(Soci s1, Soci s2) {
                return (int) (s1.getQuotaAnual() - s2.getQuotaAnual());
            }

        });

        for (Soci soci : socis) {
            System.out.println(soci);
        }

    }

    private void visualitzaCognom() {

        Collections.sort(socis);

        for (Soci soci : socis) {
            System.out.println(soci);
        }

    }

    private void menuPlantilla() {
        Scanner teclat = new Scanner(System.in);
        boolean sortirmenu = false;

        do {

            System.out.println("");
            System.out.println("******** Menu Plantilla Club Futbol ********");
            System.out.println("");
            System.out.println("1.- Alta");
            System.out.println("2.- Modificació");
            System.out.println("3.- Baixa");
            System.out.println("4.- Visualitzacio");
            System.out.println("5.- Sortir");
            System.out.println("\nIntrodueix el numero de l'opció");

            int opcio = teclat.nextInt();

            switch (opcio) {

                case 1:
                    altaPlantilla();
                    break;

                case 2:
                    modificacioPlantilla();
                    break;

                case 3:
                    baixaPlantilla();
                    break;

                case 4:
                    visualitzacioPlantilla();
                    break;

                case 5:
                    sortirmenu = true;
                    break;

                default:
                    System.out.println("Opció no valida");

            }

        } while (!sortirmenu);

    }

    private void altaPlantilla() {
        Scanner teclat = new Scanner(System.in);
        boolean sortirmenu = false;

        System.out.println("");
        System.out.println("******** Alta Plantilla ********");
        System.out.println("");
        System.out.println("1.- Entrenador");
        System.out.println("2.- Prep Fisic");
        System.out.println("3.- Porter");
        System.out.println("4.- Defensa");
        System.out.println("5.- Mitgcampista");
        System.out.println("6.- Davanter");
        System.out.println("\nIndica que vols donar d'alta");

        int opcio = teclat.nextInt();

        switch (opcio) {

            case 1:
                Plantilla p1 = new Entrenadors();
                p1.alta(plantillas.size());
                plantillas.add(p1);
                break;

            case 2:
                p1 = new PreparadorFisic();
                p1.alta(plantillas.size());
                plantillas.add(p1);
                break;

            case 3:
                p1 = new Porters();
                p1.alta(plantillas.size());
                break;

            case 4:
                p1 = new Defenses();
                p1.alta(plantillas.size());
                plantillas.add(p1);
                break;

            case 5:
                p1 = new Migcampistes();
                p1.alta(plantillas.size());
                plantillas.add(p1);
                break;

            case 6:
                p1 = new Davanters();
                p1.alta(plantillas.size());
                plantillas.add(p1);
                break;

            default:
                System.out.println("Opció no valida");

        }

    }

    private void modificacioPlantilla() {

        Scanner teclat = new Scanner(System.in);
        System.out.println("Posa el DNI del Soci que vols donar de baixa");
        String DNI = teclat.next();

        for (Plantilla p1 : plantillas) {

            if (DNI.equals(p1.getDNI())) {
                p1.modificar();
            }

        }

    }

    private void baixaPlantilla() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Posa el DNI del Soci que vols donar de baixa");
        String DNI = teclat.next();

        for (Plantilla p1 : plantillas) {

            if (DNI.equals(p1.getDNI())) {
                plantillas.remove(p1);
            }

        }
    }

    private void visualitzacioPlantilla() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("");
        System.out.println("******** Ordenados Por ********");
        System.out.println("");
        System.out.println("1.- Rol");
        System.out.println("2.- Sou Incentivat");
        System.out.println("\nIndica quina ordenacio vols");

        int opcio = teclat.nextInt();

        switch (opcio) {

            case 1:
                visualitzaRol();
                break;

            case 2:
                visualitzaSou();
                break;

            default:
                System.out.println("Opció no valida");
        }

    }

    private void visualitzaRol() {

        Collections.sort(plantillas);

        for (Plantilla plantilla : plantillas) {
            System.out.println(plantilla);
        }

    }

    private void visualitzaSou() {

        Collections.sort(plantillas, new Comparator<Plantilla>() {

            @Override
            public int compare(Plantilla p1, Plantilla p2) {

                return (int) (p1.getSou() - p2.getSou());

            }

        });

        for (Plantilla p1 : plantillas) {
            System.out.println(p1);
        }
    }

    private void dadesEconòmiques() {

        double ingressos = 0;
        double despeses = 0;

        for (Soci x : socis) {
            ingressos += x.getQuotaAnual();
        }

        for (Plantilla x : plantillas) {
            despeses += x.getSou();
        }

        this.balanç = ingressos - despeses;

        System.out.println("Balanç: " + this.balanç);

    }

}