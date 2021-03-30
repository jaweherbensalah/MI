/**
 * 
 */
package tn.mi.spring.service;

/**
 * @author guiforodrigue
 *
 */
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tn.mi.spring.service.IContractService;
import tn.mi.spring.service.ContractServiceImpl;
import tn.mi.spring.entities.Contract;
import tn.mi.spring.repository.IContractRepository;

@Repository
public class ContractServiceImpl implements IContractService{

	@Autowired
	IContractRepository contractRepository;
	
	private static final Logger l = LogManager.getLogger(ContractServiceImpl.class);
	
	@Override
	public List<Contract> retrieveAllContracts(){
		List<Contract> contracts = (List<Contract>) contractRepository.findAll();
		for (Contract contract : contracts){
			l.info("contract +++ :" + contract);
		}
		return contracts;
	}
	
	@Override
	public Contract addContract(Contract c){
		Contract contractSaved = null;
		contractSaved = (Contract) contractRepository.save(c);
		return contractSaved;
		
	}
	@Override
	public Contract updateContract(Contract c){
		Contract contractAdded = (Contract) contractRepository.save(c);
		return contractAdded;
	}
	@Override
	public void deleteContract(String id){
		contractRepository.deleteById(Long.parseLong(id));
	}
	
	@Override 
	public Contract retrieveContract(String id){
		l.info("in retrieveContract id = " + id);
		Contract c = contractRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("contract return " + c);
		return c;
		
	}
}
