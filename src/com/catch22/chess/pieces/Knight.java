package com.catch22.chess.pieces;

import com.catch22.chess.data.Board;

import java.awt.*;

public class Knight extends Piece
{
	@Override
	public boolean move(int finalX, int finalY)
	{
		//contains the piece which is in the position that the current piece is trying to move to
		//can be null
		Piece finalSquare = Board.getSquare(finalX, finalY);

		//checks if not jumping on a piece of my own / something is obstructing path of movement / etc
		if(!basicMoveChecks(finalSquare, getName()))
			return false;

		//illegal move
		if(finalX != x - 2 && finalX != x + 2 || finalY != y - 2 && finalY != y + 2)
			return false;

		try
		{
			finalSquare.kill();
		}
		catch (NullPointerException squareEmpty)
		{

		}
		x = finalX;
		y = finalY;

		Board.swap(x, y, finalX, finalY);

		return true;
	}

	public Knight(int x, int y, Color c)
	{
		super(x, y, c);
	}
}