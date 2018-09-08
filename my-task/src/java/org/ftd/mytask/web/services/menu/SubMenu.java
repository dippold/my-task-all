package org.ftd.mytask.web.services.menu;

import java.io.Serializable;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * 
 */
public class SubMenu implements Serializable {
    
    private static final long serialVersionUID = 6042668256050083328L;
    
    private String name;
    private String ruleIds;
    private String resource;
    private String actionId;
    private String icon;

    public SubMenu(String name, String ruleIds, String resource, String actionId, String icon) {
        this.name = name;
        this.ruleIds = ruleIds;
        this.resource = resource;
        this.actionId = actionId;
        this.icon = icon;
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
    
}
