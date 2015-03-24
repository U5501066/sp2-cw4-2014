import java.util.Random;

/**
 * @author Ocean Class to holds array of Ships
 *
 */
public class Ocean {
	public static final int OCEAN_SIZE = 10;

	private Ship[][] ships = new Ship[OCEAN_SIZE][OCEAN_SIZE];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;

	/**
	 * Constructor for intializing Ocean
	 */
	public Ocean() {
		for (int i = 0; i < OCEAN_SIZE; i++) {
			for (int j = 0; j < OCEAN_SIZE; j++) {
				ships[i][j] = new EmptySea();
			}
		}

		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
	}

	/**
	 * Randomly place ship in array of ships, total 10 ships are placed randomly
	 */
	public void placeAllShipsRandomly() {
		Random random = new Random();

		// Randomly Place Battleship

		int x = random.nextInt(10);
		int y = random.nextInt(10);
		boolean h = random.nextBoolean();

		Battleship b = new Battleship();

		while (!b.okToPlaceShipAt(x, y, h, this)) {
			x = random.nextInt(10);
			y = random.nextInt(10);
			h = random.nextBoolean();
		}

		b.placeShipAt(x, y, h, this);

		// Randomly Place 2 Cruiser Ship

		for (int i = 0; i < 2; i++) {
			x = random.nextInt(10);
			y = random.nextInt(10);
			h = random.nextBoolean();

			Cruiser c = new Cruiser();

			while (!c.okToPlaceShipAt(x, y, h, this)) {
				x = random.nextInt(10);
				y = random.nextInt(10);
				h = random.nextBoolean();
			}

			c.placeShipAt(x, y, h, this);
		}

		// Randomly Place 3 Destroyer Ship

		for (int i = 0; i < 3; i++) {
			x = random.nextInt(10);
			y = random.nextInt(10);
			h = random.nextBoolean();

			Destroyer d = new Destroyer();

			while (!d.okToPlaceShipAt(x, y, h, this)) {
				x = random.nextInt(10);
				y = random.nextInt(10);
				h = random.nextBoolean();
			}

			d.placeShipAt(x, y, h, this);
		}

		// Randomly Place 4 Submarine Ships
		for (int i = 0; i < 4; i++) {
			x = random.nextInt(10);
			y = random.nextInt(10);
			h = random.nextBoolean();

			Submarine s = new Submarine();

			while (!s.okToPlaceShipAt(x, y, h, this)) {
				x = random.nextInt(10);
				y = random.nextInt(10);
				h = random.nextBoolean();
			}

			s.placeShipAt(x, y, h, this);
		}

	}

	/**
	 * 
	 * @param row
	 *            index
	 * @param column
	 *            index
	 * @return true is ship is present at that Point
	 */
	public boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType().equals("empty"))
			return false;
		return true;
	}

	/**
	 * @param row
	 * @param column
	 * @return true of false, true when shoot is hit
	 */
	public boolean shootAt(int row, int column) {
		shotsFired++;

		if (!ships[row][column].isSunk()) {
			if (ships[row][column].shootAt(row, column)) {
				hitCount++;
				if (ships[row][column].isSunk()) {
					shipsSunk++;
					System.out.println("You just sank a ship "
							+ ships[row][column].getShipType());
				}
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @return total short Fired
	 */
	public int getShotsFired() {
		return shotsFired;
	}

	/**
	 * 
	 * @return total shots hit the target
	 */
	public int getHitCount() {
		return hitCount;
	}

	/**
	 * 
	 * @return total number of ships sunk
	 */
	public int getShipsSunk() {
		return shipsSunk;
	}

	/**
	 * 
	 * @return true if no more ship remaining to sunk
	 */
	public boolean isGameOver() {
		return shipsSunk == OCEAN_SIZE;
	}

	/**
	 * 
	 * @return Ship array for using in testing class of java
	 */
	public Ship[][] getShipArray() {
		return ships;
	}

	/**
	 * print the screen and inform user what is going
	 */
	public void print() {
		// Showing top numbering of column
		System.out.print("  ");
		for (int i = 0; i < Ocean.OCEAN_SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < Ocean.OCEAN_SIZE; i++) {
			// SHowing numbering of rows
			System.out.print(i + " ");

			// Main data of ships
			for (int j = 0; j < Ocean.OCEAN_SIZE; j++) {
				if (ships[i][j].isHorizontal())
					System.out.print(ships[i][j].toString(j) + " ");
				else
					System.out.print(ships[i][j].toString(i) + " ");
			}
			System.out.println();
		}

	}
}
