/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import General.Personnel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonte
 */
@Stateless
public class PersonnelFacade extends AbstractFacade<Personnel> {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnelFacade() {
        super(Personnel.class);
    }
    
}
