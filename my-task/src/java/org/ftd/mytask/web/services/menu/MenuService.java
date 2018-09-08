
package org.ftd.mytask.web.services.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.ftd.mytask.web.mvc.abstracts.MVC;

/**
 *
 * @author Fabio TAvares Dippold
 * @version 1.0.0
 * 
 */
public class MenuService implements Serializable {
    private static final long serialVersionUID = 8035871782108353765L;
    private static final MenuService INSTANCE;
    
    public static final String RULE_ALL = "*";
    public static final String RULE_ROOT = "1";
    public static final String RULE_GP = "2";
    public static final String RULE_USER = "3";
    public static final String RULE_GUEST = "99";            

    
    private final List<Menu> model;
    
    static {
        INSTANCE = new MenuService();
    }
    
    private MenuService() {
        this.model = new ArrayList<>();
        List<SubMenu> subMenusConfig = new ArrayList<>();
        subMenusConfig.add(new SubMenu("Mudar senha", RULE_ALL, "ChangePasswdCmd", MVC.MVC_ACTION_UPDATE, "fas fa-lock-open"));
        subMenusConfig.add(new SubMenu("Resertar senha", (RULE_ROOT + ";" + RULE_GP), "ResetPasswdCmd", MVC.MVC_ACTION_UPDATE, "fas fa-recycle"));
        subMenusConfig.add(new SubMenu("Manter usuários", (RULE_ROOT + ";" + RULE_GP), "UserCmd", MVC.MVC_ACTION_BUILD_GRID_MODEL, "fas fa-users-cog"));
        subMenusConfig.add(new SubMenu("Manter chaves", (RULE_ROOT), "ConfigKeyCmd", MVC.MVC_ACTION_BUILD_GRID_MODEL, "fas fa-key"));
        subMenusConfig.add(new SubMenu("Logs", (RULE_ROOT + ";" + RULE_GP), "LogCmd", MVC.MVC_ACTION_BUILD_GRID_MODEL, "fas fa-eye"));
        Menu configMenu = new Menu("Config", (RULE_ROOT + ";" + RULE_GP), subMenusConfig);
        this.model.add(configMenu);
        
    }
    
    public MenuService getInstance() {
        return INSTANCE;
    }
    
    public List<Menu> getMenuModel() {
        return this.model;
    }
    
}
