package lab;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class WhiteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalcShortestPath1() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("1.txt");
		g.calcShortestPath("words", "dogs");
		String expectedOutput = "No dogs in the graph!";
		System.out.flush();
		System.setOut(old);
		assertEquals(expectedOutput, baos.toString().trim());
	}
	
	@Test
	public void testCalcShortestPath2() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("1.txt");
		g.calcShortestPath("is", "test");
		String expectedOutput = "The length of the shortest path is: 2\r\n"
        		+ "The shortest path from is to test is: test <- a <- is";
		System.out.flush();
		System.setOut(old);
		assertEquals(expectedOutput, baos.toString().trim());
	}
	
	@Test
	public void testCalcShortestPath3() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("1.txt");
		g.calcShortestPath("words", "dog");
		String expectedOutput = "No path found from words to dog!";
		System.out.flush();
		System.setOut(old);
		assertEquals(expectedOutput, baos.toString().trim());
	}
	
	@Test
	public void testCalcShortestPath4() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("1.txt");
		g.calcShortestPath("dogs", "words");
		String expectedOutput = "No dogs in the graph!";
		System.out.flush();
		System.setOut(old);
		assertEquals(expectedOutput, baos.toString().trim());
	}
	
	@Test
	public void testCalcShortestPath5() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("2.txt");
		g.calcShortestPath("new", "!");
		String expectedOutput = "No path found from new to new!\r\n"
				+ "The shortest path from new to east : length 1 east <- new\r\n"
				+ "The shortest path from new to world : length 2 world <- east <- new";
		System.out.flush();
		System.setOut(old);
		assertEquals(expectedOutput, baos.toString().trim());
	}

}
