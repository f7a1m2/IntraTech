package labs.intratech.services;

import labs.intratech.models.Candidatures;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CandidaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturesService  {
	private final CandidaturesRepository candidaturesRepository;

	@Autowired
	public CandidaturesService(CandidaturesRepository candidaturesRepository) {
	    this.candidaturesRepository = candidaturesRepository;
	}

	public List<Candidatures> getAllCandidatures() {
	    return candidaturesRepository.findAll();
	}  

	public Candidatures getCandidaturesById(Long id) {
	    Optional<Candidatures> candidatures = candidaturesRepository.findById(id);
	    if (candidatures.isPresent()) {
	       return candidatures.get();
	    } else {
	       throw new RuntimeException("Candidatures not found with id " + id);
	    }
	}

	public Candidatures createCandidatures(Candidatures candidatures) {
	    return candidaturesRepository.save(candidatures);
	}

	public Candidatures updateCandidatures(Long id, Candidatures candidatures) {
	    Optional<Candidatures> existingCandidatures = candidaturesRepository.findById(id);
	       if (existingCandidatures.isPresent()) {
		       candidatures.setCandidaturesid(id);
	             return candidaturesRepository.save(candidatures);
	       } else {
	          throw new RuntimeException("Candidatures not found with id " + id);
	       }
	}

	public void deleteCandidatures(Long id) {
	    candidaturesRepository.deleteById(id);
	}

}



