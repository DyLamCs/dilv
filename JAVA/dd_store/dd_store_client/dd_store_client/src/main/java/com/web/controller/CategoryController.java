package com.web.controller;

import java.util.List;

import com.web.model.CategoryModel;
import com.web.model.ResponseObjectModel;
import com.web.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	/**
	 * Tự động tiêm impl cho interface
	 * 
	 */
	@Autowired
	ICategoryService categoryService;
	
	String URL_GET_CATEROGY 	= "http://localhost:8081/api/category";
	String URL_CREATE_CATEROGY  = "http://localhost:8081/api/category/";
	String URL_UPDATE_CATEROGY  = "http://localhost:8081/api/category/";
	String URL_DELETE_CATEROGY  = "http://localhost:8081/api/category/";
	
	/**
	 * Khi có request HTTP GET đến "/student"
	 * 
	 * @param model có các phương thức giúp thêm dữ liệu vào model với key và value
	 * @return student.jsp view
	 */
	@GetMapping()
	public String getIndex(Model model) {
		// Gọi api lấy list các đối tượng
		ResponseObjectModel<List<CategoryModel>> responseObject = categoryService.getCategory(URL_GET_CATEROGY);
		// Nếu status là "OK" trả về page /student, ngược lại trả về page exception_page
		if ("OK".equalsIgnoreCase(responseObject.getStatus()) ){
			List<CategoryModel> listCategoryModels = responseObject.getData();
			model.addAttribute("category", listCategoryModels);
			return "category/category";
		} else {
			model.addAttribute("exception_str", responseObject.getMessage());
			return "exception_page";
		}
	}
	
	/**
	 * Khi có request HTTP POST đến "/add"
	 * 
	 * @param studentModel thông tin đối tượng nhận từ view
	 * @return đường dẫn /student
	 */
	
	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") CategoryModel categoryModel, Model model) {
		// Gọi api Thêm đối tượng với các thuộc tính được thay đổi
		ResponseObjectModel<CategoryModel> responseObject = categoryService.createCategory(URL_CREATE_CATEROGY, categoryModel);
		// Nếu status là "OK" trả về page /student, ngược lại trả về page exception_page
		if (responseObject.getStatus().equalsIgnoreCase("OK")) {
			return ("redirect:/category");
		} else {
			model.addAttribute("exception_str", responseObject.getMessage());
			return "exception_page";
		}
	}
	/**
	 * Khi có request HTTP GET đến "/update/{id}"
	 * 
	 * @param id    lấy từ đường dẫn url
	 * @param model có các phương thức giúp thêm dữ liệu vào model với key và value
	 * @return update-student.jsp view
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		// Gọi api lấy một đối tượng với id
		ResponseObjectModel<CategoryModel> responseObject = categoryService.getOneCategory(URL_UPDATE_CATEROGY, id);
		// Nếu status là "OK" trả về page /student, ngược lại trả về page exception_page
		if (responseObject.getStatus().equalsIgnoreCase("OK")) {
			// Lấy data đối tượng
			CategoryModel categoryModel = responseObject.getData();
			// Gán đối tượng vào model
			model.addAttribute("category", categoryModel);
			return "update-category";
		} else {
			model.addAttribute("exception_str", responseObject.getMessage());
			return "exception_page";
		}
	}

	/**
	 * Khi có request HTTP POST đến "/update/{id}"
	 * 
	 * @param student thông tin đối tượng nhận từ view
	 * @return dẫn đến "/student" hoặc trang expception_page
	 */
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, @ModelAttribute CategoryModel categoryModel, Model model) {
		categoryModel.setCtgId(id);
		// Gọi api Sửa đối tượng với các thuộc tính được thay đổi
		ResponseObjectModel<CategoryModel> responseObject = categoryService.updateCategory(URL_UPDATE_CATEROGY, categoryModel);
		// Nếu status là "OK" trả về page /student, ngược lại trả về page exception_page
		if (responseObject.getStatus().equalsIgnoreCase("OK")) {
			return "redirect:/category";
		} else {
			model.addAttribute("exception_str", responseObject.getMessage());
			return "exception_page";
		}

	}

	/**
	 * Khi có request HTTP POST đến "/delete/{id}"
	 * 
	 * @param id lấy từ đường dẫn url
	 * @return dẫn đến "/student" hoặc trang expception_page
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		// Gọi api Xóa đối tượng với id
		ResponseObjectModel<CategoryModel> responseObject = categoryService.deleteCategory(URL_DELETE_CATEROGY, id);
		return"redirect:/category";

	}
	
}
