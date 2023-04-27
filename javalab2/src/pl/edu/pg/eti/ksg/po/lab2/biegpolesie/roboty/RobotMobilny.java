package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Robot;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

/**
 *
 * @author TB
 */
public class RobotMobilny extends Robot {

    public RobotMobilny(int numerSeryjny) {
        super("Robot mobilny typ A", numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        switch(rodzajTerenu)
        {
            case DROGA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Rozwijanie maksymalnej prędkości.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.7;
            case SCIEZKA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Prędkość umiarkowana.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.6;
            case WYSOKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Nieprzyjazne warunki.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.3;
            case NISKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Wykryto znaczną liczbę przeszkód.");
                return czynnikiLosowe.nextDouble()*0.2 + 0.2;
            case BAGNO:
            default:
                komunikuj("Wykryto teren: "+rodzajTerenu+".");
                komunikuj("Awaria silników! Na szczęście jeszcze moge zabijać... znaczy co?");
                return czynnikiLosowe.nextDouble()*0.1; //Od 0.0 do 0.1
        }
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        komunikuj("Błąd OCR. Losowanie rozwiązania.");
        return czynnikiLosowe.nextDouble() <= 0.05;
    }
    
}
