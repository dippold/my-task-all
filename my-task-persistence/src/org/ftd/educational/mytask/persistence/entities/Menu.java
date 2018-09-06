package org.ftd.educational.mytask.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="menu")
@NamedQueries({
    @NamedQuery(name = "Menu.find.by.name",
            query = "SELECT o FROM Menu o WHERE o.name = :name"),
    @NamedQuery(name = "Menu.find.all",
            query = "SELECT o FROM Menu o ORDER BY o.sequenceId")    
})
public class Menu extends AbstractEntity {

    private static final long serialVersionUID = -7573182804442603334L;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long typeId = 1L;
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long sequenceId;

    @Column(nullable = false, length = 45)  
    private String icon;
    
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }                       
    
}
