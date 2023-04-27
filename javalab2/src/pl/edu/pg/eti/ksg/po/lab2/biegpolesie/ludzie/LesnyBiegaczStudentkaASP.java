package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

public class LesnyBiegaczStudentkaASP extends StudentkaASP
{
    public LesnyBiegaczStudentkaASP(String imie, String nazwisko) {
        super(imie, nazwisko, Plec.KOBIETA);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Lubie biegi przełajowe ale i malować.");
        wypowiedzSie("Poza tym, nazwyam się "+getImie()+" "+getNazwisko()+".");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {

        switch(rodzajTerenu)
        {
            case DROGA:
                wypowiedzSie("Biegnę sobie drogą, nie lubie jej koloru.");
                return 1;
            case SCIEZKA:
                wypowiedzSie("Biegne po ścieżce w lesie, ciekawe jakie kolory ma grunt.");
                return 1;
            case WYSOKI_LAS:
                wypowiedzSie("Jakbym szla drogą, ale piekne łuki drzew.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.8; //Od 0.8 do 1
            case NISKI_LAS:
                wypowiedzSie("Jakbym szła ścieżką, ale nieco łądniejszą.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.6; //Od 0.6 do 0.8
            default:
                return super.predkoscPoruszaniaSie(rodzajTerenu);
        }
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case SZTUKA:
                wypowiedzSie("Na szczęście sztuka połączona z naturą jest lepsza niż bez niej.");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.5;
            case SZYDEŁKOWANIE:
                wypowiedzSie("Ciężko się szydełkuje w trasie");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.6;
            default:
                return super.rozwiazZadanie(dziedzinaZadania);
        }
    }
}
