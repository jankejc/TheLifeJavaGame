package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TB
 */
public class Zadanie implements ElementTrasy {
    private final DziedzinaZadania dziedzinaZadania;
    private final Set<Uczestnik> uczestnicyRozwiazujacyZadanie = new HashSet<>();

    Zadanie(DziedzinaZadania dziedzinaZadania) {
        this.dziedzinaZadania = dziedzinaZadania;
    }
    
    public DziedzinaZadania getDziedzinaZadania() {
        return dziedzinaZadania;
    }

    public Set<Uczestnik> getUczestnicyRozwiazujacyZadanie() {
        return uczestnicyRozwiazujacyZadanie;
    }
    
    @Override
    public Iterable<Uczestnik> getUczestnicy() {
        return uczestnicyRozwiazujacyZadanie;
    }

    @Override
    public void dodajUczestnika(Uczestnik u) {
        uczestnicyRozwiazujacyZadanie.add(u);
    }

    @Override
    public void usunUczestnika(Uczestnik u) {
        uczestnicyRozwiazujacyZadanie.remove(u);
    }

    @Override
    public int getLiczbaUczestnikowNaTrasie() {
        return uczestnicyRozwiazujacyZadanie.size();
    }    
    
}
