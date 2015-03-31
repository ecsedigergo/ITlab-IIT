package jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Tipus {

    @Id
    private String azonosito;
    private String fajta;
 
	
    public Tipus() {
    }

    public Tipus(String azonosito, String fajta) {
        this.azonosito = azonosito;
        this.fajta = fajta;
    }

    public String getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) {
        this.azonosito = azonosito;
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }
   
    public String toString() {
    	return new String(azonosito + " " + fajta);
    }
    
}
