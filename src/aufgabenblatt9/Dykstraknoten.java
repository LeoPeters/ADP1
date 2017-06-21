package aufgabenblatt9;

public class Dykstraknoten {

  private int nextKnoten;
  private int distanz;

  public Dykstraknoten(int nextKnoten, int distanz) {
    this.nextKnoten = nextKnoten;
    this.distanz = distanz;
  }

  public int getNextKnoten() {
    return nextKnoten;
  }

  public void setNextKnoten(int nextKnoten) {
    this.nextKnoten = nextKnoten;
  }

  public int getDistanz() {
    return distanz;
  }

  public void setDistanz(int distanz) {
    this.distanz = distanz;
  }
}
