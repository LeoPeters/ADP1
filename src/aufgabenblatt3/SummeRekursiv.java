/** 
 * Algorithmen & Datenstrukturen - Pareigis
 * Aufgabenblatt Nr. 3
 * 12.04.2017 - Version 1.0
 * Leo Peters & Robert Palm
 */
package aufgabenblatt3;

/**
 * Diese Klasse berechnet die Summe der natürlichen Zahlen bis n, mit einer
 * rekursiven Funktion.
 * 
 * @author Robert Palm & Leo Peters
 *
 */
public class SummeRekursiv {
  public int summeBerechnen(int n) {
    if (n > 0) {
      System.out.println("Rechnen");
      return n + summeBerechnen(n - 1);
    }
    return 0;
  }

  public static void main(String args[]) {
    SummeRekursiv rekursiv = new SummeRekursiv();
    System.out.println(rekursiv.summeBerechnen(11));
  }
}
