package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

public class StudentkaASP extends Czlowiek
{
    public StudentkaASP(String imie, String nazwisko) {
        super(imie, nazwisko, Czlowiek.Plec.KOBIETA);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Jestem "+getImie()+" "+getNazwisko()+". Tylko pędzle się liczą!");
    }

    @Override
    protected void wypowiedzSie(String tresc) {
        getOsrodekKomunikacji().print(getImie() +" "+getNazwisko()+" maluje: ");
        getOsrodekKomunikacji().println(tresc);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case SZTUKA:
                wypowiedzSie("Eee... Nie o taką sztukę nic nie robię na ASP...");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.3;
            case SZYDEŁKOWANIE:
                wypowiedzSie("To dopiero zabawa!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            default:
                return super.rozwiazZadanie(dziedzinaZadania);
        }
    }


}

