package labs.intratech.services;

import labs.intratech.models.ReponsesPossibles;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ReponsesPossiblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ReponsesPossiblesService  {
	private final ReponsesPossiblesRepository reponsesPossiblesRepository;

	@Autowired
	public ReponsesPossiblesService(ReponsesPossiblesRepository reponsesPossiblesRepository, ReponsesPossiblesRepository reponsesPossiblesRepository1) {
        this.reponsesPossiblesRepository = reponsesPossiblesRepository1;
	}

	public List<ReponsesPossibles> getAllReponsesPossibles() {
	    return reponsesPossiblesRepository.findAll();
	}  

	public ReponsesPossibles getReponsesPossiblesById(Long id) {
	    Optional<ReponsesPossibles> reponsesPossibles = reponsesPossiblesRepository.findById(id);
	    if (reponsesPossibles.isPresent()) {
	       return reponsesPossibles.get();
	    } else {
	       throw new RuntimeException("ReponsesPossibles not found with id " + id);
	    }
	}

	public ReponsesPossibles createReponsesPossibles(ReponsesPossibles reponsesPossibles) {
	    return reponsesPossiblesRepository.save(reponsesPossibles);
	}

	public ReponsesPossibles updateReponsesPossibles(Long id, ReponsesPossibles reponsespossibles) {
	    Optional<ReponsesPossibles> existingReponsesPossibles = reponsesPossiblesRepository.findById(id);
	       if (existingReponsesPossibles.isPresent()) {
		       reponsespossibles.setId(id);
	             return reponsesPossiblesRepository.save(reponsespossibles);
	       } else {
	          throw new RuntimeException("ReponsesPossibles not found with id " + id);
	       }
	}

	public void deleteReponsesPossibles(Long id) {
		reponsesPossiblesRepository.deleteById(id);
	}

}



