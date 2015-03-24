public class EmptySea extends Ship {

	public EmptySea() {
		this.length = 1;
		hit[0] = false;
	}

	public boolean shootAt(int row, int column) {
		hit[0] = true;
		return false;
	}

	public boolean isSunk() {
		return false;
	}

	@Override
	public String getShipType() {
		return "empty";
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String toString(int x) {
		if ( !hit[0] )
			return ".";
		return "-";
	}

}
