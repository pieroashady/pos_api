package com.exyna.pos_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class PosApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(PosApiApplication.class);
		modules.forEach(System.out::println);
	}

	@Test
	void verifyModularStructure() {
		ApplicationModules modules = ApplicationModules.of(PosApiApplication.class);
		modules.verify();
	}

	@Test
	void createModuleDocumentation() {
		ApplicationModules modules = ApplicationModules.of(PosApiApplication.class);
		new Documenter(modules).writeDocumentation().writeIndividualModulesAsPlantUml();
	}

}
