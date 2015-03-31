package jpa;

public class CommonData {

	private static final String PERSISTENCE_UNIT_NAME = "pineappledb";
	private static final String DBASE_DIRECTORY = "c:\\Users\\Gog\\Google Drive\\6.felev\\ITlab\\IIT1\\laborfeladat2\\";

	public static String getDir() {
		return DBASE_DIRECTORY;
	}
	public static String getUnit() {
		return PERSISTENCE_UNIT_NAME;
	}

}
