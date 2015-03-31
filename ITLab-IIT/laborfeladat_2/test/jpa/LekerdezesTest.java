package jpa;

import org.junit.*;

public class LekerdezesTest extends CommonTest {

    //Az előírt követelményeknek megfelelően visszaadja az eredményt, ha helyes formátumú a bemenet.
    @Test
    public void test_L1() throws Exception {
        System.out.println("\n---test_L1---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("m 12 t1 200\n");
        inputText.append("m 13 t1 300\n");
        inputText.append("m 21 t2 400\n");
        inputText.append("m 22 t2 500\n");
        inputText.append("m 23 t2 600\n");
        inputText.append("m 31 t3 700\n");
        inputText.append("m 32 t3 800\n");
        inputText.append("m 33 t3 900\n");
        inputText.append("m 34 t3 1000\n");
        inputText.append("s 0061 210\n");
        inputText.append("s 0062 230\n");
        inputText.append("s 0063 240\n");
        inputText.append("s 0071 103\n");
        inputText.append("s 0072 103\n");
        inputText.append("s 0073 103\n");
        inputText.append("s 0081 166\n");
        inputText.append("s 0082 166\n");
        inputText.append("s 0091 112\n");
        inputText.append("s 0092 112\n");
        inputText.append("s 0093 112\n");
        inputText.append("s 0101 200\n");
        inputText.append("s 0102 200\n");
        inputText.append("v 0061 2003.09.03 12 10\n");
        inputText.append("v 0071 2003.10.03 31 10\n");
        inputText.append("v 0102 2003.09.03 22 10\n");
        inputText.append("v 0073 2003.10.03 23 10\n");
        inputText.append("v 0092 2003.09.03 11 10\n");
        inputText.append("v 0093 2003.10.03 31 10\n");
        inputText.append("v 0082 2003.09.03 21 10\n");
        inputText.append("v 0101 2003.09.03 33 10\n");
        inputText.append("v 0081 2003.10.03 22 10\n");
        inputText.append("v 0073 2003.09.03 32 10\n");
        inputText.append("v 0063 2003.10.03 21 10\n");
        inputText.append("v 0091 2003.09.03 21 10\n");
        inputText.append("v 0062 2003.09.03 13 10\n");
        inputText.append("x 2003.09.03\n");
        inputText.append("x 2003.10.03\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>diesel 303\n");
        expectedOutputText.append("goz 552\n");
        expectedOutputText.append("villany 478\n");
        expectedOutputText.append(">diesel 215\n");
        expectedOutputText.append("villany 509\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Hibajelzést küld, ha nem az előírt formátumban (év.hó.nap) lett megadva a dátum.
    @Test
    public void test_L2() throws Exception {
        System.out.println("\n---test_L2---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("m 12 t1 200\n");
        inputText.append("m 13 t1 300\n");
        inputText.append("m 21 t2 400\n");
        inputText.append("m 22 t2 500\n");
        inputText.append("m 23 t2 600\n");
        inputText.append("m 31 t3 700\n");
        inputText.append("m 32 t3 800\n");
        inputText.append("m 33 t3 900\n");
        inputText.append("m 34 t3 1000\n");
        inputText.append("s 0061 210\n");
        inputText.append("s 0062 230\n");
        inputText.append("s 0063 240\n");
        inputText.append("s 0071 103\n");
        inputText.append("s 0072 103\n");
        inputText.append("s 0073 103\n");
        inputText.append("s 0081 166\n");
        inputText.append("s 0082 166\n");
        inputText.append("s 0091 112\n");
        inputText.append("s 0092 112\n");
        inputText.append("s 0093 112\n");
        inputText.append("s 0101 200\n");
        inputText.append("s 0102 200\n");
        inputText.append("v 0061 2003.09.03 12 10\n");
        inputText.append("v 0071 2003.10.03 31 10\n");
        inputText.append("v 0102 2003.09.03 22 10\n");
        inputText.append("v 0073 2003.10.03 23 10\n");
        inputText.append("v 0092 2003.09.03 11 10\n");
        inputText.append("v 0093 2003.10.03 31 10\n");
        inputText.append("v 0082 2003.09.03 21 10\n");
        inputText.append("v 0101 2003.09.03 33 10\n");
        inputText.append("v 0081 2003.10.03 22 10\n");
        inputText.append("v 0073 2003.09.03 32 10\n");
        inputText.append("v 0063 2003.10.03 21 10\n");
        inputText.append("v 0091 2003.09.03 21 10\n");
        inputText.append("v 0062 2003.09.03 13 10\n");
        inputText.append("x abc\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }
}
