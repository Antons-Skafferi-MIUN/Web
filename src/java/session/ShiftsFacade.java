/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import General.Shifts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonte
 */
@Stateless
public class ShiftsFacade extends AbstractFacade<Shifts> {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShiftsFacade() {
        super(Shifts.class);
    }
    
}
