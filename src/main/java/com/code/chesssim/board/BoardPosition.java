
package com.code.chesssim.board;

/**
 * Immutable class representing a position on board using row and col semantics
 * 
 * @author Alf
 *
 */
public final class BoardPosition {

	private final int row;
	private final int col;

	public BoardPosition(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardPosition other = (BoardPosition) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardPosition [row=" + row + ", col=" + col + "]";
	}

}
