package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

/**
 *
 * @author TB
 */
public class StudentWETIOrazLesnik extends StudentWETI {
    
    public StudentWETIOrazLesnik(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec, kierunekStudiow);
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        String ukonczyc = "Ukończyłem";
        if(Plec.KOBIETA.equals(getPlec()))
            ukonczyc = "Ukonczyłam";
        
        wypowiedzSie(ukonczyc+" Technikum Leśnictwa w Tucholi.");
    }

    
    
    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if(RodzajTerenu.NISKI_LAS.equals(rodzajTerenu))
        {
            wypowiedzSie("Młodnik! Przypomniały mi się praktyki w technikum.");
            return humorIUwarunkowaniaOsobiste.nextDouble()*0.4 + 0.2; //Od 0.4 do 0.6
        }
        return super.predkoscPoruszaniaSie(rodzajTerenu);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(DziedzinaZadania.NAUKI_LESNE.equals(dziedzinaZadania))
        {
            wypowiedzSie("Chyba coś jeszcze pamiętam ze szkoły.");
            return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.5;
        }
        return super.rozwiazZadanie(dziedzinaZadania);
    }
    
    
    
    
}
