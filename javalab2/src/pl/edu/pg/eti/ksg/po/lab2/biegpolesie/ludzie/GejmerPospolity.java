package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

public class GejmerPospolity extends Czlowiek
{
    public GejmerPospolity(String imie, String nazwisko) {
        super(imie, nazwisko, Plec.MEZCZYZNA);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Jestem "+getImie()+" "+getNazwisko()+". Dwór? To jakaś nowa gierka?");
    }

    @Override
    protected void wypowiedzSie(String tresc) {
        getOsrodekKomunikacji().print(getImie() +" "+getNazwisko()+" gram: ");
        getOsrodekKomunikacji().println(tresc);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case INFORMATYKA:
                wypowiedzSie("KLIKAM W KOMPUTER");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            case GRY_KOMPUTEROWE:
                wypowiedzSie("Paanie... Takie pytania to ja obiad o 3:00 zjadam...");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            default:
                return super.rozwiazZadanie(dziedzinaZadania);
        }
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        String isc = "szedł";
        if(Plec.KOBIETA.equals(getPlec()))
            isc = "szła";

        switch(rodzajTerenu)
        {
            case DROGA:
                wypowiedzSie("Nie wyrabiam już z tą drogą.");
                return 0.8;
            case BAGNO:
                wypowiedzSie("DAJCIE MI TLENU!");
                return 0.3;
            case WYSOKI_LAS:
                wypowiedzSie("Jakbym "+isc+" w GTA.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.6;
            case NISKI_LAS:
                wypowiedzSie("Jakbym "+isc+" w Wiedźminie... WOW.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.4;
            default:
                return super.predkoscPoruszaniaSie(rodzajTerenu);
        }
    }
}
