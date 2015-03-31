package jpa;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Query;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class CommonTest {

	private EntityManagerFactory factory;
	private EntityManager em;	

    @BeforeClass
    public static void setUpClass() throws Exception {
    	deleteDirectory(new File(jpa.CommonData.getDir()));
    }	
	
    @Before
    public void setUp() {
        //Elozmenyek torlese
   	

		factory = Persistence.createEntityManagerFactory(CommonData.getUnit());
		em = factory.createEntityManager();
        em.getTransaction().begin();

		deleteEntity(em.createQuery("SELECT v FROM Vonat v").getResultList());
		deleteEntity(em.createQuery("SELECT s FROM Vonatszam s").getResultList());	
		deleteEntity(em.createQuery("SELECT m FROM Mozdony m").getResultList());	
		deleteEntity(em.createQuery("SELECT t FROM Tipus t").getResultList());	

        em.getTransaction().commit();
    }

    @After
    public void tearDown() {
        if (em != null) {
            em.close();    
        }

    }

    //Tesztelest tamogato metodusok.
    public void consoleTest(String expectedOutputText, String inputText) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(inputText.getBytes("US-ASCII"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        System.setIn(bais);
        System.setOut(new PrintStream(baos));

        Program program = new Program(em);
        program.startControl();

        System.setIn(originalInput);
        System.setOut(originalOutput);

        String outputText = baos.toString("US-ASCII");
        System.out.println(outputText);

        //A kerdojelek utani hibauzenetek levagasa.
        String[] expectedOutputTextArray = expectedOutputText.split("\n");
        String[] outputTextArray = outputText.split("\n");
        assertEquals(expectedOutputTextArray.length, outputTextArray.length);
        for (int i = 0; i < expectedOutputTextArray.length; i++) {
            outputTextArray[i] = outputTextArray[i].trim();
            int index = expectedOutputTextArray[i].indexOf("?");
            if (index > 0) {
                outputTextArray[i] = outputTextArray[i].substring(0, index + 1);
            }
        }
        assertArrayEquals(expectedOutputTextArray, outputTextArray);
    }
	
	
	static public boolean deleteDirectory(File path) {
	    if( path.exists() ) {
	      File[] files = path.listFiles();
	      for(int i=0; i<files.length; i++) {
	         if(files[i].isDirectory()) {
	           deleteDirectory(files[i]);
	         }
	         else {
	           files[i].delete();
	         }
	      }
	    }
	    return( path.delete() );
	}	
	
	public void deleteEntity(List list) {
        for (Object o : list) {
            em.remove(o);
        }
    }
	
	
}
