package com.backend.codenexus.dao;
import java.util.List;
import com.backend.codenexus.entity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MessageDao extends JpaRepository<MessagesEntity, Long> {

    @Query(value = "SELECT * FROM Messages = ?1", nativeQuery = true)
    List<MessagesEntity> FindAllById(Long userId);

}
