package aufgabenblatt9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AGraph implements Graph {

  protected ArrayList<Knoten> knotenList;

  public void getPaths(Knoten Knoten) {

    LinkedList<Knoten> nichtAbgeschlossen = new LinkedList<>();
    LinkedList<Knoten> nachbarn = new LinkedList<>();
    Knoten altKnoten = Knoten;
    Knoten tmpKnoten = new Knoten();
    Knoten minKnoten = null;
    altKnoten.setAbgeschlossen(true);
    altKnoten.setDistanz(0);
    altKnoten.setNextKnoten(altKnoten);
    Iterator<Knoten> it;
    do {
      nachbarn = getNachbarn(altKnoten);
      it = nachbarn.iterator();
      while (it.hasNext()) {
        Zaehler.inkrement();
        tmpKnoten = it.next();
        if (!tmpKnoten.istAbgeschlossen() && !nichtAbgeschlossen.contains(tmpKnoten)) {
          nichtAbgeschlossen.add(tmpKnoten);
        }
      }

      it = nichtAbgeschlossen.iterator();
      while (it.hasNext()) {
        tmpKnoten = it.next();
        Zaehler.inkrement();
        if (sindNachbarn(altKnoten, tmpKnoten) && kuerzer(altKnoten, tmpKnoten)) {
          tmpKnoten.setDistanz(altKnoten.getDistanz() + getGewichtung(altKnoten, tmpKnoten));
          tmpKnoten.setNextKnoten(altKnoten);
        }
        if (minKnoten == null || minKnoten.getDistanz() > tmpKnoten.getDistanz()) {
          minKnoten = tmpKnoten;
        }
      }

      altKnoten.setAbgeschlossen(true);
      nichtAbgeschlossen.remove(altKnoten);
      altKnoten = minKnoten;
      minKnoten = null;
    } while (!nichtAbgeschlossen.isEmpty());

  }

  private boolean kuerzer(Knoten altNode, Knoten tmpNode) {
    return (altNode.getDistanz() + getGewichtung(altNode, tmpNode) < tmpNode.getDistanz()
        || tmpNode.getDistanz() == -1);
  }
}
