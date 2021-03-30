/**
 * 
 */
package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.mi.spring.entities.Contract;

/**
 * @author guiforodrigue
 *
 */
public interface IContractRepository extends CrudRepository<Contract, Long>{

}
