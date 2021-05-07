package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Fiche;
import tn.mi.spring.entities.User;
public interface FicheService {
	List<Fiche> retrieveAllFiche();
	Long addFiche(Fiche f);
	void deleteFiche(String id);
	Fiche updateFiche(Fiche f);
	Fiche retrieveFiche(String id);
	public int getNombretrueJPQL();
	public int getNombrefalseJPQL();
	public int getNombreamiJPQL();
	public int getNombrefamilleJPQL();
	public int getNombresitewebJPQL();
	public int getNombrefacebookJPQL();
	public List<Fiche> affichersurveil(User user);
	public void deleteSurv(String id);
}
