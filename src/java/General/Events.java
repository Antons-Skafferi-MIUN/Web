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
 * @author mahl1400
 */
@Entity
@Table(name = "EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")
    , @NamedQuery(name = "Events.findByEventId", query = "SELECT e FROM Events e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Events.findByEventName", query = "SELECT e FROM Events e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Events.findByEventDate", query = "SELECT e FROM Events e WHERE e.eventDate = :eventDate")
    , @NamedQuery(name = "Events.findByEventDescription", query = "SELECT e FROM Events e WHERE e.eventDescription = :eventDescription")
    , @NamedQuery(name = "Events.findByEventPrice", query = "SELECT e FROM Events e WHERE e.eventPrice = :eventPrice")
    , @NamedQuery(name = "Events.findByEventTime", query = "SELECT e FROM Events e WHERE e.eventTime = :eventTime")
    , @NamedQuery(name = "Events.findByEventImage", query = "SELECT e FROM Events e WHERE e.eventImage = :eventImage")
    , @NamedQuery(name = "Events.findTwoFutureEvents", query = "SELECT e FROM Events e WHERE e.eventDate > CURRENT_DATE ORDER BY e.eventDate")
    , @NamedQuery(name = "Events.findAllReverse", query = "SELECT e FROM Events e ORDER BY e.eventId DESC")})
public class Events implements Serializable {

    @Column(name = "EVENT_EDITABLE")
    private Boolean eventEditable;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EVENT_DATE")
    private String eventDate;
    @Size(max = 100)
    @Column(name = "EVENT_DESCRIPTION")
    private String eventDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENT_PRICE")
    private int eventPrice;
    @Size(max = 5)
    @Column(name = "EVENT_TIME")
    private String eventTime;
    @Size(max = 100)
    @Column(name = "EVENT_IMAGE")
    private String eventImage;

    public boolean isEditable() {
        return eventEditable;
    }

    public void setEditable(boolean editable) {
        this.eventEditable = editable;
    }

    public Events() {
    }

    public Events(Integer eventId) {
        this.eventId = eventId;
    }

    public Events(String eventName, String eventTime, String eventDate, String eventDescription, int eventPrice, String eventImage) {
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventPrice = eventPrice;
        this.eventImage = eventImage;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(int eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Events{" + "eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventDescription=" + eventDescription + ", eventPrice=" + eventPrice + ", eventTime=" + eventTime + ", eventImage=" + eventImage + '}';
    }

    public Boolean getEventEditable() {
        return eventEditable;
    }

    public void setEventEditable(Boolean eventEditable) {
        this.eventEditable = eventEditable;
    }

}
