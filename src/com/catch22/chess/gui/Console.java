package com.catch22.chess.gui;

import com.catch22.chess.data.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Console extends JFrame
{
	private static final int width = 640, height = 640;

	public static JPanel[][] squares = new JPanel[8][8];

	public Console()
	{
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridLayout(8, 8));

		for(int y = 0; y < 8; y++)
		{
			for(int x = 0; x < 8; x++)
			{
				squares[x][y] = new JPanel();
				JPanel square = squares[x][y];
				square.addMouseListener(new Mover(x, 7 - y));
				square.setBackground((x + y) % 2 != 0 ? Color.black : Color.white);
				add(square);
			}
		}
		pack();
	}

	private static class Mover extends MouseAdapter
	{
		public boolean moveSuccessful;

		public Mover(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		private int x, y;

		@Override
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("clicked " + x + " " + y);
		}

		public void move()
		{

		}
	}
}