package jpa;

import org.junit.*;

public class TipusTest extends CommonTest {

	    @Test
	    public void test_T1() throws Exception {
	        System.out.println("\n---test_T1---");
	        //inputText
	        StringBuilder inputText = new StringBuilder();
	        inputText.append("t t1 goz\n");
	        inputText.append("t t2 villany\n");
	        inputText.append("t t3 diesel\n");
	        inputText.append("l t\n");
	        inputText.append("e\n");


	        //expectedOutputText
	        StringBuilder expectedOutputText = new StringBuilder();
	        expectedOutputText.append(">>>>t1 goz\n");
	        expectedOutputText.append("t2 villany\n");
	        expectedOutputText.append("t3 diesel\n");
	        expectedOutputText.append(">\n");


	        //start test
	        consoleTest(expectedOutputText.toString(), inputText.toString());
	    }	
	    @Test
	    public void test_T2() throws Exception {
	        System.out.println("\n---test_T2---");

	        //inputText
	        StringBuilder inputText = new StringBuilder();
	        inputText.append("t t1 goz\n");
	        inputText.append("t t2 villany\n");
	        inputText.append("t t2 villany\n");
	        inputText.append("e\n");


	        //expectedOutputText
	        StringBuilder expectedOutputText = new StringBuilder();
	        expectedOutputText.append(">>>?\n");
	        expectedOutputText.append(">\n");


	        //start test
	        consoleTest(expectedOutputText.toString(), inputText.toString());
	    }
}
