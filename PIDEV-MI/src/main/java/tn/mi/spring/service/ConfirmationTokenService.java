package tn.mi.spring.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mi.spring.entities.ConfirmationToken;
import tn.mi.spring.repository.ConfirmationTokenRepository;

@Service
//@AllArgsConstructor
public class ConfirmationTokenService {
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

   //Forgpotten Pass 
    
    
    
    
    
	public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
	
		this.confirmationTokenRepository = confirmationTokenRepository;
	}
	public ConfirmationTokenService() {}





	public ConfirmationTokenRepository getConfirmationTokenRepository() {
		return confirmationTokenRepository;
	}

	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}
    
    
    
   
 
}
