package aufgabenblatt4;

public class pascalIterativ {

  private long zaehler;

  public long[] berechnePascalschesDreieck(int zeile) {
    long[][] pascal = new long[zeile][zeile + 2];
    long result;

    pascal[0][1] = 1;

    for (int reihe = 1; reihe < zeile; reihe++) {
      zaehler++;
      for (int spalte = 1; spalte < zeile + 2; spalte++) {
        zaehler++;
        result = pascal[reihe - 1][spalte] + pascal[reihe - 1][spalte - 1];
        pascal[reihe][spalte] = result;
        if (result == 0) {
          break;
        }
      }
    }

    return pascal[zeile - 1];
  }
//  public long[] berechnePascalschesDreieck2(int zeile) {
//    long[][] pascal = new long[zeile][zeile];
//    long result;
//    
//    
//    
//  }
  
  public long getZaehler() {
    return zaehler;
  }

  public void setZaehler(long zaehler) {
    this.zaehler = zaehler;
  }
  public void pascalAusgeben(int n) {
    long[] zeile = berechnePascalschesDreieck(n);
    for (long element : zeile) {
      System.out.println(element);
    }
  }
  public static void main(String args[]) {
    pascalIterativ iterativ = new pascalIterativ();
    iterativ.pascalAusgeben(3);
  }
}
