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

import tn.mi.spring.service.IClaimService;
import tn.mi.spring.service.ClaimServiceImpl;
import tn.mi.spring.entities.Claim;
import tn.mi.spring.repository.IClaimRepository;

@Repository
public class ClaimServiceImpl implements IClaimService{

	@Autowired
	IClaimRepository claimRepository;
	
	private static final Logger l = LogManager.getLogger(ClaimServiceImpl.class);
	
	@Override
	public List<Claim> retrieveAllClaims(){
		List<Claim> claims = (List<Claim>) claimRepository.findAll();
		for (Claim claim : claims){
			l.info("claim +++ :" + claim);
		}
		return claims;
	}
	
	@Override
	public Claim addClaim(Claim c){
		Claim claimSaved = null;
		claimSaved = (Claim) claimRepository.save(c);
		return claimSaved;
		
	}
	@Override
	public Claim updateClaim(Claim c){
		Claim claimAdded = (Claim) claimRepository.save(c);
		return claimAdded;
	}
	@Override
	public void deleteClaim(String id){
		claimRepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Claim retrieveClaim(String id){
		l.info("in retrieveClaim id = " + id);
		Claim c = claimRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("claim return " + c);
		return c;
		
	}
}
