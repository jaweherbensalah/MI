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

import tn.mi.spring.entities.Risk;
import tn.mi.spring.service.IRiskService;

@RestController
public class RiskRestControl {
	
	@Autowired
	IRiskService riskService; 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-risk
		@GetMapping("/retrieve-all-risk")
		@ResponseBody
		public List<Risk> getRisks() {
		List<Risk> list = riskService.retrieveAllRisks();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet/retrieve-service/{Risk-id}
		@GetMapping("/retrieve-risk/{risk-id}")
		@ResponseBody
		public Risk retrieveRisk(@PathVariable("risk-id") Integer RiskId) {
		return riskService.retrieveRisk(RiskId);
		}
		
		// Add Risk : http://localhost:8081/SpringMVC/servlet/add-risk
		@PostMapping("/add-risk")
		@ResponseBody
		public Risk addrisk(@RequestBody Risk r) {
			Risk risk = riskService.addRisk(r);
			return risk;
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-risk/{risk-id}
		@DeleteMapping("/remove-risk/{risk-id}")
		@ResponseBody
		public void removeRisk(@PathVariable("risk-id") Integer riskId) {
		riskService.deleteRisk(riskId);
		}

		// http://localhost:8081/SpringMVC/servlet/modify-risk
		@PutMapping("/modify-risk")
		@ResponseBody
		public Risk modifyRisk(@RequestBody Risk risk) {
		return riskService.updateRisk(risk);
		}


}
