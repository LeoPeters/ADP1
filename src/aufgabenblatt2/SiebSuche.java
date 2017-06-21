/** 
 * Algorithmen & Datenstrukturen - Pareigis
 * Aufgabenblatt Nr. 2
 * 05.04.2017 - Version 1.0
 * Leo Peters & Robert Palm
 */
package aufgabenblatt2;

/**
 * Diese Klasse benutzt das Sieb des Eratosthenes um alle Zahlen bis zu einer
 * Angegebenen Zahl auf Primzahlen zu �berpr�fen.
 * 
 * @author Robert Plam & Leo Peters
 */
public class SiebSuche {
  //Z�hler zur Aufwandsanalyse
  public static int zaehlerSieb;

  /**
   * Es werden bei allen Zahlen bis zum Parameter N ueberprueft ob es eine Primzahl ist.
   * 
   * @param N
   *          Die letzte Zahl, die ueberprueft werden soll.
   * @return
   *          Array mit boolean-werten, alle Werte, die 
   */
  public static boolean[] primzahlenSieb(int N) {
      zaehlerSieb = 0;
      // Initialisierung
    boolean[] a = new boolean[N];
    for (int i = 0; i < N; i++) {
      a[i] = true;
    }
    // Berechnung
    for (int i = 2; i < Math.sqrt(N); i++) {
      if (a[i] == true) {
        for (int j = 2; i * j < N; j++) {
          a[i * j] = false;
          zaehlerSieb++;
//          System.out.println("Sieb: " + zaehlerSieb);
        }
      }
    }
    return a;
  }
}
