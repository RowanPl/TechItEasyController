package nl.novi.techiteasycontroller.Repository;

import nl.novi.techiteasycontroller.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
;

public interface UserRepository extends JpaRepository<User, String> {
}