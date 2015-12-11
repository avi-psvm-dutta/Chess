package com.catch22.chess.pieces;

import com.catch22.chess.data.Board;

import java.awt.*;

public class Pawn extends Piece
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
		boolean movingDiagonally = (finalX == x + 1 || finalX == x - 1) && finalY == y + 1;

		//illegal move
		if(!movingDiagonally && !movingForward)
			return false;

		if(movingForward)
		{
			//already occupied
			if(Board.getSquare(finalX, finalY) != null)
				return false;

			y++; //advance the piece
			return true;
		}

		//moving diagonally
		if(finalSquare != null)
			finalSquare.kill();

		y = finalY;
		x = finalX;

		Board.swap(x, y, finalX, finalY);

		return true;
	}

	public Pawn(int x, int y, Color c)
	{
		super(x, y, c);
	}

//	@Override
//	public String getName()
//	{
//		return super.getName();
//	}
}