package lab;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class BlackTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		GraphProcessor g = new GraphProcessor();
		g.generateGraphFromFile("1.txt");
		g.queryBridgeWords("you","me");
		System.out.flush();
		System.setOut(old);
		assertEquals("输入错误，请输入两个单词！", baos.toString().trim());
	}

}
