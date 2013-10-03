package org.easycassandra.samples.javaee.rest.api;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author otaviojava
 */
@XmlRootElement
@Entity
public class CostUnit implements Serializable{
        
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private String city;
    
	@Column
    private String address;
    
	@Column
    private String neighborhood;
	
	@Column
    private String state;
    
	@Column
    private Double value;
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    @Override
    public String toString() {
    
    	return neighborhood+city +" - "+state+" R$ "+value;
    }
    
     public static CostUnit valueof(String[] strings) {
        CostUnit controle = new CostUnit();
        controle.setCity(strings[0]);
        controle.setAddress(strings[1]);
        controle.setNeighborhood(strings[2]);
        controle.setState(strings[3]);
        controle.setValue(new Double(strings[4]));

        return controle;
    }
}
