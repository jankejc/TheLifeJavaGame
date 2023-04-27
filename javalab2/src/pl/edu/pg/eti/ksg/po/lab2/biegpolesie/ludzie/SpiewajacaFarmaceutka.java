package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class SpiewajacaFarmaceutka extends Czlowiek
{

    public SpiewajacaFarmaceutka(String imie, String nazwisko) {
        super(imie, nazwisko, Plec.KOBIETA);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Jestem "+getImie()+" "+getNazwisko()+". Bardzo lubie śpiewać!");
    }

    @Override
    protected void wypowiedzSie(String tresc) {
        getOsrodekKomunikacji().print(getImie() +" "+getNazwisko()+" śpiewa: ");
        getOsrodekKomunikacji().println(tresc);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        switch(dziedzinaZadania)
        {
            case SZTUKA:
                wypowiedzSie("Trzeba ułożyc wierszyk. Lubie to!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            case MEDYCYNA:
                wypowiedzSie("Pamiętam to z seminarium dyplomowego!");
                return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.7;
            default:
                return super.rozwiazZadanie(dziedzinaZadania); 
        }
    }
    
    
    
}
