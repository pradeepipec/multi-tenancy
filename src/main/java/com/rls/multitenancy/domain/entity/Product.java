package com.rls.multitenancy.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.callista.blog.service.multitenancy.domain.entity.AbstractBaseEntity;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product extends AbstractBaseEntity {

    @Builder
    public Product(Long id, String name, Integer version, Long tenantId) {
        super(tenantId);
        this.id = id;
        this.name = name;
        this.version = version;
    }

    @Id
    @Column(name = "id", unique = true,updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", length = 255, nullable = false)
    @NotNull
    @Size(max = 255)
    private String name;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "int default 0")
    protected Integer version;

}
