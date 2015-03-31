package jpa;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mozdony {

	@Id
	private int id;    
    private int futottkm;
    @ManyToOne
	private Tipus tipus;
    @OneToMany(mappedBy = "mozdony", fetch = FetchType.EAGER)
    private Collection<Vonat> vonatok;
    
    public Mozdony() {
    }
     
    public Mozdony(int mozdonyID, int futottkmINT, Tipus t) {
    	this.id = mozdonyID;
    	this.futottkm = futottkmINT;
    	this.tipus = t;
    }
     
    public Tipus getTipus() {
		return tipus;
	}

	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}
	
	public void setId(int id) {
		this.id = id;
	}

    public int getFutottkm() {
        return futottkm;
    }

    public void setFutottkm(int futottkm) {
        this.futottkm = futottkm;
    }

	public int getId() {
    	return id;
	}
	 @Override
    public String toString() {
        return id + " " + tipus.getAzonosito() + " " + futottkm;
    }

    public Collection<Vonat> getVonatok() {
        return vonatok;
    }

    public void setVonatok(Collection<Vonat> vonatok) {
        this.vonatok = vonatok;
    }

}
