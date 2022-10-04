package com.rls.multitenancy.multitenancy.domain.entity;

public interface TenantAware {

    String getTenantId();

    void setTenantId(String tenantId);
}
