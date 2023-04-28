package com.backend.codenexus.dao;

import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.QuizEntity;
import com.backend.codenexus.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDao extends JpaRepository<ModuleEntity, Long> {

    @Query(value = "SELECT te FROM TaskEntity te WHERE te.module.id = :moduleId")
    List<TaskEntity> findTasksByModuleId(Long moduleId);

    @Query(value = "SELECT te FROM TaskEntity te WHERE te.id=:taskId")
    TaskEntity findTaskById(Long taskId);

    @Query(value = "SELECT qz FROM QuizEntity qz WHERE qz.courseQ.id = :courseId")
    QuizEntity findQuizById(Long courseId);

    @Query(value="SELECT tk FROM TaskEntity tk WHERE tk.question = :paramQuestion")
    TaskEntity findTaskByQuestion(String paramQuestion);
}