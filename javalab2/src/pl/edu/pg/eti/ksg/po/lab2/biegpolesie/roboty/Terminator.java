package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Robot;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

/**
 *
 * @author TB
 */
public class Terminator extends Robot
{

    protected Terminator(String model, int numerSeryjny) {
        super(model, numerSeryjny);
    }
    
    public Terminator(int numerSeryjny) {
        super("T-101", numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        switch(rodzajTerenu)
        {
            case DROGA:
                komunikuj("Wykryto teren: "+rodzajTerenu);
                return czynnikiLosowe.nextDouble()*0.2 + 0.8; //Od 0.8 do 1.0
            case SCIEZKA:
                komunikuj("Wykryto teren: "+rodzajTerenu);
                return czynnikiLosowe.nextDouble()*0.2 + 0.6; //Od 0.6 do 0.8
            case WYSOKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu);
                return czynnikiLosowe.nextDouble()*0.2 + 0.4; //Od 0.4 do 0.6
            case NISKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu);
                return czynnikiLosowe.nextDouble()*0.2 + 0.2; //Od 0.2 do 0.4
            case BAGNO:
            default:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Uwaga! Trudny teren.");
                return czynnikiLosowe.nextDouble()*0.2; //Od 0 do 0.2
        }
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case FIZYKA:
            case INFORMATYKA:
            case MATEMATYKA:
                komunikuj("Zadanie z dziedziny "+dziedzinaZadania+". Obliczanie odpowiedzi...");
                return true;
            case NAUKI_LESNE:
            case SZTUKA:
            default:
                komunikuj("Nie zrozumiano zadania. Losowanie odpowiedzi.");
                return czynnikiLosowe.nextDouble() <= 0.05;
        }
    }
    
}
