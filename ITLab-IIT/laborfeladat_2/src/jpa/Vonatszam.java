package jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Vonatszam {

    @Id
    private int szam;
    private Long uthossz;

    
    public Vonatszam() {
    }

    public Vonatszam(int szam, Long uthossz) {
        this.szam = szam;
        this.uthossz = uthossz;
    }

    public int getSzam() {
        return szam;
    }

    public void setSzam(int szam) {
        this.szam = szam;
    }

    public Long getUthossz() {
        return uthossz;
    }

    public void setUthossz(Long uthossz) {
        this.uthossz = uthossz;
    }
    public String toString() {
    	return new String(szam + " " + uthossz);
    }

}
