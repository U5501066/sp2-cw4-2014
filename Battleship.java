public class Battleship extends Ship {

	public Battleship() {
		this.length = 4;
		for (int i = 0; i < length; i++)
			hit[i] = false;
	}

	@Override
	public String getShipType() {
		return "battleship";
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String toString(int x) {
		if ( isSunk()){
			return "x";
		}
		if ( isHorizontal() ){
			if ( hit[x-getBowColumn()] ){
				return "S";
			}
		}else{
			if ( hit[x-getBowRow()] ){
				return "S";
			}
		}
		return ".";
	}
}
