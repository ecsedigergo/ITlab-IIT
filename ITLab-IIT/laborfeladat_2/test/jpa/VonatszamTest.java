package jpa;

import org.junit.*;

public class VonatszamTest extends CommonTest {

    //Feltételeknek (a "szám" egész szám, az "úthossz" egész szám, az azonosító ("szám") egyedi) megfelelő példány rögzítésre kerül.
    @Test
    public void test_S1() throws Exception {
        System.out.println("\n---test_S1---");

        //inputText
        StringBuilder inputText = new StringBuilder();
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
        inputText.append("l s\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>>>>>>>>>61 210\n");
        expectedOutputText.append("62 230\n");
        expectedOutputText.append("63 240\n");
        expectedOutputText.append("71 103\n");
        expectedOutputText.append("72 103\n");
        expectedOutputText.append("73 103\n");
        expectedOutputText.append("81 166\n");
        expectedOutputText.append("82 166\n");
        expectedOutputText.append("91 112\n");
        expectedOutputText.append("92 112\n");
        expectedOutputText.append("93 112\n");
        expectedOutputText.append("101 200\n");
        expectedOutputText.append("102 200\n");
        expectedOutputText.append(">\n");


        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre már korábban rögzített azonosítóval ("szám") új példány. Hibaüzenettel jelzi.
    @Test
    public void test_S2() throws Exception {
        System.out.println("\n---test_S2---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("s 0061 210\n");
        inputText.append("s 0062 230\n");
        inputText.append("s 0063 240\n");
        inputText.append("s 0063 240\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">\n");


        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem egész szám "számmal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_S3() throws Exception {
        System.out.println("\n---test_S3---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("s 0061 210\n");
        inputText.append("s 0062 230\n");
        inputText.append("s abc 240\n");
        inputText.append("s 1.1 240\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>?\n");
        expectedOutputText.append(">?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem egész szám "úthosszal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_S4() throws Exception {
        System.out.println("\n---test_S4---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("s 0061 210\n");
        inputText.append("s 0062 230\n");
        inputText.append("s 0063 abc\n");
        inputText.append("s 0064 1.1\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>?\n");
        expectedOutputText.append(">?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }
}
