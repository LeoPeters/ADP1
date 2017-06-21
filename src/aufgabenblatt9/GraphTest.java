package aufgabenblatt9;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

  AGraph graph;
  Knoten knotenA;
  Knoten knotenB;
  Knoten vergleich;

  @Before
  public void init() {
    graph = new Adjazenzmatrix();
    knotenA = new Knoten();
    knotenB = new Knoten();
    vergleich = new Knoten();

  }

  @Test
  public void testBasicFunction() {

    graph.einfuegen(knotenA);
    assertEquals(graph.getGewichtung(knotenA, knotenA), 0);

    graph.einfuegen(knotenB);
    graph.setGewichtung(knotenA, knotenB, 2);
    assertEquals(graph.getGewichtung(knotenB, knotenA), 2);

    vergleich = graph.getNachbarn(knotenA).getFirst();
    assertEquals(vergleich, knotenA);
    vergleich = graph.getNachbarn(knotenA).getLast();
    assertEquals(vergleich, knotenB);

    graph.loeschen(knotenB);
    vergleich = graph.getNachbarn(knotenA).getFirst();
    assertEquals(vergleich, knotenA);
    vergleich = graph.getNachbarn(knotenA).getLast();
    assertEquals(vergleich, knotenA);

  }

  @Test
  public void testDykstra() {
    Knoten a = new Knoten();
    Knoten b = new Knoten();
    Knoten c = new Knoten();
    Knoten d = new Knoten();
    Knoten e = new Knoten();

    graph.einfuegen(a);
    graph.einfuegen(b);
    graph.einfuegen(c);
    graph.einfuegen(d);
    graph.einfuegen(e);
    graph.setGewichtung(a, c, 3);
    graph.setGewichtung(a, e, 1);
    graph.setGewichtung(a, b, 5);
    graph.setGewichtung(b, e, 10);
    graph.setGewichtung(c, d, 1);
    graph.setGewichtung(b, d, 4);

    graph.getPaths(b);
    assertEquals(5, a.getDistanz());
    assertEquals(0, b.getDistanz());
    assertEquals(5, c.getDistanz());
    assertEquals(4, d.getDistanz());
    assertEquals(6, e.getDistanz());

    assertEquals(b, a.getNextKnoten());
    assertEquals(b, b.getNextKnoten());
    assertEquals(d, c.getNextKnoten());
    assertEquals(b, d.getNextKnoten());
    assertEquals(a, e.getNextKnoten());
  }

  @Test
  public void testKomplexitaet() {
    int size;
    int anzahlNachbarn;
    int k = 4;
    int[][] matrix;

    for (int i = 1; i <= k; i++) {
      size = (int) Math.pow(10, i);
      graph = new Adjazenzliste(size);
      anzahlNachbarn = 3;
      fuellen(size, anzahlNachbarn);
      Zaehler.reset();
      graph.getPaths(graph.getIndexOf((int) (Math.random() * size)));
      System.out.println("n=" + size);
      System.out.println("Liste  Aufwand:" + Zaehler.getZaehler());
      matrix = ((Adjazenzliste) graph).toArray();
      graph = new Adjazenzmatrix(matrix, size);
      Zaehler.reset();
      graph.getPaths(graph.getIndexOf((int) (Math.random() * size)));
      System.out.println("Matrix Aufwand:" + Zaehler.getZaehler() + "\n");
    }

  }

  public void fuellen(int size, int anzahlNachbarn) {
    Knoten tmpKnotenA = null;
    Knoten tmpKnotenB = null;
    int gewicht;
    for (int i = 0; i < size; i++) {
      Knoten neuerKnoten = new Knoten();
      graph.einfuegen(neuerKnoten);
      if (i > 0) {
        gewicht = (int) (Math.random() * 100);
        graph.setGewichtung(neuerKnoten, tmpKnotenA, gewicht);

      }
      tmpKnotenA = neuerKnoten;
    }
    for (int j = 0; j < anzahlNachbarn; j++) {
      for (int i = 0; i < size; i++) {
        tmpKnotenA = graph.getIndexOf(i);
        do {
          gewicht = (int) (Math.random() * size);
          tmpKnotenB = graph.getIndexOf(gewicht);
        } while (graph.getNachbarn(tmpKnotenA).contains(tmpKnotenB));
        gewicht = (int) Math.random() * 100;
        graph.setGewichtung(tmpKnotenB, tmpKnotenA, gewicht);
      }
    }

  }

}
