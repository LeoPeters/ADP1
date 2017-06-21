package aufgabenblatt9;

public class Kante {

  private Knoten nachbarKnoten;
  private int gewicht;

  public Kante(Knoten nachbarKnoten, int gewicht) {
    this.nachbarKnoten = nachbarKnoten;
    this.gewicht = gewicht;
  }

  public Knoten getNachbarKnoten() {
    return nachbarKnoten;
  }

  public int getGewicht() {
    return gewicht;
  }
}
