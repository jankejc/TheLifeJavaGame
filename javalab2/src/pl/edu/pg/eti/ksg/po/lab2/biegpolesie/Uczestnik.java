package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.io.PrintStream;

/**
 *
 * @author TB
 */
public interface Uczestnik
{
    
    /**
     * Metoda ustawiająca strumień danych do którego będzie mówił uczestnik 
     * @param ps strumień danych
     */
    void mowDo(PrintStream ps);
    
    /**
     * Metoda pobierająca informacje o tym z jaką prędkościa prosza się
     * uczestnik w danym terenie. Wynik może być inny za każdym uruchomieniem
     * @param rodzajTerenu rodzaj terenu
     * @return wartość od 0 do 1
     */
    double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu);
    
    /**
     * Metoda testuje czy uczestik rozwiąże zagadkę z danej dziedziny
     * @param dziedzinaZadania dziedzina zadania
     * @return czy uczestnikowi się powiodło
     */
    boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania);
}
