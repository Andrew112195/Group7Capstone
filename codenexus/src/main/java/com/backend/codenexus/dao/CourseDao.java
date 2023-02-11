package com.backend.codenexus.dao;

import com.backend.codenexus.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CourseDao extends JpaRepository<CourseEntity,Long> {

    @Query(value = "SELECT * FROM course", nativeQuery = true)
    List<CourseEntity> findAll();
}
