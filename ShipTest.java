import static org.junit.Assert.*;

import org.junit.Test;


public class ShipTest {

	
	// - - -- - - - -- - - - - - - - - - - - - --  
	// Testing Length of Each Class in ship
	// - - - - -- - - - - -- - -  - - -- - - - -- 
	
	
	public void testBattleShip_length() {
		Ship s = new Battleship();
		assertEquals(4, s.getLength());
	}
	
	public void testCruiserShip_length() {
		Ship s = new Cruiser();
		assertEquals(3, s.getLength());
	}
	
	public void testDestroyer_length() {
		Ship s = new Destroyer();
		assertEquals(2, s.getLength());
	}
	
	public void testSubmarine_length() {
		Ship s = new Submarine();
		assertEquals(1, s.getLength());
	}
	
	public void testEmptySea_length() {
		Ship s = new EmptySea();
		assertEquals(1, s.getLength());
	}
	
	// -- - - - - -- - - - -- - - - 
	// Testing Ship Types
	//  - - -- - - - - -- - - - - -
	
	public void testBattleShip_shiptype() {
		Ship s= new Battleship();
		assertEquals("battleship", s.getShipType());
	}
	
	public void testCruiserShip_shiptype() {
		Ship s= new Cruiser();
		assertEquals("cruiser", s.getShipType());
	}
	
	public void testDestroyer_shiptype() {
		Ship s = new Destroyer();
		assertEquals("destroyer", s);
	}
	
	public void testSUbmarine_shiptype() {
		Ship s = new Submarine();
		assertEquals("submarine" , s.getShipType());
	}
	
	public void testEmptySea_shiptype(){
		Ship s = new EmptySea();
		assertEquals("empty", s.getShipType());
	}
	
	
	// Checking placement of ships
	
	public void testBattleShip_placed() {
		Ship s = new Battleship();
		assertEquals(true, s.okToPlaceShipAt(0, 0, true, new Ocean()));
	}
	
	
	public void testCruiser_placed() {
		Ship s = new Cruiser();
		assertEquals(true , s.okToPlaceShipAt(0, 0, false, new Ocean()));
	}
	
	public void testDestroyer_placed() {
		Ship s = new Destroyer();
		assertEquals(true, s.okToPlaceShipAt(0, 1, true, new Ocean()));
	}
	
	public void testSubmarine_placed() {
		Ship s = new Submarine();
		assertEquals(true, s.okToPlaceShipAt(0, 0,false, new Ocean()));	
	}
	
	
	
	

}
