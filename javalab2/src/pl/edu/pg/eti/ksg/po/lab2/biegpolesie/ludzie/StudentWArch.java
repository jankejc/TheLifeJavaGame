package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class StudentWArch extends StudentPolitechniki{
    
    public StudentWArch(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec, kierunekStudiow);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(DziedzinaZadania.SZTUKA.equals(dziedzinaZadania))
        {
            String miec = "miałem";
            
            if(Plec.KOBIETA.equals(getPlec()))
                miec = "miałam";
            
            wypowiedzSie("Zadanie z Sztuki. Dobrze, że "+miec+" coś podobnego "
                    + "na zajęciach z rysunku.");
            return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.5; 
        }
        return super.rozwiazZadanie(dziedzinaZadania);
    }
    
    
}
