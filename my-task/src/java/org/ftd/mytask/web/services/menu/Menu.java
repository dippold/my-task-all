package org.ftd.mytask.web.services.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio TAvares Dippold
 * @version 1.0.0
 *
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = -805562899061540997L;

    private String name;
    private String ruleIds;
    private List<SubMenu> subMenus;

    public Menu(String name, List<SubMenu> subMenus) {
        this(name, MenuService.RULE_ALL, subMenus);
    }

    public Menu(String name, String ruleIds, List<SubMenu> subMenus) {
        this.name = name;
        this.ruleIds = ruleIds;
        this.subMenus = subMenus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(String ruleIds) {
        this.ruleIds = ruleIds;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }

    public void addSubMenu(SubMenu subMenu) {
        if (this.subMenus == null) {
            this.subMenus = new ArrayList<>();
        }
        this.subMenus.add(subMenu);
    }

}
