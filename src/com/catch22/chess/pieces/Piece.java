package com.catch22.chess.pieces;

import java.awt.*;

public abstract class Piece
{
	public Color color;
	public int x, y; //0, 0 is the bottom left of the chess-board

	public Piece(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public boolean isAlive = true;

	public void kill()
	{
		isAlive = false;
	}

	public String getName()
	{
		return getClass().getName().substring("com.catch22.chess.pieces.".length());
	}

	//returns whether move was successful or not
	public abstract boolean move(int finalX, int finalY); //move to (finalX, finalY)

	///checks if move is legal, steps common to all pieces
	protected boolean basicMoveChecks(Piece finalSquare, String pieceName)
	{
		//check if no other piece is obstructing the path from the final position to the initial position
		if(!"Knight".equals(pieceName)) //can skip this if it's a Knight, because Knights can jump objects
		{

		}

		try
		{
			//check if not jumping on a piece of my own
			if (color.equals(finalSquare.color))
				return false;
		} catch(NullPointerException squareEmpty)
		{

		}

		return true;
	}
}