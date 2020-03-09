/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonte
 */
@Entity
@Table(name = "PERSONNEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p")
    , @NamedQuery(name = "Personnel.findByPersonnelId", query = "SELECT p.personnelName FROM Personnel p WHERE p.personnelId = :personnelId")
    , @NamedQuery(name = "Personnel.findByPersonnelName", query = "SELECT p FROM Personnel p WHERE p.personnelName = :personnelName")
    , @NamedQuery(name = "Personnel.findByPersonnelPhone", query = "SELECT p FROM Personnel p WHERE p.personnelPhone = :personnelPhone")
    , @NamedQuery(name = "Personnel.findByPersonnelType", query = "SELECT p FROM Personnel p WHERE p.personnelType = :personnelType")})
public class Personnel implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnelId")
    private List<Shifts> shiftsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONNEL_ID")
    private Integer personnelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PERSONNEL_NAME")
    private String personnelName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PERSONNEL_PHONE")
    private String personnelPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PERSONNEL_TYPE")
    private String personnelType;

    public Personnel() {
    }

    public Personnel(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public Personnel(Integer personnelId, String personnelName, String personnelPhone, String personnelType) {
        this.personnelId = personnelId;
        this.personnelName = personnelName;
        this.personnelPhone = personnelPhone;
        this.personnelType = personnelType;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getPersonnelPhone() {
        return personnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        this.personnelPhone = personnelPhone;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personnelId != null ? personnelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.personnelId == null && other.personnelId != null) || (this.personnelId != null && !this.personnelId.equals(other.personnelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return personnelId.toString();
    }

    @XmlTransient
    public List<Shifts> getShiftsList() {
        return shiftsList;
    }

    public void setShiftsList(List<Shifts> shiftsList) {
        this.shiftsList = shiftsList;
    }
    
}
