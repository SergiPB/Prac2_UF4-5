import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Persones.Soci;
import Persones.Plantilla.Plantilla;
import Persones.Plantilla.Jugadors.Jugadors;

public class ClubFutbolApp {

    static File fichero = new File("ClubFutbol.dat");
    static ClubFutbol club = new ClubFutbol();;

    public static void main(String[] args) throws Exception {

        desialitzarClubFutbol();

        club.menuClub();

        serialitzarClubFutbol();
    }

    private static void desialitzarClubFutbol() {
        try (
                FileInputStream iFlujoFitchero = new FileInputStream(fichero)) {
            ObjectInputStream desserialtzador = new ObjectInputStream(iFlujoFitchero);

            club = (ClubFutbol) desserialtzador.readObject();
            Soci.setNumSociFix((Integer) desserialtzador.readObject());
            Soci.setNumLocalitatFix((Integer) desserialtzador.readObject());
            Plantilla.setNumEmpleatFix((Integer) desserialtzador.readObject());
            Jugadors.setDorsalFix((Integer) desserialtzador.readObject());
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void serialitzarClubFutbol() {
        try (
                FileOutputStream oFlujoFitchero = new FileOutputStream(fichero)) {
            ObjectOutputStream serializador = new ObjectOutputStream(oFlujoFitchero);

            serializador.writeObject(club);
            serializador.writeObject(Soci.getNumSociFix());
            serializador.writeObject(Soci.getNumLocalitatFix());
            serializador.writeObject(Plantilla.getNumEmpleatFix());
            serializador.writeObject(Jugadors.getDorsalFix());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
