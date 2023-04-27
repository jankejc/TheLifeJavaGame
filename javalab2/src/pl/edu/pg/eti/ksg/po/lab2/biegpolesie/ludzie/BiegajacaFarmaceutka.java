package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

public class BiegajacaFarmaceutka extends LesnyBiegacz
{

    public BiegajacaFarmaceutka(String imie, String nazwisko) {
        super(imie, nazwisko, Plec.KOBIETA);
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        wypowiedzSie("Chciałabym pozdrowić moich rodziców!");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if(RodzajTerenu.BAGNO.equals(rodzajTerenu))
        {
            wypowiedzSie("Niby bagno, ale znalazł się kawałek czystej wody. "
                    + "Wystarczy przełynąc wpław");
            return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.2; //0.2 do 0.4
        }
        return super.predkoscPoruszaniaSie(rodzajTerenu);
    }

    
    
    
    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(DziedzinaZadania.MEDYCYNA.equals(dziedzinaZadania))
        {
            wypowiedzSie("Do tego trzeba będzie wykorzystać korę brzozową.");
            return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
        }
        return super.rozwiazZadanie(dziedzinaZadania);
    }
    
    
    
}
