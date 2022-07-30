package com.web.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.web.model.Student;
import com.web.service.StudentService;

/**
 * API thao tác với entity Student
 * @author IVS
 *
 */
@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService studentService; // đối tượng thực thi service
	
	@Autowired
	private ServletContext servletContext; // đối tượng load các tài nguyên trong chương trình

	
	/** Tao doi tuong vao DB
	 * @param student đối tượng cần thêm
	 * @return
	 */
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	
	/**
	 * 	Tim tat ca cac doi tuong
	 * @return danh sách các student
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> readStudent() {
		return studentService.findAllStudent();
	}

	
	/**
	 * Tim sinh vien qua id (lấy đối tượng có id tương ứng với id truyền vào)
	 * @param Id của đối tượng cần tìm, lấy từ url
	 * @return đối tượng student với id tương ứng 
	 */
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
	public Student readByIdStudent(@PathVariable(value = "studentId") Integer Id) {
		return studentService.findByIdStudent(Id);
	}

	
	/**
	 * Update doi tuong
	 * @param Id đối tượng cần update
	 * @param studentDetails thông tin chi tiết của đối tượng student
	 * @return 
	 */
	@RequestMapping(value = "/student/update/{studentId}", method = RequestMethod.PUT)
	public Student updateStudent(@PathVariable(value = "studentId") Integer Id, @RequestBody Student studentDetails) {
		return studentService.updateStudent(Id, studentDetails);
	}

	 
	/**
	 * Xóa đối tượng trong DB thông qua Id
	 * @param Id của đối tượng cần xóa
	 */
	@RequestMapping(value = "/student/delete/{studentId}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value = "studentId") Integer Id) {
		studentService.deleteStudent(Id);
	}

	
	
		/**
		 * Export pdf
		 * @return
		 * @throws IOException
		 */
		@RequestMapping(value = "/student/pdfview", method = RequestMethod.GET)
		public ResponseEntity<byte[]> download() throws IOException {
			List<Student> studentList = studentService.findAllStudent();
			String path = "/target/pdf/student.pdf";
			File file = new File(path);
			file.getParentFile().mkdirs();
			// Initialize Pdf writer
			PdfWriter writer = new PdfWriter(path);
			// Initialize Pdf Document
			PdfDocument pdf = new PdfDocument(writer);
			// Initialize doecument
			Document document = new Document(pdf);
			
			
			// Font chữ
			String fontFile = "/templates/fonts/ARIAL.TTF";
			FontProgram fontProgram = FontProgramFactory.createFont(servletContext.getRealPath(fontFile));
			PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H);
			// Set font cho document
			document.setFont(pdfFont);
			// Paragraph
			Paragraph header = new Paragraph("Danh sách sinh viên");
			header.setTextAlignment(TextAlignment.CENTER).setFontSize(30).setBold().setMarginBottom(10);
			Paragraph userName = new Paragraph("Lâm Văn Di");
			userName.setTextAlignment(TextAlignment.RIGHT);
			// date
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a");
			Date date = new Date();
			Paragraph dateTime = new Paragraph(simpleDateFormat.format(date));
			dateTime.setTextAlignment(TextAlignment.RIGHT).setMarginBottom(30);
			// image
			ImageData imageData = ImageDataFactory.create(servletContext.getRealPath("/templates/logo.png"));
			Image logoIvs = new Image(imageData);
			logoIvs.setTextAlignment(TextAlignment.RIGHT).setHeight(40).setWidth(60);
			Table headerInfo = new Table(2);
			headerInfo.addCell(new Cell(1, 1).setBorder(Border.NO_BORDER));
			// table base structure
			float[] pointColumnWiths = { 80F, 130F, 130F, 130F };
			Table table = new Table(pointColumnWiths);
			table.setHorizontalAlignment(HorizontalAlignment.CENTER);

			Color color = WebColors.getRGBColor("silver");
			Cell cell = new Cell(1, 4).setBorder(Border.NO_BORDER);
			table.addCell(cell);
			cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(color).add(new Paragraph("ID"));
			table.addCell(cell);
			cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(color)
					.add(new Paragraph("Name"));
			table.addCell(cell);
			cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(color)
					.add(new Paragraph("Age"));
			table.addCell(cell);
			cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(color)
					.add(new Paragraph("Address"));
			table.addCell(cell);
			// student data
			for (Student student : studentList) {
				cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("SV-" + student.getId()));
				table.addCell(cell);

				cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph(student.getName()));
				table.addCell(cell);

				cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + student.getAge()));
				table.addCell(cell);

				cell = new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph(student.getAddress()));
				table.addCell(cell);
			}

			// Add table to the document
			document.add(logoIvs).add(dateTime);
			;
			document.add(userName);
			document.add(header);
			document.add(table);
			// close document
			document.close();

			byte[] contents = Files.readAllBytes(file.toPath());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			// Here you have to set the actual filename of your pdf
			String fileName = "student.pdf";
			headers.setContentDispositionFormData(fileName, fileName);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
			return response;

		}
	

}
