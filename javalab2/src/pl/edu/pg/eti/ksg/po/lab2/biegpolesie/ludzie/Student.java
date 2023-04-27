package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

/**
 *
 * @author TB
 */
public class Student extends Czlowiek
{

    private String kierunekStudiow;

    public Student(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec);
        this.kierunekStudiow = kierunekStudiow;
    }

    public String getKierunekStudiow() {
        return kierunekStudiow;
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Nazywam "+getImie()+" "+getNazwisko()+". Studiuję na kierunku "+kierunekStudiow+".");
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        String czytac;
        
        if(Plec.MEZCZYZNA.equals(this.getPlec()))
        {
            czytac = "czytałem";
        }
        else
        {
            czytac = "czytałam";
        }
        
        wypowiedzSie("Hmm "+dziedzinaZadania+". Gdzieś o tym "+czytac+".");
        return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.2;
    }
    
    
    
}
