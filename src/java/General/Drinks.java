/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonte
 */
@Entity
@Table(name = "DRINKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drinks.findAll", query = "SELECT d FROM Drinks d")
    , @NamedQuery(name = "Drinks.findByDrinkId", query = "SELECT d FROM Drinks d WHERE d.drinkId = :drinkId")
    , @NamedQuery(name = "Drinks.findByDrinkName", query = "SELECT d FROM Drinks d WHERE d.drinkName = :drinkName")
    , @NamedQuery(name = "Drinks.findByDrinkType", query = "SELECT d FROM Drinks d WHERE d.drinkType = :drinkType")
    , @NamedQuery(name = "Drinks.findByDrinkCategory", query = "SELECT d FROM Drinks d WHERE d.drinkCategory = :drinkCategory")
    , @NamedQuery(name = "Drinks.findByDrinkPrice", query = "SELECT d FROM Drinks d WHERE d.drinkPrice = :drinkPrice")})
public class Drinks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DRINK_ID")
    private Integer drinkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "DRINK_NAME")
    private String drinkName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "DRINK_TYPE")
    private String drinkType;
    @Size(max = 25)
    @Column(name = "DRINK_CATEGORY")
    private String drinkCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DRINK_PRICE")
    private int drinkPrice;

    public Drinks() {
    }

    public Drinks(Integer drinkId) {
        this.drinkId = drinkId;
    }

    public Drinks(Integer drinkId, String drinkName, String drinkType, int drinkPrice) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.drinkPrice = drinkPrice;
    }

    public Integer getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Integer drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkCategory() {
        return drinkCategory;
    }

    public void setDrinkCategory(String drinkCategory) {
        this.drinkCategory = drinkCategory;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drinkId != null ? drinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drinks)) {
            return false;
        }
        Drinks other = (Drinks) object;
        if ((this.drinkId == null && other.drinkId != null) || (this.drinkId != null && !this.drinkId.equals(other.drinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "General.Drinks[ drinkId=" + drinkId + " ]";
    }
    
}
