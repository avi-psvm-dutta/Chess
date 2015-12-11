package com.catch22.chess.data;

import com.catch22.chess.gui.Console;
import com.catch22.chess.pieces.*;

import javax.swing.*;
import java.awt.*;

public class Board
{
	private static Piece[][] board = new Piece[8][8];

	public Board()
	{
		for(int x = 0; x < 8; x++)
		{
			if(x == 0 || x == 7)
			{
				board[x][0] = new Rook(x, 1, Color.white);
				board[x][7] = new Rook(x, 7, Color.black);
			}
			if(x == 2 || x == 5)
			{
				board[x][0] = new Bishop(x, 1, Color.white);
				board[x][7] = new Bishop(x, 7, Color.black);
			}
			if(x == 1 || x == 6)
			{
				board[x][0] = new Knight(x, 1, Color.white);
				board[x][7] = new Knight(x, 7, Color.black);
			}
			if(x == 4)
			{
				board[x][0] = new King(x, 1, Color.white);
				board[x][7] = new Queen(x, 7, Color.black);
			}
			if(x == 3)
			{
				board[x][0] = new Queen(x, 1, Color.white);
				board[x][7] = new King(x, 7, Color.black);
			}
			board[x][6] = new Pawn(x, 6, Color.black);
			board[x][1] = new Pawn(x, 1, Color.white);
		}
	}

	public static void setSquare(Piece soldier, int x, int y)
	{
		board[x][y] = soldier;
	}

	public static Piece getSquare(int x, int y)
	{
		return board[x][y];
	}

	public static void paint(Console window)
	{
		for(int y = 7; y > -1; y--)
			for(int x = 0; x < 8; x++)
			{
				String content = null;
				try
				{
					content = Board.getSquare(x, y).getName();
				}
				catch (NullPointerException emptySquare)
				{
					content = "Empty";
				}
				window.squares[x][7 - y].removeAll();
				window.squares[x][7 - y].add(new JLabel(content));
			}
	}

	public static void swap(int x1, int y1, int x2, int y2)
	{
		Piece square1 = getSquare(x1, y1);
		Piece square2 = getSquare(x1, y1);
		Piece temp = getSquare(x1, y1);
		square1 = square2;
		square2 = temp;
	}
}