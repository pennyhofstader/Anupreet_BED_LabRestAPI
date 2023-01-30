package com.greatlearning.sdr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.sdr.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
