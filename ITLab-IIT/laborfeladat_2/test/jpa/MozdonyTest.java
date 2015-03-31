package jpa;

import org.junit.*;

public class MozdonyTest extends CommonTest {

    //Feltételeknek (a megjelölt típus létezik, a sorszám egész szám, a futottkm egész szám, az azonosító ("típus"+"sorszám") egyedi) megfelelő példány rögzítésre kerül.
    @Test
    public void test_M1() throws Exception {
        System.out.println("\n---test_M1---");

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
        inputText.append("l m\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>>>>>>>>>11 t1 100\n");
        expectedOutputText.append("12 t1 200\n");
        expectedOutputText.append("13 t1 300\n");
        expectedOutputText.append("21 t2 400\n");
        expectedOutputText.append("22 t2 500\n");
        expectedOutputText.append("23 t2 600\n");
        expectedOutputText.append("31 t3 700\n");
        expectedOutputText.append("32 t3 800\n");
        expectedOutputText.append("33 t3 900\n");
        expectedOutputText.append("34 t3 1000\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre már korábban rögzített azonosítóval ("típus"+"sorszám") új példány. Hibaüzenettel jelzi.
    @Test
    public void test_M2() throws Exception {
        System.out.println("\n---test_M2---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("m 12 t1 200\n");
        inputText.append("m 12 t1 200\n");
        inputText.append("e\n");


        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>?\n");
        expectedOutputText.append(">\n");


        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem létező "típussal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_M3() throws Exception {
        System.out.println("\n---test_M3---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m 11 t8 100\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem egész szám "sorszámmal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_M4() throws Exception {
        System.out.println("\n---test_M4---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m abc t1 100\n");
        inputText.append("m 1.1 t1 100\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem egész szám "futottkm"-mel példány. Hibaüzenettel jelzi.
    @Test
    public void test_M5() throws Exception {
        System.out.println("\n---test_M5---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("t t2 villany\n");
        inputText.append("t t3 diesel\n");
        inputText.append("m 11 t1 abc\n");
        inputText.append("m 11 t1 1.1\n");
        inputText.append("e\n");


        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }
}
