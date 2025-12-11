package edu.famu.cop3060.resources.services;

import edu.famu.cop3060.resources.dto.ResourcesDTO;
import edu.famu.cop3060.resources.store.InMemoryResourceStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourcesService {
    private final InMemoryResourceStore store;

    public ResourcesService(InMemoryResourceStore store) {
        this.store = store;
    }

    public List<ResourcesDTO> findAll() {
        return store.findAll();
    }

    public Optional<ResourcesDTO> getByID(String id) {
        return store.getByID(id);
    }

    public List<ResourcesDTO> findbyFilters(Optional<String> category, Optional<String> q) {
        return store.findbyFilters(category, q);
    }
}
