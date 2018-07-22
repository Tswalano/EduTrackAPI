package za.co.edutrack.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.edutrack.api.model.Student;

import java.util.Collection;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Collection<Student> findAll();
}

