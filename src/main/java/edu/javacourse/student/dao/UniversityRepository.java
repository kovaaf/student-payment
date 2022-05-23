package edu.javacourse.student.dao;

import edu.javacourse.student.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kovalyov Anton 23.05.2022
 */
public interface UniversityRepository extends JpaRepository<University, Long> {
}
