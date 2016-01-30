package PR6;

import java.util.*;

import princeton.lib.*;

public class Point2D {
	final int x;

	final int y;

	public final Comparator<Point2D> POLAR_ORDER = new PolarOrder(this);

	public Point2D(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public static int ccw(Point2D a, Point2D b, Point2D c) 
	{
		return (int) Math.signum(((b.x - a.x) * (c.y - a.y))
				- ((b.y - a.y) * (c.x - a.x)));
	}

	public boolean equals(Object other) 
	{
		return super.equals(other);
	}

	public boolean equals(Point2D other) 
	{
		return (this.x == other.x && this.y == other.y);
	}

	public String toString() 
	{
		return x + " " + y;
	}

	public void draw() 
	{
		StdDraw.point(x, y);
	}

	public void drawTo(Point2D that) 
	{
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	/*
	 * public int compareTo(Point2D that) {
	 * 
	 * }
	 */

	private class PolarOrder implements Comparator<Point2D> 
	{

		private Point2D p;

		public PolarOrder(Point2D point2d) 
		{
			p = point2d;
		}

		@Override
		public int compare(Point2D q1, Point2D q2) 
		{
			if ((q1.y > p.y) && (q2.y < p.y))
				return -1;
			if ((q1.y < p.y) && (q2.y > p.y))
				return 1;
			int ccw=ccw(p, q1, q2);
			if(ccw==0)
				if(p.y==q1.y)
					if(q1.x<q2.x)
						return -1;
					else
						return 0;
				else
					if(q1.y<q2.y)
						return -1;
					else
						return 0;
			return ccw;
		}

	}
}
