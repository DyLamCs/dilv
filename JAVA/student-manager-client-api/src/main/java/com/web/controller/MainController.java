package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** các phương thức xử lý của client
 * @author ivs
 *
 */
@Controller
public class MainController {

	/**
	 * @param model đối tượng chứa các thông tin
	 * @return
	 */
	@GetMapping("/student")
	public String getStudentPage(Model model) {
		String urlApi = "http://localhost:8081/api/student";
		model.addAttribute("urlApi", urlApi);
		return "student";
	}
}
