package pl.edu.pg.eti.ksg.po.lab2;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.BiegPoLesie;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.FabrykaElementowTrasy;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.NieMoznaUtworzycElementuTrasyException;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Uczestnik;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.BagiennyBiegacz;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.BiegajacaFarmaceutka;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.LesnyBiegacz;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.LesnyBiegaczAbsolwentWETI;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.SpiewajacaFarmaceutka;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.Student;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.StudentPolitechniki;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.StudentWArch;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.StudentWETI;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.StudentWETIOrazLesnik;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.RobotMobilny;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.Terminator;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.TerminatorL;

/**
 *
 * @author TB
 */
public class Javalab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new BagiennyBiegacz("Krzysztof", "Kowalski", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new RobotMobilny(1));
        uczestnicy.add(new Terminator(3912));
        uczestnicy.add(new TerminatorL(15));
        uczestnicy.add(new Student("Alfred", "Archiwista", Czlowiek.Plec.MEZCZYZNA, "Historia"));
        uczestnicy.add(new StudentPolitechniki("Stefan", "Belka", Czlowiek.Plec.MEZCZYZNA, "Budownictwo"));
        uczestnicy.add(new StudentWETI("Pelagia", "Tranzystor", Czlowiek.Plec.KOBIETA, "Elektronika"));
        uczestnicy.add(new StudentWArch("Anna", "Naczasie", Czlowiek.Plec.KOBIETA, "Architektura"));
        uczestnicy.add(new StudentWETIOrazLesnik("Apoloniusz", "Gałązka", Czlowiek.Plec.MEZCZYZNA, "Informatyka"));
        uczestnicy.add(new LesnyBiegacz("Dominik", "Funt", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new LesnyBiegaczAbsolwentWETI("Paweł", "Leśny", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new BiegajacaFarmaceutka("Ewelina", "Górska"));
        uczestnicy.add(new SpiewajacaFarmaceutka("Florencja", "Jeziorna"));
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji Bieg po Lesie. Wybierz bieg: ");
        System.out.println("1. Górki");
        System.out.println("2. Na przełaj z Matematyką");
        System.out.println("3. Bagienny miks naukowy");
        System.out.println("4. Własna trasa");
        int wybor = scanner.nextInt();
        
        BiegPoLesie bieg;
        
        switch(wybor)
        {
            case 1:
                bieg = gorki(System.out, System.out);
                break;
            case 2:
                bieg = naPrzelajZMatematyka(System.out, System.out);
                break;
            case 3:
                bieg = bagiennyMiks(System.out, System.out);
                break;
            default:
            case 4:
                bieg = wlasnyBieg(System.out, System.out);
               break;
        }
        
        for(Uczestnik u : uczestnicy)
        {
            bieg.dodajUczestnika(u);
        }
        
        LinkedList<Uczestnik> stanMety = new LinkedList<>();
        
        bieg.dodajObserwatoraMety((Uczestnik u, int miejsce)->{
            stanMety.add(u);
        });
        bieg.przeprowadzImpreze();
        
        System.out.println();
        System.out.println("Meta: ");
        
        for(int i = 0; i < stanMety.size(); i++)
        {
            System.out.println(i+1+". "+stanMety.get(i));
        }
    }
    
    private static BiegPoLesie gorki(PrintStream mikrofon, PrintStream przestrzenWLesie)
    {
        BiegPoLesie gorki_ = new BiegPoLesie("Górki",mikrofon,przestrzenWLesie);
        
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.FIZYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return gorki_;
    }

    private static BiegPoLesie naPrzelajZMatematyka(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie naPrzelaj = new BiegPoLesie("Na przełaj z matematyką",mikrofon,przestrzenWLesie);
        
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return naPrzelaj;
    }

    private static BiegPoLesie bagiennyMiks(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie miks = new BiegPoLesie("Bagienny miks naukowy",mikrofon,przestrzenWLesie);
        
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.FIZYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.INFORMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.SZTUKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MEDYCYNA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return miks;
    }

    private static BiegPoLesie wlasnyBieg(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwe biegu: ");
        String nazwa = scanner.nextLine();
        BiegPoLesie wlasnyBieg = new BiegPoLesie(nazwa,mikrofon,przestrzenWLesie);
        String buf = "";
        do
        {
            try
            {
                System.out.print("Podaj element trasy (Enter - koniec): ");
                buf = scanner.nextLine();
                if(!"".equals(buf))
                    wlasnyBieg.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(buf));
            }
            catch(NieMoznaUtworzycElementuTrasyException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        while(!"".equals(buf));
        
        return wlasnyBieg;
    }
    
}
