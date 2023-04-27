package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

public class BagiennyBiegaczStudentPolitechniki extends BagiennyBiegacz {
    public BagiennyBiegaczStudentPolitechniki(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć! Jestem "+getImie()+" "+getNazwisko()+". Moją ulubioną rośliną jest mech bagienny.");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if (RodzajTerenu.BAGNO.equals(rodzajTerenu)) {
            wypowiedzSie("Dobrze, że mam doświadczenie w chodzeniu w bagnie moich ocen...");
            return humorIUwarunkowaniaOsobiste.nextDouble() * 0.3 + 0.2; //Od 0.3 do 0.5
        } else
            return Math.min(1.0, super.predkoscPoruszaniaSie(rodzajTerenu) * 1.1);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case MATEMATYKA:
                wypowiedzSie("Ja chleb smaruje matematyką.");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.75;
            case INFORMATYKA:
                wypowiedzSie("Infromatykę wciągam lewym kciukiem prawego buta, a co!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.95;
            default:
                return super.rozwiazZadanie(dziedzinaZadania);
        }
    }
}
