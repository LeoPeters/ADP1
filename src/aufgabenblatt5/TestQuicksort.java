package aufgabenblatt5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuicksort {

  @Test 
  public void testLinksRechtsDurchlauf() {
    Quicksort quicksort = new Quicksort();
    quicksort.linksRechtsDurchlauf(0, 99);
    for(int i = 0; i < 100; i++) {
      assertEquals(i, quicksort.quicksort(i).getObjektNummer());
    }
  }
}
