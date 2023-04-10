package nl.novi.techiteasycontroller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionWallBracketRepository<TelevisionWallBracket, TelevisionWallBracketKey> extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    List<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    List<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}