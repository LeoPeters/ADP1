package aufgabenblatt9;

import java.util.Iterator;
import java.util.LinkedList;

public class Knoten {

  private LinkedList<Kante> nachbarKnoten;
  private boolean abgeschlossen;
  private Knoten nextKnoten;
  private int distanz;

  public Knoten() {
    nachbarKnoten = new LinkedList<Kante>();
    addNachbarKnoten(this, 0);
    setAbgeschlossen(false);
    distanz = -1;
  }

  public LinkedList<Knoten> getNachbarn() {
    Iterator<Kante> it = nachbarKnoten.iterator();
    LinkedList<Knoten> nachbarn = new LinkedList<Knoten>();
    
    while (it.hasNext()) {
      nachbarn.add(it.next().getNachbarKnoten());
    }
    return nachbarn;
  }

  public int getGewichtung(Knoten zielknoten) {
    Iterator<Kante> it = nachbarKnoten.iterator();
    Kante kante = null;
    while (it.hasNext()) {
      kante = it.next();
      if (kante.getNachbarKnoten() == zielknoten) {
        return kante.getGewicht();
      }
    }
    return -1;
  }

  public void addNachbarKnoten(Knoten neuerNachbar, int gewicht) {
    Zaehler.inkrement();
    nachbarKnoten.add(new Kante(neuerNachbar, gewicht));
  }

  public void deleteNachbarKnoten(Knoten knoten) {
    Iterator<Kante> it = nachbarKnoten.iterator();
    Kante kante = null;
    while (it.hasNext()) {
      kante = it.next();
      if (kante.getNachbarKnoten() == knoten) {
        break;
      }
    }
    nachbarKnoten.remove(kante);
  }

  public boolean istAbgeschlossen() {
    return abgeschlossen;
  }

  public void setAbgeschlossen(boolean istAbgeschlossen) {
    this.abgeschlossen = istAbgeschlossen;
  }

  public Knoten getNextKnoten() {
    return nextKnoten;
  }

  public void setNextKnoten(Knoten nextKnoten) {
    this.nextKnoten = nextKnoten;
  }

  public int getDistanz() {
    return distanz;
  }

  public void setDistanz(int distanz) {
    this.distanz = distanz;
  }

}
