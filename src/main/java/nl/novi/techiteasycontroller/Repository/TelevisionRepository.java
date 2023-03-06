package nl.novi.techiteasycontroller.Repository;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import nl.novi.techiteasycontroller.Model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Type;
import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    @Transactional
    @Modifying
    @Query("delete from Television t where t.name = :name ")
    void deleteByName(@Param("name")String name);

    Optional<Television> findByName(String name);


}

