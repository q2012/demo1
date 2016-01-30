package PR6;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import princeton.lib.StdIn;


public class ConvexHullTest
{
	@Test
	public void test1() throws FileNotFoundException
	{ 
		ConvexHull.run("Data/horizontal100.txt");
		StdIn.readInt();
	}
	
/*	@Test
	public void test2() throws FileNotFoundException
	{ 
		ConvexHull.run("Data/input100.txt");
		StdIn.readInt();
	}*/
	
/*	@Test
	public void test3() throws FileNotFoundException
	{ 
		ConvexHull.run("Data/input56.txt");
		StdIn.readInt();
	}*/
	
/*	@Test
	public void test4() throws FileNotFoundException
	{ 
		ConvexHull.run("Data/input50.txt");
		StdIn.readInt();
	}*/
	
/*	@Test
	public void test5() throws FileNotFoundException
	{ 
		ConvexHull.run("Data/input8.txt");
		StdIn.readInt();
	}*/
}
