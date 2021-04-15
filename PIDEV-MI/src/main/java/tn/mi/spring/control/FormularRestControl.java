package tn.mi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.Formular;
import tn.mi.spring.service.IFormularService;

@RestController
public class FormularRestControl {
	
	@Autowired
	IFormularService formularService; 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-formular
		@GetMapping("/retrieve-all-formular")
		@ResponseBody
		public List<Formular> getFormulars() {
		List<Formular> list = formularService.retrieveAllFormulars();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet/retrieve-formular/{Formular-id}
		@GetMapping("/retrieve-formular/{Formular-id}")
		@ResponseBody
		public Formular retrieveFormular(@PathVariable("Formular-id") Integer FormularId) {
		return formularService.retrieveFormular(FormularId);
		}
		
		// Ajouter Formular : http://localhost:8081/SpringMVC/servlet/add-formular
		@PostMapping("/add-formular")
		@ResponseBody
		public Formular addformular(@RequestBody Formular f) {
		Formular formular = formularService.addFormular(f);
		return formular;
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-formular/{formular-id}
		@DeleteMapping("/remove-formular/{formular-id}")
		@ResponseBody
		public void removeFormular(@PathVariable("formular-id") Integer formularId) {
		formularService.deleteFormular(formularId);
		}

		// http://localhost:8081/SpringMVC/servlet/modify-formular
		@PutMapping("/modify-formular")
		@ResponseBody
		public Formular modifyFormular(@RequestBody Formular formular) {
		return formularService.updateFormular(formular);
		}

}
