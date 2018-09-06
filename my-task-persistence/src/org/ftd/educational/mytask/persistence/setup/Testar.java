package org.ftd.educational.mytask.persistence.setup;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.mytask.persistence.daos.SubMenuDAO;
import org.ftd.educational.mytask.persistence.daos.UserDAO;
import org.ftd.educational.mytask.persistence.entities.SubMenu;
import org.ftd.educational.mytask.persistence.entities.User;

/**
 *
 * @author fdippold
 */
public class Testar {

    public static final String PERSISTENCE_UNIT = "my-task-PU";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        SubMenuDAO dao = new SubMenuDAO(factory);
        List<SubMenu> lst = dao.findAll();
        
        for (SubMenu o:lst) {
            System.out.println(o.getName() + " ruleIds(" + o.getRuleIds() + ")");
        }
        
        
    }
}
