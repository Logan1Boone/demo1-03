package edu.famu.cop3060.resources;

import edu.famu.cop3060.resources.services.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourcesApplicationTests implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ResourcesApplicationTests.class);

    private final ResourcesService service;

    public ResourcesApplicationTests(ResourcesService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourcesApplicationTests.class, args);
    }
    @Override
    public void run(ApplicationArguments args) {
        int count = service.findAll().size();
        log.info("InMemoryResourceStore seeded with {} resources.", count);
    }
}