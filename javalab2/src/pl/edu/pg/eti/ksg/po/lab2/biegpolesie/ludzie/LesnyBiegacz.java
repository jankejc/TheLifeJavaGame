package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

/**
 *
 * @author TB
 */
public class LesnyBiegacz extends Czlowiek{

    public LesnyBiegacz(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Lubie biegi przełajowe.");
        wypowiedzSie("Poza tym, nazwyam się "+getImie()+" "+getNazwisko()+".");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        String isc = "szedł";
        if(Plec.KOBIETA.equals(getPlec()))
            isc = "szła";
        
        switch(rodzajTerenu)
        {
            case DROGA:
                wypowiedzSie("Biegnę sobie drogą.");
                return 1;
            case SCIEZKA:
                wypowiedzSie("Biegne po ścieżce w lesie.");
                return 1;
            case WYSOKI_LAS:
                wypowiedzSie("Jakbym "+isc+" drogą.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.8; //Od 0.8 do 1
            case NISKI_LAS:
                wypowiedzSie("Jakbym "+isc+" ścieżką.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.6; //Od 0.6 do 0.8
            default:
                return super.predkoscPoruszaniaSie(rodzajTerenu);
        }
    }
    
    
    
}
