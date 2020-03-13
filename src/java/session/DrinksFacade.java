/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import General.Drinks;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahl1400
 */
@Stateless
public class DrinksFacade extends AbstractFacade<Drinks> {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DrinksFacade() {
        super(Drinks.class);
    }
    
}
