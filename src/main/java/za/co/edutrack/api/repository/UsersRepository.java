package za.co.edutrack.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.edutrack.api.model.Users;

import java.util.Collection;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    Collection<Users> findAll();
}
