package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class StudentPolitechniki extends Student {

    public StudentPolitechniki(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec, kierunekStudiow);
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        wypowiedzSie("Interesuję się technologią. Lubie chodzić na imprezy.");
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case FIZYKA:
                wypowiedzSie("Zadanie z Fizyki. Wygląda znajomo. "
                        + "Na coś przydały się te wszyskie egzaminy poprawkowe.");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.5;
            case MATEMATYKA:
            case INFORMATYKA:
                wypowiedzSie("Zadanie z dziedziny: "+dziedzinaZadania+". Pamiętam to chyba z wykładu.");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            default:
            return super.rozwiazZadanie(dziedzinaZadania);
        }
    }
    
    
}
