package aufgabenblatt9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Adjazenzmatrix extends AGraph {

  public static final int KEINE_KANTE = -1;
  private int[][] matrix;

  public Adjazenzmatrix(int size) {
    knotenList = new ArrayList<Knoten>(size);
    matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = KEINE_KANTE;
      }
    }
  }

  public Adjazenzmatrix() {
    this(10);
  }

  public Adjazenzmatrix(int[][] matrix, int size) {
    knotenList = new ArrayList<Knoten>(size);
    this.matrix = matrix;
    for (int i = 0; i < size; i++) {
      knotenList.add(new Knoten());
    }
  }

  @Override
  public void einfuegen(Knoten knoten) {
    Zaehler.inkrement();
    if (knotenList.size() >= matrix.length && !knotenList.contains(null)) {
      System.out.println("Graph ist voll");
      return;
    }

    if (knotenList.contains(null)) {
      knotenList.set(knotenList.indexOf(null), knoten);
    } else {
      knotenList.add(knoten);
    }
    matrix[knotenList.indexOf(knoten)][knotenList.indexOf(knoten)] = 0;
  }

  @Override
  public void loeschen(Knoten knoten) {
    int index = knotenList.indexOf(knoten);
    if (matrix.length + matrix.length * 0.1 + 1 < knotenList.size()) {
      matrixAnpassen((int) (matrix.length - matrix.length * 0.1 - 1));
    }
    for (int i = 0; i < matrix.length; i++) {
      Zaehler.inkrement();
      matrix[index][i] = KEINE_KANTE;
      matrix[i][index] = KEINE_KANTE;
    }
    knotenList.set(knotenList.indexOf(knoten), null);
  }

  @Override
  public LinkedList<Knoten> getNachbarn(Knoten knoten) {
    int index = knotenList.indexOf(knoten);
    LinkedList<Knoten> nachbarn = new LinkedList<Knoten>();
    nachbarn.add(knoten);
    for (int i = 0; i < knotenList.size(); i++) {
      Zaehler.inkrement();
      if (matrix[index][i] != KEINE_KANTE && i != index) {
        nachbarn.add(knotenList.get(i));
      }
    }
    return nachbarn;
  }

  @Override
  public int getGewichtung(Knoten knotenA, Knoten knotenB) {
    Zaehler.inkrement();
    int start = knotenList.indexOf(knotenA);
    int end = knotenList.indexOf(knotenB);
    if (start >= matrix.length || end >= matrix.length) {
      System.out.println("Index out of Bounds");
      return -1;
    }
    return matrix[start][end];
  }

  private void matrixAnpassen(int size) {
    int[][] neueMatrix = new int[size][];
    for (int i = 0; i < size; i++) {
      Zaehler.inkrement();
      if (i < matrix.length) {
        neueMatrix[i] = Arrays.copyOf(matrix[i], size);
      } else {
        neueMatrix[i] = new int[size];
        Arrays.fill(neueMatrix[i], KEINE_KANTE);
      }
    }
    matrix = neueMatrix;
  }

  @Override
  public Knoten getIndexOf(int index) {
    Zaehler.inkrement();
    return knotenList.get(index);
  }

  @Override
  public void setGewichtung(Knoten knotenA, Knoten knotenB, int gewicht) {
    Zaehler.inkrement();
    int indexA = knotenList.indexOf(knotenA);
    int indexB = knotenList.indexOf(knotenB);

    matrix[indexA][indexB] = gewicht;
    matrix[indexB][indexA] = gewicht;

  }

  @Override
  public boolean sindNachbarn(Knoten knotenA, Knoten knotenB) {
    Zaehler.inkrement();
    if (getGewichtung(knotenA, knotenB) == -1) {
      return false;
    }
    return true;
  }

}
