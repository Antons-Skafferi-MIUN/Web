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


@Entity
@Table(name = "LUNCHES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lunches.findAll", query = "SELECT l FROM Lunches l")
    , @NamedQuery(name = "Lunches.findByLunchId", query = "SELECT l FROM Lunches l WHERE l.lunchId = :lunchId")
    , @NamedQuery(name = "Lunches.findByLunchName", query = "SELECT l FROM Lunches l WHERE l.lunchName = :lunchName")
    , @NamedQuery(name = "Lunches.findByLunchWeek", query = "SELECT l FROM Lunches l WHERE l.lunchWeek = :lunchWeek")
    , @NamedQuery(name = "Lunches.findByLunchDay", query = "SELECT l FROM Lunches l WHERE l.lunchDay = :lunchDay")})
public class Lunches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LUNCH_ID")
    private Integer lunchId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LUNCH_NAME")
    private String lunchName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LUNCH_WEEK")
    private int lunchWeek;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LUNCH_DAY")
    private int lunchDay;

    public Lunches() {
    }

    public Lunches(Integer lunchId) {
        this.lunchId = lunchId;
    }

    public Lunches(Integer lunchId, String lunchName, int lunchWeek, int lunchDay) {
        this.lunchId = lunchId;
        this.lunchName = lunchName;
        this.lunchWeek = lunchWeek;
        this.lunchDay = lunchDay;
    }

    public Integer getLunchId() {
        return lunchId;
    }

    public void setLunchId(Integer lunchId) {
        this.lunchId = lunchId;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public int getLunchWeek() {
        return lunchWeek;
    }

    public void setLunchWeek(int lunchWeek) {
        this.lunchWeek = lunchWeek;
    }

    public int getLunchDay() {
        return lunchDay;
    }

    public void setLunchDay(int lunchDay) {
        this.lunchDay = lunchDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lunchId != null ? lunchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lunches)) {
            return false;
        }
        Lunches other = (Lunches) object;
        if ((this.lunchId == null && other.lunchId != null) || (this.lunchId != null && !this.lunchId.equals(other.lunchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "General.Lunches[ lunchId=" + lunchId + " ]";
    }
    
}
