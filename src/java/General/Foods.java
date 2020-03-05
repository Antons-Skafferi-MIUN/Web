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
@Table(name = "FOODS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f")
    , @NamedQuery(name = "Foods.findByFoodId", query = "SELECT f FROM Foods f WHERE f.foodId = :foodId")
    , @NamedQuery(name = "Foods.findByFoodName", query = "SELECT f FROM Foods f WHERE f.foodName = :foodName")
    , @NamedQuery(name = "Foods.findByFoodPrice", query = "SELECT f FROM Foods f WHERE f.foodPrice = :foodPrice")
    , @NamedQuery(name = "Foods.findByFoodCategory", query = "SELECT f FROM Foods f WHERE f.foodCategory = :foodCategory")})
public class Foods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOOD_ID")
    private Integer foodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOOD_PRICE")
    private int foodPrice;
    @Size(max = 25)
    @Column(name = "FOOD_CATEGORY")
    private String foodCategory;

    public Foods() {
    }

    public Foods(Integer foodId) {
        this.foodId = foodId;
    }

    public Foods(Integer foodId, String foodName, int foodPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "General.Foods[ foodId=" + foodId + " ]";
    }
    
}
