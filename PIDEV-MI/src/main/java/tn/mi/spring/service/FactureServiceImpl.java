package tn.mi.spring.service;






import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import tn.mi.spring.entities.Facture;
import tn.mi.spring.entities.Mail;
import tn.mi.spring.entities.Type_Prod;
import tn.mi.spring.repository.FactureRepository;


@Service
public class FactureServiceImpl implements IFactureService{

	@Autowired
	FactureRepository factRepository;
	@Autowired
	MailServiceImpl sendmail;
	
	
	private static final Logger L=LogManager.getLogger(FactureServiceImpl.class);

	@Override
	public List<Facture> retrieveAllFact() {
		List<Facture> factures=(List<Facture>) factRepository.findAll();
		for(Facture facture : factures){
			L.info("facture::::::::::::::" + facture);
		}
		return factures;

	}

	@Override
	public Facture addFact(Facture fact) {
		L.info("facture::::::::::::::" + fact);
		Mail mail=new Mail();
		mail.setFrom("khouloudabd513@gmail.com");
		mail.setSendTo(fact.getEmail());
	
		mail.setSubject("hello ,new bill");
		mail.setMessage("hi " + fact.getNomclient() + ",\n you have a new bill created" );
		
		sendmail.sendEmail(mail);
		factRepository.save(this.ChoixPrixUnitaire(fact));
		 factRepository.save(this.CalculRemiseTotal(fact));
		 return factRepository.save(fact);

	}

	@Override
	public void deleteFact(String Nfacture) {
		factRepository.deleteById(Long.parseLong(Nfacture));

	}

	@Override
	public Facture updateFact(Facture fact) {
		Facture facto=factRepository.findById(fact.getNfacture()).orElse(null);
		fact.setNfacture(facto.getNfacture());
		factRepository.save(this.ChoixPrixUnitaire(fact));
		factRepository.save(this.CalculRemiseTotal(fact));
		return factRepository.save(fact);
	}
	

	@Override
	public Facture retrieveFact(String Nfacture) {
		L.info(("au niveau de retrievefacture le numero de facture = " +Nfacture));
		Facture fact = factRepository.findById(Long.parseLong(Nfacture)).orElse(null);

		L.info("le facture fact returned : "+fact);
		return fact;
	}
	

@Override
public void NotificationMail() {
	Iterable<Facture> factures=factRepository.findAll();
	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	String now =sdformat.format(new Date());
	factures.forEach(fact ->{
		java.util.logging.Logger.getGlobal().info("notification"+ sdformat.format(fact.getDate_fin()).equals(now));
	
		if(sdformat.format(fact.getDate_fin()).equals(now)){
			
			Mail mail=new Mail();
			mail.setFrom("khouloudabd513@gmail.com");
			mail.setSendTo(fact.getEmail());
			mail.setSubject("Facture");
			mail.setMessage("hello "+fact.getNomclient()+"\n your bill is finish");
			sendmail.sendEmail(mail);
			
		}
		
		});
	
	

	
}
	@Override
	public Facture consulterFacture(String Nfacture) {
		 Facture facto= factRepository.findById(Long.parseLong(Nfacture)).orElse(null);
		if(facto==null) throw new RuntimeException("n'existe pas cette facture");
		return facto;
		}

	/*@Override
	public Facture CalculSomme(String id) {

		List<Facture> factures = factRepository.findByIdClient(Long.parseLong(id));
	double somme = 0;
		
	factures.forEach(f -> { 
		somme = somme + f.getMontant_total(); 
	});
	}
*/
public Facture ChoixPrixUnitaire(Facture facto){
	if(facto.getType_produit()==Type_Prod.AGRICOLE){
		facto.setPrix_unitaire(14.500);
	}
	if(facto.getType_produit()==Type_Prod.EDUCATION){
		facto.setPrix_unitaire(25.600);
	}
	if(facto.getType_produit()==Type_Prod.SANTE){
		facto.setPrix_unitaire(30.500);
	}
	facto.setTotal_HT(facto.getPrix_unitaire()*facto.getQuantite());
	facto.setTotal_TTC(facto.getTotal_HT()+(facto.getTotal_HT()*facto.getTVA()));
	
	return facto;
	
	
}

public Facture CalculRemiseTotal(Facture facto) {
	
	//L.info("calculremisssssssssssssssssssssssssssssssse" );
	
	

    double reduction=0;
	if(facto.getTotal_TTC()<=10000 ){
		reduction=0.12;
		facto.setReduction(reduction);
		}
	if(facto.getTotal_TTC()> 10000 && facto.getTotal_TTC()<99999){
		reduction=0.25;
		facto.setReduction(reduction);
		}
	if(facto.getTotal_TTC()> 1000000){
		reduction=0.5;
		facto.setReduction(reduction);
		}
	 facto.setTotal_reduction(reduction*facto.getTotal_TTC());
	// L.info("calculremisssssssssssssssssssssssssssssssse" +facto.toString());
	 return facto;


}

@Override
public int nbreFactures() {
	
	return factRepository.countfacture();
}

@Override
public int nbreFacturesSante() {
	
	return factRepository.countsante();
}

@Override
public int nbreFacturesAgricole() {
	
	return factRepository.countagricole();
}

@Override
public int nbreFacturesEducation() {
	
	return factRepository.counteducation();
}

@Override
public double SommeMontantFacture() {
	
	return factRepository.SommeFacture();
}

@Override
public double SommeMontantFactureAgricole() {
	
	return factRepository.SommeFactureAgricole();
}

@Override
public double SommeMontantFactureSante() {
	
	return factRepository.SommeFactureSante();
}

@Override
public double SommeMontantFactureEducation() {
	
	return factRepository.SommeFactureEducation();
}

@Override
public double StatiqueAgricole() {
	
	return factRepository.SommeFactureAgricole()/factRepository.SommeFacture();
}

@Override
public double StatiqueEducation() {
	
	return factRepository.SommeFactureEducation()/factRepository.SommeFacture();
}

@Override
public double StatiqueSante() {
	
	return factRepository.SommeFactureSante()/factRepository.SommeFacture();
}






}
