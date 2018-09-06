package org.ftd.educational.mytask.persistence.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.ftd.educational.mytask.persistence.entities.SubMenu;

/**
 *
 * @author fdippold
 * @version 1.0.1
 *
 */
public class SubMenuDAO extends SubMenuJpaController {

    private static final long serialVersionUID = 711766246935184161L;
    
    public SubMenuDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public List<SubMenu> findAllByMenu(Long menuId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("SubMenu.find.by.menu");
            q.setParameter("id", menuId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }    

    public List<SubMenu> findAll() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("SubMenu.find.all");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
