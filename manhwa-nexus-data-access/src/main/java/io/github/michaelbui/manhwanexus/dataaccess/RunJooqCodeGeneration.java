package io.github.michaelbui.manhwanexus.dataaccess;

import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;
import org.jooq.codegen.GenerationTool;

import java.nio.file.Files;
import java.nio.file.Path;

public class RunJooqCodeGeneration {
    public static void main(String[] args) throws Exception {
        var resourcesHandler = new ResourcesHandler();
        String config = resourcesHandler.getResourceFileContent("jooq-config.xml");
        System.out.println(config);
        GenerationTool.generate(config);
    }
}
