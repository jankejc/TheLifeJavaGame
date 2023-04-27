package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class LesnyBiegaczAbsolwentWETI extends LesnyBiegacz{
    
    public LesnyBiegaczAbsolwentWETI(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec);
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        wypowiedzSie("Nie używam kompasu. Dla mnie to strata czasu.");
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case FIZYKA:
            case MATEMATYKA:
            case INFORMATYKA:
                wypowiedzSie("Zadanie z dziedziny: "+dziedzinaZadania+". Coś jeszcze pamiętam ze studiów.");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.9;
            default:
            return super.rozwiazZadanie(dziedzinaZadania);
        }
    }
    
    
}
