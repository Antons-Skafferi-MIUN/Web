/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import General.Reservations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahl1400
 */
@Stateless
public class ReservationsFacade extends AbstractFacade<Reservations> {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationsFacade() {
        super(Reservations.class);
    }
    
}
