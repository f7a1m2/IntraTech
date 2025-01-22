package labs.intratech.services;

import labs.intratech.models.Candidats;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CandidatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatsService  {
	private final CandidatsRepository candidatsRepository;

	@Autowired
	public CandidatsService(CandidatsRepository candidatsRepository) {
	    this.candidatsRepository = candidatsRepository;
	}

	public List<Candidats> getAllCandidats() {
	    return candidatsRepository.findAll();
	}  

	public Candidats getCandidatsById(Long id) {
	    Optional<Candidats> candidats = candidatsRepository.findById(id);
	    if (candidats.isPresent()) {
	       return candidats.get();
	    } else {
	       throw new RuntimeException("Candidats not found with id " + id);
	    }
	}

	public Candidats createCandidats(Candidats candidats) {
	    return candidatsRepository.save(candidats);
	}

	public Candidats updateCandidats(Long id, Candidats candidats) {
	    Optional<Candidats> existingCandidats = candidatsRepository.findById(id);
	       if (existingCandidats.isPresent()) {
		       candidats.setId(id);
	             return candidatsRepository.save(candidats);
	       } else {
	          throw new RuntimeException("Candidats not found with id " + id);
	       }
	}

	public void deleteCandidats(Long id) {
	    candidatsRepository.deleteById(id);
	}

}



