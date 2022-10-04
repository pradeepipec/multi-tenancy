package se.callista.blog.service.multitenancy.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import com.rls.multitenancy.multitenancy.domain.entity.TenantAware;
import com.rls.multitenancy.multitenancy.listener.TenantListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantListener.class)
public abstract class AbstractBaseEntity implements TenantAware, Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 30)
    @Column(name = "tenant_id")
    private String tenantId;

    public AbstractBaseEntity(String tenantId) {
        this.tenantId = tenantId;
    }

}
