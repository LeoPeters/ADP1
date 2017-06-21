package aufgabenblatt1;

import static org.junit.Assert.*;
import aufgabenblatt1.*;
import org.junit.Test;

public class TestListeB {

    @Test
    public void testIncreaseArraySize() {
      ListeB listeB = new ListeB();
        listeB.increaseArraySize(listeB.getPosArray());
        assertEquals(32, listeB.getSize());
        listeB.increaseArraySize(listeB.getPosArray());
        assertEquals(64, listeB.getSize());
    }
    
    @Test
    public void testInsert() {
      int testKey = -1;
      ListeB listeA = new ListeB(); Element element = new Element(); Position pos = new Position();
//      Element element2 = new Element();
      pos.setElement(element);
      listeA.insert(element, pos);
//      for(int i = 0; i < listeA.getSize(); i++) {
//        if(listeA.getListArrayIndex(i) == pos) {
//          testKey = listeA.getListArrayIndex(i).getKEY();
//        }
//      }
      assertEquals(testKey, element.getKEY());
//      listeA.insert(element2, pos);
//      assertEquals(listeA.retrieve(pos).getKEY(), element.getKEY());
    }
    @Test
    public void testFind() {
      ListeB listeA = new ListeB(); Element element = new Element(); Position pos = new Position();
      pos.setElement(element);
      listeA.insert(element, pos);
//      assertEquals(listeA.get, listeA.find(pos.getKEY()));
    }

}

