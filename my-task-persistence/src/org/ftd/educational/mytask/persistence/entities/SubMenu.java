package org.ftd.educational.mytask.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fdippold
 * @version 1.0.1
 * 
 */
@Entity
@Table(name="submenu")
@NamedQueries({
    @NamedQuery(name = "SubMenu.find.by.menu",
            query = "SELECT o FROM SubMenu o WHERE o.menuId = :id ORDER BY o.sequenceId"),
    @NamedQuery(name = "SubMenu.find.all",
            query = "SELECT o FROM SubMenu o ORDER BY o.menuId ASC, o.sequenceId ASC")    
})

public class SubMenu extends AbstractEntity {

    private static final long serialVersionUID = 7461013271949580046L;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long menuId = 1L;
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long sequenceId;
    
    @Column(nullable = false, length = 45)
    private String resource;    
    
    @Column(nullable = false, length = 45)
    private String ruleIds;
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long actionId = 1L;    

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(String ruleIds) {
        this.ruleIds = ruleIds;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
            
}
