package com.rls.multitenancy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.dataset.DataSet;
import java.util.Optional;

import com.rls.multitenancy.domain.entity.Product;
import com.rls.multitenancy.multitenancy.util.TenantContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.rls.multitenancy.annotation.SpringBootDbIntegrationTest;
import com.rls.multitenancy.persistence.PostgresqlTestContainer;

@Testcontainers
@SpringBootDbIntegrationTest
class ProductRepositoryTest {

    @Container
    private static final PostgresqlTestContainer POSTGRESQL_CONTAINER = PostgresqlTestContainer.getInstance();

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DataSet(value = {"products.yml"})
    public void findByIdForTenant1() {

        TenantContext.setTenantId(1L);
        Optional<Product> product = productRepository.findById(1L);
        assertThat(product).isPresent();
        assertThat(product.get().getName()).isEqualTo("Product 1");
        TenantContext.clear();

    }

    @Test
    @DataSet(value = {"products.yml"})
    public void findByIdForTenant2() {

        TenantContext.setTenantId(1L);
        assertThat(productRepository.findById(1L)).isNotPresent();
        TenantContext.clear();

    }

}