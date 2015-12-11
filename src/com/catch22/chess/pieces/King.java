package com.catch22.chess.pieces;

import com.catch22.chess.data.Board;

import java.awt.*;

public class King extends Piece
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

		boolean movingForward = finalX == x && finalY == y + 1;
		boolean movingBackward = finalX == x && finalY == y - 1;
		boolean movingUpLeft = finalX == x - 1 && finalY == y + 1;
		boolean movingUpRight = finalX == x + 1 && finalY == y + 1;
		boolean movingDownLeft = finalX == x - 1 && finalY == y - 1;
		boolean movingLeft = finalX == x - 1 && finalY == y;
		boolean movingRight = finalX == x + 1 && finalY == y;

//		//illegal move
		if(!movingForward && !movingBackward && !movingUpLeft && !movingUpRight && !movingDownLeft && !movingLeft && !movingRight)
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

	public King(int x, int y, Color c)
	{
		super(x, y, c);
	}
}