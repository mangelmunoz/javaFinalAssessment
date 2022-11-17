package com.finalAssessment.finalAssessement.repositories;

import com.finalAssessment.finalAssessement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
