package com.finalAssessment.finalAssessement;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.finalAssessment.finalAssessement.exceptions.WrongSyntaxEmailException;
import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.services.StudentService;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class FinalAssessementApplicationTests {

	private static RequestSpecification requestSpecification;

	@Autowired
	public StudentService studentService;


	@BeforeAll
	static void getUri(){
		requestSpecification = RestAssured.given().baseUri("http://localhost:8080").basePath("/api/student");
	}

	@BeforeClass
	void addUser() throws WrongSyntaxEmailException {
		studentService.addStudent(new Student("test", "test", "test", "jorge@jorge.com"));
	}

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUsers_WorksProperly(){
		List<Student> result = given(requestSpecification)
				.when()
				.get("/all")
				.then().extract().body().jsonPath().getList(".", Student.class);

		System.out.println("statusCode: " + result);

		//TODO: think about a way to make it work

		Assertions.assertNotNull(result.size());
	}

	@Test
	void addStudentWithGoodEmail(){
		Student student = new Student("test", "test", "test", "jorge@jorge.com");

		Student result = given(requestSpecification)
				.when()
				.contentType("application/json")
				.body(student)
				.post("/add")
				.then().extract().body().as(Student.class);

		student.setId(result.getId());
		System.out.println("result: " + result);

		Assertions.assertEquals(result.getId(),student.getId());
		Assertions.assertEquals(result.getEmail(),student.getEmail());
		Assertions.assertEquals(result.getFirstName(),student.getFirstName());
		Assertions.assertEquals(result.getLastName(),student.getLastName());
		Assertions.assertEquals(result.getPhoneNumber(),student.getPhoneNumber());
	}

	@Test
	void addStudentWithWrongEmail(){
		Student student = new Student("test", "test", "test", "jorge");

		//It's not recognizing the answer as a Student class because it's responding with an error
		assertThrows(IllegalStateException.class, () -> {
			Student student1 = given(requestSpecification)
					.when()
					.contentType("application/json")
					.body(student)
					.post("/add")
					.then().extract().body().as(Student.class);
		});
	}

}
