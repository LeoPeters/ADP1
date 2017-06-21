package aufgabenblatt9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Adjazenzliste extends AGraph {
  public static final int SIZE_DEFAULT = 10;

  public Adjazenzliste(int size) {
    knotenList = new ArrayList<Knoten>(size);
  }

  public Adjazenzliste() {
    this(SIZE_DEFAULT);
  }

  @Override
  public void einfuegen(Knoten neuerKnoten) {
    Zaehler.inkrement();
    if (knotenList.contains(null)) {
      knotenList.set(knotenList.indexOf(null), neuerKnoten);
    } else {
      knotenList.add(neuerKnoten);
    }
  }

  @Override
  public void loeschen(Knoten neuerKnoten) {
    Zaehler.inkrement();
    LinkedList<Knoten> nachbarn = (neuerKnoten).getNachbarn();
    Iterator<Knoten> it = nachbarn.iterator();
    while (it.hasNext()) {
      it.next().deleteNachbarKnoten(neuerKnoten);
    }
    knotenList.remove(neuerKnoten);

  }

  @Override
  public LinkedList<Knoten> getNachbarn(Knoten knoten) {
    return knoten.getNachbarn();
  }

  public void setGewichtung(Knoten start, Knoten ende, int gewicht) {
    start.addNachbarKnoten(ende, gewicht);
    ende.addNachbarKnoten(start, gewicht);
  }

  @Override
  public int getGewichtung(Knoten start, Knoten ende) {
    Zaehler.inkrement();
    return start.getGewichtung(ende);
  }

  @Override
  public Knoten getIndexOf(int index) {
    Zaehler.inkrement();
    return knotenList.get(index);
  }

  @Override
  public boolean sindNachbarn(Knoten nodeA, Knoten nodeB) {
    Zaehler.inkrement();
    if (getGewichtung(nodeA, nodeB) == -1) {
      return false;
    }
    return true;
  }

  public int[][] toArray() {
    int[][] matrix = new int[knotenList.size()][knotenList.size()];
    for (int i = 0; i < knotenList.size(); i++) {
      for (int j = 0; j < knotenList.size(); j++) {
        matrix[i][j] = getGewichtung(knotenList.get(i), knotenList.get(j));
      }
    }
    return matrix;
  }
}
