package com.catch22.chess.pieces;

import com.catch22.chess.data.Board;

import java.awt.*;

public class Queen extends Piece
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

		boolean movingForward = finalX == x;
		boolean movingSideways = finalY == y;
		boolean movingLeftSkew = finalX + finalY == x + y; //(like this /)
		boolean movingRightSkew = finalX - finalY == x - y; //(like this \)

//		//illegal move
		if(!movingForward && !movingSideways && !movingLeftSkew && !movingRightSkew)
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

	public Queen(int x, int y, Color c)
	{
		super(x, y, c);
	}
}