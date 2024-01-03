package com.sindeaux.jogos.arch;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "com.sindeaux.jogos")
public class ContractFirstTest {

    @ArchTest
    public static final ArchRule validator = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class).or().areAnnotatedWith(Controller.class)
            .should().implement(new DescribedPredicate<>("Todo controller deve implementar classes do OpenApi") {
                @Override
                public boolean test(JavaClass clazz) {
                    return clazz.getInterfaces().stream()
                            .filter((intefac) -> ((JavaClass) intefac).getPackageName().contains("openapi.api"))
                            .findAny().isEmpty();
                }
            });
}
