package aufgabenblatt9;

public class Zaehler {

  private static long zaehler = 0;
  private static boolean zaehlerAn = true;

  public static long getZaehler() {
    return zaehler;
  }

  public static void inkrement() {
    if (zaehlerAn) {
      zaehler++;
    }
  }

  public static void zaehlerAn() {
    zaehlerAn = true;
  }

  public static void zaehlerAus() {
    zaehlerAn = false;
  }

  public static void reset() {
    zaehler = 0;
  }
}
