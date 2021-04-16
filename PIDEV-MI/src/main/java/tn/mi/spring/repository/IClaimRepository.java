/**
 * 
 */
package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.mi.spring.entities.Claim;


/**
 * @author guiforodrigue
 *
 */
public interface IClaimRepository extends CrudRepository<Claim, Long>{

}
