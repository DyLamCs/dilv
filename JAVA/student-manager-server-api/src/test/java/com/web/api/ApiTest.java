package com.web.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Student;
import com.web.service.StudentService;

@SpringBootTest //@SpringBootTest sẽ đi tìm kiếm class có gắn @SpringBootApplication và từ đó đi tìm toàn bộ Bean và nạp vào Context.

@AutoConfigureMockMvc //Chú thích có thể được áp dụng cho một lớp thử nghiệm để kích hoạt và cấu hình cấu hình tự động của MockMvc.
public class ApiTest {
	private static String DEFAULT_URL = "/api";
	@Autowired
	private ObjectMapper objectMapper; // class cung cấp các chức năng đọc, ghi... với JSON
	
	@Autowired
	private MockMvc mokMvc; //- MockMvc: giả lập hành vi của một class
	
	@Autowired
	private StudentService studentService;
	SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * test lấy tất cả danh sách sinh viên đang có trong DB
	 */
	@Test
	@Order(1)
	public void testgetAll() throws Exception {
		List<Student> studentList = studentService.findAllStudent();

		MvcResult mvcResult = mokMvc.perform(get(DEFAULT_URL + "/student")).andExpect(status().isOk()).andDo(print())
				.andReturn();

		// in ra console
		String actualJsonResp = mvcResult.getResponse().getContentAsString();
		System.out.print(actualJsonResp);
		String expectedJsonResp = objectMapper.writeValueAsString(studentList);
		assertThat(actualJsonResp).isEqualToIgnoringWhitespace(expectedJsonResp);

	}

	/**
	 * Test lấy thông tin sinh viên bằng Id
	 */
	@Test
	@Order(2)
	public void testreadByIdStudent() throws Exception {

		Integer id = 10;
		Student studentTest = studentService.findByIdStudent(id);

		MvcResult mvcResult = mokMvc.perform(get(DEFAULT_URL + "/student/" + id.toString())).andExpect(status().isOk())
				.andDo(print()).andReturn();
		System.out.println("-----------------------------------------------------------");
		String actualJsonResp = mvcResult.getResponse().getContentAsString();

		String expectedJsonResp = objectMapper.writeValueAsString(studentTest);

		assertThat(actualJsonResp).isEqualToIgnoringWhitespace(expectedJsonResp);
	}

	/**
	 * Test tao một đối tượng mới vào DB
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void testCreateStudent() throws JsonProcessingException, Exception {

		int lenghtBefore = studentService.findAllStudent().size();

		Student student = new Student();
		student.setName("Test CreateStudent");
		student.setAge(22);
		student.setAddress("IVS");

		String expectedJsonResp = objectMapper.writeValueAsString(student);

		@SuppressWarnings("unused")
		MvcResult mvcResult = mokMvc
				.perform(post(DEFAULT_URL + "/student").contentType(MediaType.APPLICATION_JSON)
						.content(expectedJsonResp).characterEncoding("utf-8"))
				.andExpect(status().isOk()).andDo(print()).andReturn();
		System.out.println("-----------------------------------------------------------");

		int lenghtAfter = studentService.findAllStudent().size();
		assertEquals(lenghtBefore + 1, lenghtAfter);
	}

	/**
	 * Test xoa một đối tượng
	 */
	@Test
	@Order(4)
	public void testDelete() throws Exception {
		int lenghtBefore = studentService.findAllStudent().size();

		int id = 40;

		@SuppressWarnings("unused")
		MvcResult mvcResult = mokMvc.perform(delete(DEFAULT_URL + "/student/delete/" + id)).andExpect(status().isOk())
				.andDo(print()).andReturn();
		System.out.println("-----------------------------------------------------------");

		int lenghtAfter = studentService.findAllStudent().size();

		assertEquals(lenghtBefore - 1, lenghtAfter);
	}
	
	@Test
	@Order(5)
	public void testUpdate() throws Exception {
		Integer id = 12;
		
		Student studentBefore = studentService.findByIdStudent(id);
		studentBefore.setName("DILV (update)");
		
		String expectedJsonResp = objectMapper.writeValueAsString(studentBefore);
		
		@SuppressWarnings("unused")
		MvcResult mvcResult = mokMvc.perform(put(DEFAULT_URL + "/student/update/" + id)
				.contentType(MediaType.APPLICATION_JSON)
	            .content(expectedJsonResp)
	            .characterEncoding("utf-8"))
				.andExpect(status().isOk()).andDo(print()).andReturn();
		System.out.println("-----------------------------------------------------------");
		
		Student studentAfter = studentService.findByIdStudent(id);
		
		String actualJsonResp = objectMapper.writeValueAsString(studentAfter);
		
		assertThat(actualJsonResp).isEqualToIgnoringWhitespace(expectedJsonResp);
	}
	
	// test export file pdf
		@Test
		@Order(6)
		public void testExportPdf() throws Exception{
			String url = DEFAULT_URL + "/student/pdfview";
			MvcResult mvcResult = mokMvc.perform(get(url))
					.andExpect(status().isOk()).andDo(print()).andReturn();
			System.out.println("-----------------------------------------------------------");
			
			byte[] bytes = mvcResult.getResponse().getContentAsByteArray();
			
			Path path = Paths.get("student.pdf");
			Files.write(path, bytes);
			
			
		}

}
