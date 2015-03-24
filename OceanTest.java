import static org.junit.Assert.*;

import org.junit.Test;


public class OceanTest {


	public void testConstructor() {
		Ocean o = new Ocean();
		
		boolean value1 = o.getShotsFired() == 0;
		boolean value2 = o.getHitCount() == 0;
		boolean value3 = o.getShipsSunk() == 0;
		boolean value4 = o.getShipArray()[0][0].getLength() == 1;
		
		assertEquals(true, value1 && value2 && value3 && value4);
	}
	
	
	public void testingIsOccupied() {
		Ocean o = new Ocean();		
		assertEquals(true, o.isOccupied(0, 0));
	}
	
	public void testingShootAt() {
		Ocean o = new Ocean();
		assertEquals(false, o.shootAt(0, 0));
	}
	
	
	public void testingShipArray() {
		Ocean o = new Ocean();
		boolean valid = o.getShipArray() != null;
		assertEquals(true, valid);
	}

	

}
