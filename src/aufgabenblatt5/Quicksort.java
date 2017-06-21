package aufgabenblatt5;

import java.util.Random;

public class Quicksort {
  public static final int ANZAHL_OBJEKTE = 100; //
  private SortierObjekt[] sortierArray = new SortierObjekt[ANZAHL_OBJEKTE];
  private int zaehler = 0;
  private enum PivotPosition {ANFANG, ENDE, ZUFALL, MEDIAN};
  
  public Quicksort() {
    for (int i = 0; i < sortierArray.length; i++) {
      sortierArray[i] = new SortierObjekt();
    }
    arrayMischen();
  }

  public SortierObjekt quicksort(int index) {
    return sortierArray[index];
  }

  public void arrayMischen() {
    SortierObjekt temp;
    int random;
    Random randomizer = new Random();
    for (int i = 0; i < sortierArray.length; i++) {
      random = randomizer.nextInt(sortierArray.length);
      temp = sortierArray[i];
      sortierArray[i] = sortierArray[random];
      sortierArray[random] = temp;
    }
  }

  public void linksRechtsDurchlauf(int iLinks, int iRechts) {
    if (iRechts > iLinks) {
      int pivotElementKey, links, rechts;
      links = iLinks;
      rechts = iRechts;
      pivotElementKey = sortierArray[iLinks].getObjektNummer();
      while (links < rechts) {
        while (sortierArray[links].getObjektNummer() < pivotElementKey) {
          zaehler++;
          links++;
        }
        while (sortierArray[rechts].getObjektNummer() > pivotElementKey) {
          zaehler++;
          if (rechts-- == 0)
            break;
        }
        if (links <= rechts) {
          zaehler++;
          elementeTauschen(links, rechts);
          links++;
          rechts--;
        }
      }
      if (links < iRechts) {
        linksRechtsDurchlauf(links, iRechts);
      }
      if (rechts > iLinks) {
        linksRechtsDurchlauf(iLinks, rechts);
      }
    }
    // elementeTauschen(links, iRechts);
    // linksRechtsDurchlauf(iLinks, links - 1);
    // linksRechtsDurchlauf(links + 1, iRechts);
  }

  private int pivotAuswahl(int links, int rechts, PivotPosition pivotPosition) {
    switch (pivotPosition) {
    case ANFANG:
      return links;
    
    case ENDE:
      return rechts;
      
    case ZUFALL:
      return (int) (Math.random() * (rechts - links) + links);
      
    case MEDIAN:
      if (sortierArray[rechts].getObjektNummer() >= sortierArray[links].getObjektNummer() &&
          (sortierArray[rechts].getObjektNummer() <= sortierArray[rechts/2].getObjektNummer())) {
        return sortierArray[rechts].getObjektNummer();
      } else if (sortierArray[links].getObjektNummer() >= sortierArray[rechts].getObjektNummer() &&
                  (sortierArray[links].getObjektNummer() <= sortierArray[rechts/2].getObjektNummer())) {
        return sortierArray[links].getObjektNummer();
      }
        else if (sortierArray[rechts/2].getObjektNummer() >= sortierArray[links].getObjektNummer() &&
                  (sortierArray[rechts/2].getObjektNummer() <= sortierArray[rechts].getObjektNummer())) {
          return sortierArray[rechts/2].getObjektNummer();
        } else {
          return sortierArray[links].getObjektNummer();
        }
      
    default:
      return (int) sortierArray[(rechts + links) / 2].getObjektNummer();
    }
  }
  public void quicksort(int iLinks, int iRechts, PivotPosition pivotPosition) {
    int links = iLinks;
    int rechts = iRechts;
    int pivotElementKey = sortierArray[pivotAuswahl(links, rechts, pivotPosition)].getObjektNummer();
    while (links < rechts) {
      while (sortierArray[links].getObjektNummer() < pivotElementKey) {
        zaehler++;
        links++;
      }
      while (sortierArray[rechts].getObjektNummer() > pivotElementKey) {
        zaehler++;
        rechts--;
      }
      if (links <= rechts) {
        zaehler++;
        elementeTauschen(links, rechts);
        links++;
        rechts--;
      }
    }
    if (links < iRechts) {
      quicksort(links, iRechts, pivotPosition);
    }
    if (rechts > iLinks) {
      quicksort(iLinks, rechts, pivotPosition);
    }
  }

  public void elementeTauschen(int i, int j) {
    SortierObjekt temp;
    temp = sortierArray[i];
    sortierArray[i] = sortierArray[j];
    sortierArray[j] = temp;
  }

  public void ausgeben() {
    for (SortierObjekt i : sortierArray) {
      System.out.println(i.getObjektNummer());
    }
  }

  public static void main(String args[]) {
    Quicksort quicksort = new Quicksort();
    System.out.println("Unsortiertes Array: ");
    quicksort.ausgeben();
    System.out.println("Ende unsortieres Array\nSortiertes Array: ");
    quicksort.quicksort(0, ANZAHL_OBJEKTE - 1, PivotPosition.ZUFALL);
    quicksort.ausgeben();
    System.out.println("\nAufwand: " + quicksort.zaehler);
  }
}
