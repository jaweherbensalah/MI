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

import tn.mi.spring.entities.Claim;
import tn.mi.spring.service.IClaimService;



@RestController
public class ClaimRestController {
	@Autowired
	IClaimService claimService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-claims
	@GetMapping("/retrieve-all-claims")
	@ResponseBody
	public List<Claim> getClaims() {
		List<Claim> list = claimService.retrieveAllClaims();
		return list;
    }
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-claim/{claim-id}
	@GetMapping("/retrieve-claim/{claim-id}")
	@ResponseBody
	public Claim retrieveClaim(@PathVariable("claim-id") String claimId) {
		return claimService.retrieveClaim(claimId);
	}
	
	// Ajouter Claim : http://localhost:8081/SpringMVC/servlet/add-claim
	@PostMapping("/add-claim")
	@ResponseBody
	public Claim addClaim(@RequestBody Claim c) {
		Claim claim = claimService.addClaim(c);
		return claim;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-claim/{claim-id}
	@DeleteMapping("/remove-claim/{claim-id}")
	@ResponseBody
	public void removeClaim(@PathVariable("claim-id") String claimId) {
		claimService.deleteClaim(claimId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-claim
	@PutMapping("/modify-claim")
	@ResponseBody
	public Claim modifyUser(@RequestBody Claim claim) {
		return claimService.updateClaim(claim);
	}
}

