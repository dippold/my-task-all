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

                       

    
}
