package edu.famu.cop3060.resources.store;

import edu.famu.cop3060.resources.dto.ResourcesDTO;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.*;
import java.util.stream.Stream;
import java.util.Locale;

@Component
public class InMemoryResourceStore {
    private final Map<String, ResourcesDTO> byID = new HashMap<>();
    private final List<ResourcesDTO> all = new ArrayList<>();

    @PostConstruct
    public void init() {
        //seed 6 entries
        seed(new ResourcesDTO("res-001", "Math Tutoring", "Tutoring", "Building A", "https://example.edu/tutoring/math", List.of("math", "tutoring", "algebra")));
        seed(new ResourcesDTO("res-002", "Career Advising", "Advising", "Building B", "https://example.edu/advising/career", List.of("career", "resume")));
        seed(new ResourcesDTO("res-003", "Chemistry Lab", "Lab", "Building C", "https://example.edu/labs/chem", List.of("chemistry", "lab", "research")));
        seed(new ResourcesDTO("res-004", "Writing Center", "Tutoring", "Building D", "https://example.edu/writing", List.of("writing", "editing")));
        seed(new ResourcesDTO("res-005", "CS Help Desk", "Advising", "Building E", "https://example.edu/cshelp", List.of("computer", "help", "coding")));
        seed(new ResourcesDTO("res-006", "Physics Lab", "Lab", "Building F", "https://example.edu/labs/phys", List.of("physics", "experiments")));

    }


    private void seed(ResourcesDTO resource) {
        byID.put(resource.id(), resource);
        all.add(resource);
    }

    public List<ResourcesDTO> findAll() {
        return List.copyOf(all);
    }

    public Optional<ResourcesDTO> getByID(String id) {
        return Optional.ofNullable(byID.get(id));
    }

    public List<ResourcesDTO> findbyFilters(Optional<String> category, Optional<String> q) {
        Stream<ResourcesDTO> stream = all.stream();

        if (category.isPresent()) {
            String cat = category.get();
            stream = stream.filter(r -> r.category() != null && r.category().equalsIgnoreCase(cat));
        }

        if (q.isPresent()) {
            String query = q.get().toLowerCase();
            stream = stream.filter(r ->
                    (r.name() != null && r.name().toLowerCase().contains(query)) ||
                            (r.tags() != null && r.tags().stream().anyMatch(tag -> tag.toLowerCase(Locale.ROOT).contains(query)))
            );
        }
        return stream.toList();
    }
};

