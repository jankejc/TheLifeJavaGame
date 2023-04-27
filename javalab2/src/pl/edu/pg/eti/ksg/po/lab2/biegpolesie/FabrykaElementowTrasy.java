package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

/**
 *
 * @author TB
 */
public class FabrykaElementowTrasy 
{
    public static ElementTrasy utworzElementTrasy(RodzajTerenu rt)
    {
        return new Teren(rt);
    }
    
    public static ElementTrasy utworzElementTrasy(DziedzinaZadania dz)
    {
        return new Zadanie(dz);
    }
    
    public static ElementTrasy utworzElementTrasy(String str) throws NieMoznaUtworzycElementuTrasyException
    {
        try
        {
            RodzajTerenu rt = RodzajTerenu.valueOf(str.toUpperCase());
            return utworzElementTrasy(rt);
        }
        catch(IllegalArgumentException ex)
        {}
        
        try
        {
            DziedzinaZadania dz = DziedzinaZadania.valueOf(str.toUpperCase());
            return utworzElementTrasy(dz);
        }
        catch(IllegalArgumentException ex)
        {}
        
        throw new NieMoznaUtworzycElementuTrasyException("Nie znana dziedzina zadania lub nie znany rodzaj terenu: "+str);
    }
}
