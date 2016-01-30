package PR6;

import java.awt.Color;
import java.io.*;
import java.util.*;


import princeton.lib.*;

public class ConvexHull 
{
	private static String filename;
	static Point2D[] points;
	static List<Point2D> marsh=new LinkedList<Point2D>();
	static final double EPS=1e-7;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		run("Data/input100.txt");
		StdIn.readInt();
	}
	
	
	public static void run(final String fn) throws FileNotFoundException
	{
		ConvexHull.filename=fn;
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		StdDraw.setPenRadius(0.01);
		readFile();
		
		Point2D p = points[lowRight()];		
		
//		StdOut.println(p+"&&");
		p.draw();
		
		Point2D[] temp=new Point2D[points.length-1];
		for(int i=0,k=0;i<temp.length;k++)
		{
			if(points[k]==p)
				continue;
			temp[i]=points[k];
			i++;
		}
		points=temp;
		
		Arrays.sort(points,p.POLAR_ORDER);
		
		for(Point2D k: points)
		{
			StdOut.println(k);
			k.draw();
			StdDraw.show(1);
		}
		
		drawLines(p);
		
	}
	
	private static void readFile() throws FileNotFoundException
	{
		
		Scanner in = new Scanner(new File(filename));
		points=new Point2D[in.nextInt()];
		
		for(int i=0;i<points.length;i++)
			points[i]=new Point2D(in.nextInt(),in.nextInt());
	}
	
	private static void drawLines(final Point2D p)
	{
		Point2D q1=points[0];
		Point2D q2=points[1];
		marsh.add(p);
		marsh.add(q1);
		marsh.add(q2);
		for(int i=2;i<points.length;i++)
		{
			while(Math.signum(Point2D.ccw(q1,q2,points[i]))!=-1 && marsh.size()>2)
			{
				q2=q1;
				q1=marsh.get(marsh.size()-3);
				marsh.remove(marsh.size()-1);
			}
			marsh.add(points[i]);
			q1=q2;
			q2=points[i];
//			q1.drawTo(q2);
		}
		
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.setPenRadius(0.011);
		
		marsh.add(p);
		for(int i=1;i<marsh.size();i++)
		{
			marsh.get(i-1).drawTo(marsh.get(i));
			StdDraw.show(100);
		}
//		marsh.get(marsh.size()-1).drawTo(p);
	}
	
	private static int lowRight()
	{
		int res=0;
		
		for(int i=1;i<points.length;i++)
			
			if((points[i].y<(points[res].y-EPS)) 
					|| (Math.abs(points[i].y-points[res].y)<EPS && (points[i].x>points[res].x)))
				res=i;
		return res;
	}
}
