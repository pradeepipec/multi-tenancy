package se.callista.blog.service.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.database.rider.core.api.dataset.DataSet;
import javax.persistence.EntityNotFoundException;

import com.rls.multitenancy.model.ProductValue;
import com.rls.multitenancy.multitenancy.util.TenantContext;
import com.rls.multitenancy.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import se.callista.blog.service.annotation.SpringBootDbIntegrationTest;
import se.callista.blog.service.persistence.PostgresqlTestContainer;

@Testcontainers
@SpringBootDbIntegrationTest
public class ProductServiceTest {

    @Container
    private static final PostgresqlTestContainer POSTGRESQL_CONTAINER = PostgresqlTestContainer.getInstance();

    @Autowired
    private ProductService productService;

    @Test
    @DataSet(value = {"products.yml"})
    public void getProductForTenant1() {

        TenantContext.setTenantId("tenant1");
        ProductValue product = productService.getProduct(1);
        assertThat(product.getName()).isEqualTo("Product 1");
        TenantContext.clear();

    }

    @Test
    @DataSet(value = {"products.yml"})
    public void getProductForTenant2() {

        TenantContext.setTenantId("tenant2");
        assertThrows(EntityNotFoundException.class, () -> productService.getProduct(1));
        TenantContext.clear();

    }

}
