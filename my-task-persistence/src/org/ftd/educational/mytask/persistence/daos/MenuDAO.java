package org.ftd.educational.mytask.persistence.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.ftd.educational.mytask.persistence.entities.Menu;

/**
 *
 * @author fdippold
 * @version 1.0.1
 *
 */
public class MenuDAO extends MenuJpaController {

    private static final long serialVersionUID = -2187418897143325204L;

    public MenuDAO(EntityManagerFactory emf) {
        super(emf);
    }

    public List<Menu> findAll() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Menu.find.all");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Menu find(Long id) {
        return super.findMenu(id);
    }
    
}
