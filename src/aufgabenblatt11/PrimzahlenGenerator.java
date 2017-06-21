package aufgabenblatt11;

public class PrimzahlenGenerator {
  private static int zufallsZahl = 4;
  
  public static int getPrimzahl() {
    while (!istPrimzahl(zufallsZahl)) {
          zufallsZahl = (int)((1 + Math.random()*4)*100);
    }
    return zufallsZahl;
  }
  
  private static boolean istPrimzahl(int x) {
      for (int j = 2; j < x; j++) {
        if ((x % j == 0) && (j != x)) {
          return false;
        }
      }
      return true;
    }
  }
