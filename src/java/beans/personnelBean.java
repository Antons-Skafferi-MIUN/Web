package beans;

import General.Personnel;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named(value = "personnelBean")
@Dependent
public class personnelBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    private List<Personnel>personnelList;
    
    public personnelBean() {
    }

    public List<Personnel> getPersonnelList() {
        TypedQuery<Personnel> query = em.createNamedQuery("Personnel.findAll", Personnel.class);
        personnelList = query.getResultList();
        return personnelList;
    }
    
    
}
