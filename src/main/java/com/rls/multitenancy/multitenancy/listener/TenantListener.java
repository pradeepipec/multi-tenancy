package com.rls.multitenancy.multitenancy.listener;

import com.rls.multitenancy.multitenancy.domain.entity.TenantAware;
import com.rls.multitenancy.multitenancy.util.TenantContext;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TenantListener {

    @PreUpdate
    @PreRemove
    @PrePersist
    public void setTenant(TenantAware entity) {
        final Long tenantId = TenantContext.getTenantId();
        entity.setTenantId(tenantId);
    }
}
