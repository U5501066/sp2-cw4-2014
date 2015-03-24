/**
 * 
 * @author BattleShip Game Ship class, abstract class for ships
 */
public abstract class Ship {
	/**
	 * Instance Variable of Class Ship
	 */
	private int bowRow;
	private int bowColumn;
	protected int length;
	private boolean horizontal;
	protected boolean[] hit = new boolean[4];

	// ---- - -- - - - -- - -- - - - - -- -
	// GETTER FUNCTIONS
	// - - -- - -- - -- - - - -- - -- - -

	/**
	 * 
	 * @return bowRow Face
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * 
	 * @return BowColumn Face
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * 
	 * @return boolean value that ship is place horizontal or vertical
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * 
	 * @return String type override by Ship child classes
	 */
	public abstract String getShipType();

	/**
	 * 
	 * @return integer value of the length of child's ships.
	 */
	public abstract int getLength();

	/**
	 * 
	 * @param x
	 *            the value of the hit location
	 * @return and return symbol to represent in print function of ocean
	 */
	public abstract String toString(int x);

	// -- - - - - - -- - - - -- - -- - - -- - -
	// SETTERS FOR INSTANCE VARIABLES
	// - - -- - --- - -- - -- - - -- - -- - - -

	/**
	 * 
	 * @param row
	 *            , the row value where ship is going to be place it head
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * 
	 * @param column
	 *            , the column value where ship is going to place it head
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * 
	 * @param horizontal
	 *            , Boolean value that ship is place horizontal or not
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	// --- - - - - -- - - - - - - -- - - - - - -
	// INSTANCE METHOD FOR CLASS
	// ------ - -- - --- - - -- - - - -- - - -

	public boolean okToPlaceShipAt(int row, int column, boolean horizontal,
			Ocean ocean) {

		// Checking that row, column index is valid or not
		if (row < Ocean.OCEAN_SIZE && row >= 0 && column < Ocean.OCEAN_SIZE
				&& column >= 0) {

			// checking that placement is horizontal or vertical
			if (horizontal) {

				// Checking that space is valid that Ship can be place in the
				// region
				if (column + getLength() <= Ocean.OCEAN_SIZE) {

					// Checking that each location is free no ship reference is
					// present
					for (int i = column; i < (column + getLength()); i++) {

						// Checking Above location
						if (row - 1 >= 0 && ocean.isOccupied(row - 1, i)) {
							return false;
						}

						// Checking main location where to place a ship
						if (ocean.isOccupied(row, i)) {
							return false;
						}

						// Checking down location
						if (row + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(row + 1, i)) {
							return false;
						}
					}

					// Checking left column is in array size then it must be
					// free, not occupied
					if (column - 1 >= 0) {

						if (row - 1 >= 0
								&& ocean.isOccupied(row - 1, column - 1)) {
							return false;
						}

						if (ocean.isOccupied(row, column - 1)) {
							return false;
						}

						if (row + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(row + 1, column - 1)) {
							return false;
						}
					}

					// Checking that right column is also free, not occupied
					if (column + getLength() < Ocean.OCEAN_SIZE) {
						if (row - 1 >= 0
								&& ocean.isOccupied(row - 1, column
										+ getLength())) {
							return false;
						}

						if (ocean.isOccupied(row, column + getLength())) {
							return false;
						}

						if (row + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(row + 1, column
										+ getLength())) {
							return false;
						}
					}

					// if all above conditions valid then return true, other
					// wise this will.
					// not execute because false condition will returned from
					// the code.
					return true;
				}

				// Checking that if ship length is not valid
				return false;

			} else {

				// Checking that space is valid that Ship can be place in the
				// region
				if (row + getLength() <= Ocean.OCEAN_SIZE) {

					// Checking that each location is free no ship reference is
					// present
					for (int i = row; i < (row + getLength()); i++) {

						// Checking Left location
						if (column - 1 >= 0 && ocean.isOccupied(i, column - 1)) {
							return false;
						}

						// Checking main location where to place a ship
						if (ocean.isOccupied(i, column)) {
							return false;
						}

						// Checking Right location
						if (column + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(i, column + 1)) {
							return false;
						}
					}

					// Checking Above Row is in array size then it must be free,
					// not occupied
					if (row - 1 >= 0) {

						if (column - 1 >= 0
								&& ocean.isOccupied(row - 1, column - 1)) {
							return false;
						}

						if (ocean.isOccupied(row - 1, column)) {
							return false;
						}

						if (column + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(row - 1, column + 1)) {
							return false;
						}
					}

					// Checking that Below is in array size also free, not
					// occupied
					if (row + getLength() < Ocean.OCEAN_SIZE) {
						if (column - 1 >= 0
								&& ocean.isOccupied(row + getLength(),
										column - 1)) {
							return false;
						}

						if (ocean.isOccupied(row + getLength(), column)) {
							return false;
						}

						if (column + 1 < Ocean.OCEAN_SIZE
								&& ocean.isOccupied(row + getLength(),
										column + 1)) {
							return false;
						}
					}

					// if all above conditions valid then return true, other
					// wise this will.
					// not execute because false condition will returned from
					// the code.
					return true;
				}

				// If ship size out of bound then return false;
				return false;
			}
		}
		// If index out of bound then returns false
		return false;
	}

	/**
	 * 
	 * @param row
	 *            the row face index
	 * @param column
	 *            the column face index
	 * @param horizontal
	 *            boolean type to represent ship in array horizontally
	 * @param ocean
	 *            the Ocean which contains the ship
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		// Checking that space has present over there
		if (okToPlaceShipAt(row, column, horizontal, ocean)) {

			// Setting position
			setBowColumn(column);
			setBowRow(row);
			setHorizontal(horizontal);

			// Setting reference of this class on that array
			for (int i = 0; i < getLength(); i++) {
				if (horizontal)
					ocean.getShipArray()[row][column + i] = this;
				else
					ocean.getShipArray()[row + i][column] = this;
			}
		}
	}

	/**
	 * 
	 * @param row
	 *            the point of location of SHip in row
	 * @param column
	 *            the point of location of ship in column
	 * @return true if shoot posible else false
	 */
	public boolean shootAt(int row, int column) {
		// if ship is horizontally presents then
		if (isHorizontal()) {
			// Checking that row is same as the ship and column is less the ship
			// size
			if (this.bowRow == row && column < (this.bowColumn + this.length)
					&& !isSunk()) {
				hit[column - bowColumn] = true;
				return true;
			} else {
				return false;
			}
		} else {
			if (this.bowColumn == column && row < (this.bowRow + this.length)
					&& !isSunk()) {
				hit[row - bowRow] = true;
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 
	 * @return True is ship is sunk else return false.
	 */
	public boolean isSunk() {
		for (int i = 0; i < getLength(); i++) {
			if (!hit[i])
				return false;
		}
		return true;
	}

}
