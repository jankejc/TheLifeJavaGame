package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

public class AmadeuszBach extends Czlowiek
{
    public AmadeuszBach(String imie, String nazwisko) {
        super(imie, nazwisko, Plec.MEZCZYZNA);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Jestem "+getImie()+" "+getNazwisko()+". Może coś skomponuję?");
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
            case SZTUKA:
                wypowiedzSie("Ooo taak... Sztukę to ja lubię!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            case MUZYKA:
                wypowiedzSie("Czuje się jak borsuk na fermie chmielu!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            default:
                return super.rozwiazZadanie(dziedzinaZadania);
        }
    }
}
