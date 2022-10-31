package com.rls.multitenancy.multitenancy.domain.entity;

public interface TenantAware {

    Long getTenantId();

    void setTenantId(Long tenantId);
}
