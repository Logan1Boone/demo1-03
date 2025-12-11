package edu.famu.cop3060.resources.controller;

import edu.famu.cop3060.resources.dto.ResourcesDTO;
import edu.famu.cop3060.resources.services.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class ResourcesController {
    private static final Logger logger = LoggerFactory.getLogger(ResourcesController.class);

    private final ResourcesService service;

    public ResourcesController(ResourcesService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResourcesDTO> listAll(@RequestParam Optional<String> category,
                                     @RequestParam Optional<String> q) {
        return service.findbyFilters(category, q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourcesDTO> getById(@PathVariable String id) {
        return service.getByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
