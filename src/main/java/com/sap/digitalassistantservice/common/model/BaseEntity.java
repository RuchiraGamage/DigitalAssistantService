package com.sap.digitalassistantservice.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Most upper class for entities
 * All the entities are extended from this class
 */

@MappedSuperclass
@Getter
@Setter
public class BaseEntity extends BaseModel {

    /**
     * Auto generated unique ID of entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    /**
     * Created time of entity
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "created_at", updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

    /**
     * last updated time of entity
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "updated_at", insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updatedAt = new Date();

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

