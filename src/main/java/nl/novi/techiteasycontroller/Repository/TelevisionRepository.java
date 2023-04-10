package nl.novi.techiteasycontroller.Repository;

import jakarta.transaction.Transactional;
import nl.novi.techiteasycontroller.Model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    @Transactional
    @Modifying
    @Query("delete from Television t where t.name = :name ")
    void deleteByName(@Param("name")String name);

    List<Television> findByName(String name);


}

