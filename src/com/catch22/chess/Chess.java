package com.catch22.chess;

import com.catch22.chess.data.Board;
import com.catch22.chess.gui.Console;

public class Chess
{
	private static Board board;
	private static Console window;

	public static void main(String[] args)
	{
		board = new Board();
		window = new Console();

		Board.paint(window);

		//repaints the board every 100 milliseconds (may not be required)
		new Thread()
		{
			@Override
			public void run()
			{
				while(true)
				{
					try
					{
						sleep(100);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					Board.paint(window);
				}
			}
		}.start();
	}
}
