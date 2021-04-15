/**
 * 
 */
package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Claim;


/**
 * @author guiforodrigue
 *
 */
public interface IClaimService {
	
	List<Claim> retrieveAllClaims();

	Claim addClaim(Claim c);

	Claim updateClaim(Claim c);
	
	void deleteClaim(String id);
	
	Claim retrieveClaim(String id);

}
