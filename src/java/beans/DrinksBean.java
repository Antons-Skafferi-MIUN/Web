package beans;

import General.Drinks;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Named(value = "drinksBean")
@Dependent
public class DrinksBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    private List<Drinks> drinksList;

    /**
     * Creates a new instance of DrinksBean
     */
    public DrinksBean() {
    }

    public List<Drinks> getDrinks() {
        TypedQuery<Drinks> query = em.createNamedQuery("Drinks.findAll", Drinks.class);
        drinksList = query.getResultList();
        return drinksList;
    }
}
