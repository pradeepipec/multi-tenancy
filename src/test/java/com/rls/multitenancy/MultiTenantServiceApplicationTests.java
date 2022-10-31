package com.rls.multitenancy;

import com.rls.multitenancy.annotation.SpringBootIntegrationTest;
import com.rls.multitenancy.persistence.PostgresqlTestContainer;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootIntegrationTest
class MultiTenantServiceApplicationTests {

	@Container
	private static final PostgresqlTestContainer POSTGRESQL_CONTAINER = PostgresqlTestContainer.getInstance();

	@Test
	void contextLoads() {
	}

}
