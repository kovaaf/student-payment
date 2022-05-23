package edu.javacourse.student.dao;

import edu.javacourse.student.domain.RegisterOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 23.05.2022
 */
@Repository
public interface RegisterOfficeRepository extends JpaRepository<RegisterOffice, Long> {
}
