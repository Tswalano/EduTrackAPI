package za.co.edutrack.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.edutrack.api.model.School;

import java.util.Collection;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    Collection<School> findAll();
}
