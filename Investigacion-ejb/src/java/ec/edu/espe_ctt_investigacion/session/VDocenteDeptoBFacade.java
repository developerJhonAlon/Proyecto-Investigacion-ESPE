/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class VDocenteDeptoBFacade extends AbstractFacade<VDocenteDeptoB> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDocenteDeptoBFacade() {
        super(VDocenteDeptoB.class);
    }
    public VDocenteDeptoB findCodDeptoByUsuId(BigDecimal usuId){
        List<VDocenteDeptoB> result = null;
        Query query = em.createQuery("SELECT o FROM VDocenteDeptoB o WHERE o.usuId =:usuId ");
        query.setParameter("usuId", usuId);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result.isEmpty()?null:result.get(0);
    }
    
}
