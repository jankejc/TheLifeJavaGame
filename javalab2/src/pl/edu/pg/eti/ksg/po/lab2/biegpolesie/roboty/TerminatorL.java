package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

/**
 *
 * @author TB
 */
public class TerminatorL extends Terminator {

    public TerminatorL(int numerSeryjny) {
        super("T-101L", numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if(RodzajTerenu.NISKI_LAS.equals(rodzajTerenu))
        {
            komunikuj("Wykryto teren: "+rodzajTerenu+". Aktywacja algorytmu poruszania się w młodniku.");
            return czynnikiLosowe.nextDouble()*0.2 + 0.4; //Od 0.4 do 0.6
        }
        else
            return super.predkoscPoruszaniaSie(rodzajTerenu);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(DziedzinaZadania.NAUKI_LESNE.equals(dziedzinaZadania))
        {
            komunikuj("Zadanie z dziedziny "+dziedzinaZadania+". Uruchamianie koprocesora leśnego.");
            return czynnikiLosowe.nextDouble() <= 0.6;
        }
        return super.rozwiazZadanie(dziedzinaZadania);
    }
    
}
