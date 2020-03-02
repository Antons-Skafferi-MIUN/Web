package beans;

import General.Foods;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Named(value = "dinnerBean")
@Dependent
public class DinnerBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    private List<Foods> dinnerList; 

    /**
     * Creates a new instance of DinnerBean
     */
    public DinnerBean() {
    }

    public List<Foods> getDinner() {
        TypedQuery<Foods> query = em.createNamedQuery("Foods.findAll", Foods.class);
        dinnerList = query.getResultList();
        return dinnerList;
    }
}
