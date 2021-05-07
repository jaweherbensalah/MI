package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.AnnoncePosition;

public interface AnnPositionService {

	List<AnnoncePosition> retrieveAllAnnoncePositions();

	AnnoncePosition addAnnoncePosition(AnnoncePosition r);

	AnnoncePosition updateAnnoncePosition(AnnoncePosition r);

	AnnoncePosition getAnnoncePosByAnnId(Long annonceId);

}
