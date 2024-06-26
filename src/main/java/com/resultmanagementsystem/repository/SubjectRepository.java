package com.resultmanagementsystem.repository;

import com.resultmanagementsystem.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    Subject findBySubjectName(String subjectName);
}
