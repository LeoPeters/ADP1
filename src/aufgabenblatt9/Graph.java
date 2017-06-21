package aufgabenblatt9;

import java.util.LinkedList;

public interface Graph {

  public void einfuegen(Knoten node);

  public void loeschen(Knoten node);

  public LinkedList<Knoten> getNachbarn(Knoten node);

  public int getGewichtung(Knoten start, Knoten end);

  public boolean sindNachbarn(Knoten nodeA, Knoten nodeB);

  public void setGewichtung(Knoten nodeA, Knoten nodeB, int weight);

  public Knoten getIndexOf(int index);
}
