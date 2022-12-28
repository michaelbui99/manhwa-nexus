package io.github.michaelbui99.manhwanexus.dataaccess;

import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;
import org.jooq.codegen.GenerationTool;

public class RunJooqCodeGeneration {
    public static void main(String[] args) throws Exception {
        var resourcesHandler = new ResourcesHandler();
        String config = resourcesHandler.getResourceFileContent("jooq-config.xml");
        GenerationTool.generate(config);
    }
}
