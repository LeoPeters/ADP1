package aufgabenblatt11;

public class BlockChiffre {

  public static void main(String[] args) {
    BlockChiffre chiff = new BlockChiffre();
    String encryptedMessage = chiff.encrypt("janeinvielleicht");
    System.out.println(encryptedMessage);
    String decryptedMessage = chiff.decrypt(encryptedMessage);
    System.out.println(decryptedMessage);
    System.out.println("ENDE");
  }

  public String encrypt(String string) {
    char[] charClearArray = string.toCharArray();
    int[] intClearArray = new int[string.length()];

    for (int i = 0; i < charClearArray.length; i++) {
      intClearArray[i] = charClearArray[i] - 32;
    }
    int s0 = (int) (Math.random() * 94) + 1;
    int s1 = (int) (Math.random() * 94) + 1;
    int[] intKryptArray = new int[charClearArray.length + 8];
    intKryptArray[0] = s0;
    intKryptArray[1] = s1;

    for (int i = 0; i < charClearArray.length - 1; i += 2) {
      intKryptArray[i + 8] = (intClearArray[i] + s0) % 95;
      intKryptArray[i + 1 + 8] = (intClearArray[i + 1] + s1) % 95;
    }
    
    if (string.length() % 2 != 0) {
      intKryptArray[charClearArray.length - 1 + 8] = (intClearArray[charClearArray.length - 1] + s0) % 95;
    }
    char[] charKryptArray = new char[intKryptArray.length];

    for (int i = 0; i < intKryptArray.length; i++) {
      charKryptArray[i] = (char) (intKryptArray[i] + 32);
    }
    return String.valueOf(charKryptArray);
  }

  public String decrypt(String toDecrypt) {
    char[] charKryptArray = toDecrypt.toCharArray();
    int[] intKryptArray = new int[toDecrypt.length()];
    int s0 = charKryptArray[0];
    int s1 = charKryptArray[1];

    for (int i = 0; i < charKryptArray.length; i++) {
      intKryptArray[i] = charKryptArray[i] - 32;
    }

    char[] charClearArray = new char[intKryptArray.length - 8];

    for (int i = 0; i < charClearArray.length - 1; i += 2) {
      charClearArray[i] = (char) ((intKryptArray[i + 8] + 95 - s0) % 95);
      charClearArray[i] = (char) (charClearArray[i] + 32);
      charClearArray[i + 1] = (char) ((intKryptArray[i + 1 + 8] + 95 - s1) % 95);
      charClearArray[i + 1] = (char) (charClearArray[i + 1] + 32);
    }

    if (intKryptArray.length % 2 != 0) {
      if (s0 > intKryptArray[charClearArray.length - 1 + 8])
        charClearArray[charClearArray.length - 1] = 
        (char) (intKryptArray[charClearArray.length - 1 + 8] + 95 - s0 + 32);
      else
        charClearArray[charClearArray.length - 1] = 
        (char) (intKryptArray[charClearArray.length - 1 + 8] - s0 + 32);
    }
    return String.valueOf(charClearArray);
  }
}