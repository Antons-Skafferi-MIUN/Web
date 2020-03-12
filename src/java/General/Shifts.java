/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonte
 */
@Entity
@Table(name = "SHIFTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shifts.findAll", query = "SELECT s FROM Shifts s")
    , @NamedQuery(name = "Shifts.findByShiftId", query = "SELECT s FROM Shifts s WHERE s.shiftId = :shiftId")
    , @NamedQuery(name = "Shifts.findByShiftDate", query = "SELECT s FROM Shifts s WHERE s.shiftDate = :shiftDate")
    , @NamedQuery(name = "Shifts.findByShiftDateOrder", query = "SELECT s FROM Shifts s ORDER BY s.shiftDate DESC")
    , @NamedQuery(name = "Shifts.findByShiftType", query = "SELECT s FROM Shifts s WHERE s.shiftType = :shiftType")})
public class Shifts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SHIFT_ID")
    private Integer shiftId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHIFT_DATE")
    @Temporal(TemporalType.DATE)
    private Date shiftDate;
    @Size(max = 25)
    @Column(name = "SHIFT_TYPE")
    private String shiftType;
    @JoinColumn(name = "PERSONNEL_ID", referencedColumnName = "PERSONNEL_ID")
    @ManyToOne(optional = false)
    private Personnel personnelId;

    public Shifts() {
    }

    public Shifts(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Shifts(Integer shiftId, Date shiftDate) {
        this.shiftId = shiftId;
        this.shiftDate = shiftDate;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public Personnel getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Personnel personnelId) {
        this.personnelId = personnelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftId != null ? shiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shifts)) {
            return false;
        }
        Shifts other = (Shifts) object;
        if ((this.shiftId == null && other.shiftId != null) || (this.shiftId != null && !this.shiftId.equals(other.shiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "General.Shifts[ shiftId=" + shiftId + " ]";
    }

}
