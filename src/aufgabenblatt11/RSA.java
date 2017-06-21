package aufgabenblatt11;

public class RSA {
  public int e, n, hauptModul, nebenModul, q, p;
  private String test = "jkdsajdhfssdfasd";

  public void verfahrenRSA() {
    p = PrimzahlenGenerator.getPrimzahl();
    q = PrimzahlenGenerator.getPrimzahl();
    nebenModul = getNebenModul(p, q);
    hauptModul = getHauptModul(p, q);
    e = (int) (Math.random() * nebenModul);
    if (e <= 1) {
      e = 2;
    }
    while (Euklid.getGGT(e, nebenModul) != 1) {
      e++;
}
    n = Euklid.d;

    if (n < 0) {
      verfahrenRSA();
    } else if (!decrypt(encrypt(test)).equals(test)) {
      verfahrenRSA();
    }
  }

  private static int getHauptModul(int p, int q) {
    return p * q;
  }

  private static int getNebenModul(int p, int q) {
    return (p - 1) * (q - 1);
  }

  public int[] encrypt(String string) {
    char[] array = new char[string.length()];
    int[] intarray = new int[string.length()];
    string.getChars(0, string.length(), array, 0);
    String eBinary = Integer.toBinaryString(e);

    for (int i = 0; i < array.length; i++) {
      int a = array[i];
      long result = 1;

      for (int j = 0; j < eBinary.length(); j++) {
        result = result * result;
        if (eBinary.charAt(j) == '1') {
          result *= a;
        }
        result = result % hauptModul;
      }
      intarray[i] = (char) result;
    }
    return intarray;
  }

  public String decrypt(int[] string) {
    String nBinary = Integer.toBinaryString(n);
    char[] array = new char[string.length];

    for (int i = 0; i < string.length; i++) {
      int a = string[i];
      long result = 1;

      for (int j = 0; j < nBinary.length(); j++) {
        result = result * result;
        if (nBinary.charAt(j) == '1') {
          result *= a;
        }
        result = result % hauptModul;
      }
      array[i] = (char) result;
    }
    return new String(array);
  }

  public int decryptEncrypt(int wert, int exp, int modulo) {
    int ergebnis = 1;
    for (int i = 0; i < exp; i++) {
      ergebnis = (wert * ergebnis) % modulo;
    }
    return ergebnis;
  }

  public void setHauptmodul(int N)
  {
    hauptModul = N;
  }
  public void setE(int e)
  {
    this.e= e;
  }
  
  public void setN(int n)
  {
    this.n= n;
  }

  public int getHauptmodul() {
    return hauptModul;
  }

  public int getNebenmodul() {
    return nebenModul;
  }

  public int getQ() {
    return q;
  }

  public int getP() {
    return p;
  }

  public int getE() {
    return e;
  }

  public int getN() {
    return n;
  }

}
