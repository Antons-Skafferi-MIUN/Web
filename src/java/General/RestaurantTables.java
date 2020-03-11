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
 * @author mahl1400
 */
@Entity
@Table(name = "RESTAURANT_TABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestaurantTables.findAll", query = "SELECT r FROM RestaurantTables r")
    , @NamedQuery(name = "RestaurantTables.findByTableId", query = "SELECT r FROM RestaurantTables r WHERE r.tableId = :tableId")
    , @NamedQuery(name = "RestaurantTables.findByTableTotalSeats", query = "SELECT r FROM RestaurantTables r WHERE r.tableTotalSeats = :tableTotalSeats")
    , @NamedQuery(name = "RestaurantTables.findByTableAvailableSeats", query = "SELECT r FROM RestaurantTables r WHERE r.tableAvailableSeats = :tableAvailableSeats")
    , @NamedQuery(name = "RestaurantTables.findByTableStatus", query = "SELECT r FROM RestaurantTables r WHERE r.tableStatus = :tableStatus")})
public class RestaurantTables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLE_ID")
    private Integer tableId;
    @Column(name = "TABLE_TOTAL_SEATS")
    private Integer tableTotalSeats;
    @Column(name = "TABLE_AVAILABLE_SEATS")
    private Integer tableAvailableSeats;
    @Size(max = 25)
    @Column(name = "TABLE_STATUS")
    private String tableStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableId")
    private List<Reservations> reservationsList;

    public RestaurantTables() {
    }

    public RestaurantTables(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableTotalSeats() {
        return tableTotalSeats;
    }

    public void setTableTotalSeats(Integer tableTotalSeats) {
        this.tableTotalSeats = tableTotalSeats;
    }

    public Integer getTableAvailableSeats() {
        return tableAvailableSeats;
    }

    public void setTableAvailableSeats(Integer tableAvailableSeats) {
        this.tableAvailableSeats = tableAvailableSeats;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    @XmlTransient
    public List<Reservations> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservations> reservationsList) {
        this.reservationsList = reservationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableId != null ? tableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantTables)) {
            return false;
        }
        RestaurantTables other = (RestaurantTables) object;
        if ((this.tableId == null && other.tableId != null) || (this.tableId != null && !this.tableId.equals(other.tableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tableId + " ";
    }
    
}
