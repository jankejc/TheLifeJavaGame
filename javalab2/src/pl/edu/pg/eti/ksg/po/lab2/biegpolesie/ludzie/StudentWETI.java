package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class StudentWETI extends StudentPolitechniki{
    
    public StudentWETI(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec, kierunekStudiow);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(DziedzinaZadania.INFORMATYKA.equals(dziedzinaZadania))
        {
            wypowiedzSie("Hmm, podobne zadanie było na zajęciach z Teorii Obliczeniowej. "
                    + "To powinno byc proste.");
            return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.9;
        }
        return super.rozwiazZadanie(dziedzinaZadania);
    }
    
    
    
}
