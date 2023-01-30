package com.greatlearning.sdr.serviceInterface;

import java.util.List;
import com.greatlearning.sdr.entity.Student;

public interface StudentServiceInterface {

	public Student findById(int theId);

	public List<Student> findAll();

	public Student save(Student student);

	public void deleteById(int id);

}