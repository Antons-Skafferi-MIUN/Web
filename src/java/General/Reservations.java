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
 * @author mahl1400
 */
@Entity
@Table(name = "RESERVATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r")
    , @NamedQuery(name = "Reservations.findByReservationId", query = "SELECT r FROM Reservations r WHERE r.reservationId = :reservationId")
    , @NamedQuery(name = "Reservations.findByReservationName", query = "SELECT r FROM Reservations r WHERE r.reservationName = :reservationName")
    , @NamedQuery(name = "Reservations.findByReservationPhone", query = "SELECT r FROM Reservations r WHERE r.reservationPhone = :reservationPhone")
    , @NamedQuery(name = "Reservations.findByReservationDate", query = "SELECT r FROM Reservations r WHERE r.reservationDate = :reservationDate")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESERVATION_ID")
    private Integer reservationId;
    @Size(max = 255)
    @Column(name = "RESERVATION_NAME")
    private String reservationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RESERVATION_PHONE")
    private String reservationPhone;
    @Column(name = "RESERVATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;
    @JoinColumn(name = "TABLE_ID", referencedColumnName = "TABLE_ID")
    @ManyToOne(optional = false)
    private RestaurantTables tableId;

    public Reservations() {
    }

    public Reservations(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Reservations(Integer reservationId, String reservationPhone) {
        this.reservationId = reservationId;
        this.reservationPhone = reservationPhone;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationPhone() {
        return reservationPhone;
    }

    public void setReservationPhone(String reservationPhone) {
        this.reservationPhone = reservationPhone;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public RestaurantTables getTableId() {
        return tableId;
    }

    public void setTableId(RestaurantTables tableId) {
        this.tableId = tableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "General.Reservations[ reservationId=" + reservationId + " ]";
    }
    
}
