package aufgabenblatt5;

public class SortierObjekt {

  private int objektNummer;
  private static int objektNummerZaehler = 0;

  public int getObjektNummer() {
    return objektNummer;
  }

  public SortierObjekt() {
    objektNummer = objektNummerZaehler;
    objektNummerZaehler++;
  }
}
