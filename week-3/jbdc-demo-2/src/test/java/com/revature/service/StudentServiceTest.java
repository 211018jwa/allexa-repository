package com.revature.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.dao.StudentDAO;
import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Student;

public class StudentServiceTest {
	private StudentService sut;
	
	@Test
	public void testGetAllShipsPositive() throws SQLException {
		
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		Student student1 = new Student(10, "Bob", "Jones", "Senior", 22);
		Student student2 = new Student(100, "John", "Doe", "Freshman", 18);
		Student student3 = new Student(15, "Jane", "Doe", "Sophmore", 19);
		
		List<Student> studentsFromDao = new ArrayList<>();
		studentsFromDao.add(student1);
		studentsFromDao.add(student2);
		studentsFromDao.add(student3);
		
		when(mockStudentDao.getAllStudents()).thenReturn(studentsFromDao);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		List<Student> actual = studentService.getAllStudents();

		List<Student> expected = new ArrayList<>();
		expected.add(new Student(10, "Bob", "Jones", "Senior", 22));
		expected.add(new Student(100, "John", "Doe", "Freshman", 18));
		expected.add(new Student(15, "Jane", "Doe", "Sophmore", 19));
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetAllStudentsSQLExceptionOccurs() throws SQLException {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		when(mockStudentDao.getAllStudents()).thenThrow(SQLException.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(SQLException.class, () -> {
			studentService.getAllStudents();
		});
	}
	
	@Test
	public void testGetStudentByIDPositive() throws SQLException, InvalidParameterException, StudentNotFoundException {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		when(mockStudentDao.getStudentByID(eq(5))).thenReturn(new Student(5, "Bach", "Tran", "Senior", 22));
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Student actual = studentService.getStudentByID("5");
		
		Assertions.assertEquals(new Student(5, "Bach", "Tran", "Senior", 22), actual);
		
	}
	
	@Test
	public void testGetStudentByIDNotFoundNegative() throws SQLException {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.getStudentByID("1");
		});
	}
	
	@Test
	public void testGetStudentByIDAlphabeticalIDNegative() {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.getStudentByID("abc");
		});
	}
	
	@Test
	public void testGetStudentByIDDecimalNegative() {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.getStudentByID("1.0");
		});
	}
	
	@Test
	public void testEditFirstNamePositive() throws SQLException, StudentNotFoundException, InvalidParameterException {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		when(mockStudentDao.getStudentByID(eq(5))).thenReturn(new Student(5, "Jane", "Doe", "Freshman",  18));
		
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Ashley", "Doe",  "Freshman", 18);
		
		when(mockStudentDao.updateStudent(eq(5), eq(dto))).thenReturn(new Student(5, "Ashley", "Doe", "Freshman",  18));
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Student actual = studentService.editFirstName("5", "Ashley");
		
		Student expected = new Student(5, "Ashley", "Doe", "Freshman", 18);
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testEditFirstNameButStudentIDDoesNotExist() {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.editFirstName("10", "Bill");
		});
	}
	
	@Test
	public void testEditFirstNameIDProvidedIsNotAnIntNegative() {
		StudentDAO mockStudentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(mockStudentDao);
		
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			studentService.editFirstName("abcsdfsdfdssf3434", "Test");
		});
	}
	
	@Test
	public void testAddStudentAllInformationCorrectInDTO() throws SQLException, StudentNotFoundException, InvalidParameterException {
		StudentDAO studentDao = mock(StudentDAO.class);
		
		AddOrUpdateStudentDTO dtoIntoDao = new AddOrUpdateStudentDTO("Billy", "Tran",  "Freshman", 5);
		
		when(studentDao.addStudent(eq(dtoIntoDao))).thenReturn(new Student(100, "Billy", "Tran", "Freshman", 5));
		
		StudentService studentService = new StudentService(studentDao);
		
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Billy", "Tran",  "Freshman", 5);
		
		Student actual = studentService.addStudent(dto);
		
		Student expected = new Student(100, "Billy", "Tran", "Freshman", 5);
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testAddStudentFirstNameBlankEverythingElseValid() throws SQLException, StudentNotFoundException, InvalidParameterException {
		StudentDAO studentDao = mock(StudentDAO.class);
		
		StudentService studentService = new StudentService(studentDao);
		
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("      ", "Tran",  "Freshman", 5);
		
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			studentService.addStudent(dto);
		});
		
	}
}
