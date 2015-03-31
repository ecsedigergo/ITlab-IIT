package jpa;

import org.junit.*;

public class VonatTest extends CommonTest {

    //Feltételeknek (a megjelölt "vonatszám" létezik, a megjelölt "mozdony" létezik, a "dátum" év.hó.nap formában lett megadva és értelmes,
    //a "késés" egész szám, az azonosító ("vonatszám"+"dátum") egyedi) megfelelő példány rögzítésre kerül.
    //Nem kerül rögzítésre nem egész szám "úthosszal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_V1() throws Exception {
        System.out.println("\n---test_V1---");

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
        inputText.append("l v\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>61 2003.09.03 12 410 10\n");
        expectedOutputText.append("71 2003.10.03 31 915 10\n");
        expectedOutputText.append("102 2003.09.03 22 866 10\n");
        expectedOutputText.append("73 2003.10.03 23 703 10\n");
        expectedOutputText.append("92 2003.09.03 11 212 10\n");
        expectedOutputText.append("93 2003.10.03 31 915 10\n");
        expectedOutputText.append("82 2003.09.03 21 918 10\n");
        expectedOutputText.append("101 2003.09.03 33 1100 10\n");
        expectedOutputText.append("81 2003.10.03 22 866 10\n");
        expectedOutputText.append("73 2003.09.03 32 903 10\n");
        expectedOutputText.append("63 2003.10.03 21 918 10\n");
        expectedOutputText.append("91 2003.09.03 21 918 10\n");
        expectedOutputText.append("62 2003.09.03 13 530 10\n");
        expectedOutputText.append(">\n");


        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Egy vonat rögzítésekor a hozzá tartozó mozdony "futottkm"-e növekszik az "úthosszal".
    @Test
    public void test_V2() throws Exception {
        System.out.println("\n---test_V2---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("s 0061 210\n");
        inputText.append("l m\n");
        inputText.append("v 0061 2003.09.03 11 10\n");
        inputText.append("l m\n");
        inputText.append("v 0061 2003.09.04 11 15\n");
        inputText.append("l m\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>11 t1 100\n");
        expectedOutputText.append(">>11 t1 310\n");
        expectedOutputText.append(">>11 t1 520\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre már korábban rögzített azonosítóval ("vonatszám"+"dátum") új példány. Hibaüzenettel jelzi.
    @Test
    public void test_V3() throws Exception {
        System.out.println("\n---test_V3---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("s 0061 210\n");
        inputText.append("v 0061 2003.09.03 11 10\n");
        inputText.append("v 0061 2003.09.03 11 10\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>>?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem létező "vonatszámmal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_V4() throws Exception {
        System.out.println("\n---test_V4---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("s 0061 210\n");
        inputText.append("v 0066 2003.09.03 11 10\n");
        inputText.append("e\n");

        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem létező "mozdonnyal" példány. Hibaüzenettel jelzi.
    @Test
    public void test_V5() throws Exception {
        System.out.println("\n---test_V5---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("s 0061 210\n");
        inputText.append("v 0061 2003.09.03 77 10\n");
        inputText.append("e\n");


        //expectedOutputText
        StringBuilder expectedOutputText = new StringBuilder();
        expectedOutputText.append(">>>>?\n");
        expectedOutputText.append(">\n");

        //start test
        consoleTest(expectedOutputText.toString(), inputText.toString());
    }

    //Nem kerül rögzítésre nem egész szám "késéssel" példány. Hibaüzenettel jelzi.
    @Test
    public void test_V6() throws Exception {
        System.out.println("\n---test_V6---");

        //inputText
        StringBuilder inputText = new StringBuilder();
        inputText.append("t t1 goz\n");
        inputText.append("m 11 t1 100\n");
        inputText.append("s 0061 210\n");
        inputText.append("v 0061 2003.09.03 11 abc\n");
        inputText.append("v 0061 2003.09.03 11 1.1\n");
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
