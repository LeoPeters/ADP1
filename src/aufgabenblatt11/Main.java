package aufgabenblatt11;

public class Main {
  public static void main(String[] args) {

    RSA rsa = new RSA();
    rsa.verfahrenRSA();
    Hybrid h = new Hybrid(rsa, new BlockChiffre());

    rsa.setE(46823);
    rsa.setN(2747);
    rsa.setHauptmodul(54889);
    System.out.println(h.decryptString("  cA \"f`csaj`ropdgc$fp\\tkxn"));

  }
}
