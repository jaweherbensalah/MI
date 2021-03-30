/**
 * 
 */
package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Contract;

/**
 * @author guiforodrigue
 *
 */
public interface IContractService {

	List<Contract> retrieveAllContracts();

	Contract addContract(Contract c);

	Contract updateContract(Contract c);
	
	void deleteContract(String id);
	
	Contract retrieveContract(String id);
}
