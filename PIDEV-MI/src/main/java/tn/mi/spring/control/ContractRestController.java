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

import tn.mi.spring.entities.Contract;
import tn.mi.spring.service.IContractService;



@RestController
public class ContractRestController {
	@Autowired
	IContractService contractService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-contracts
	@GetMapping("/retrieve-all-contracts")
	@ResponseBody
	public List<Contract> getContracts() {
		List<Contract> list = contractService.retrieveAllContracts();
		return list;
    }
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-contract/{contract-id}
	@GetMapping("/retrieve-contract/{contract-id}")
	@ResponseBody
	public Contract retrieveContract(@PathVariable("contract-id") String contractId) {
		return contractService.retrieveContract(contractId);
	}
	
	// Ajouter Contract : http://localhost:8081/SpringMVC/servlet/add-contract
	@PostMapping("/add-contract")
	@ResponseBody
	public Contract addContract(@RequestBody Contract c) {
		Contract contract = contractService.addContract(c);
		return contract;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-contract/{contract-id}
	@DeleteMapping("/remove-contract/{contract-id}")
	@ResponseBody
	public void removeContract(@PathVariable("contract-id") String contractId) {
		contractService.deleteContract(contractId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-contract
	@PutMapping("/modify-contract")
	@ResponseBody
	public Contract modifyUser(@RequestBody Contract contract) {
		return contractService.updateContract(contract);
	}
}
	
