package labs.intratech.services;

import labs.intratech.models.Postes;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.PostesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PostesService  {
	private final PostesRepository postesRepository;

	@Autowired
	public PostesService(PostesRepository postesRepository) {
	    this.postesRepository = postesRepository;
	}

	public List<Postes> getAllPostes() {
	    return postesRepository.findAll();
	}  

	public Postes getPostesById(Long id) {
	    Optional<Postes> postes = postesRepository.findById(id);
	    if (postes.isPresent()) {
	       return postes.get();
	    } else {
	       throw new RuntimeException("Postes not found with id " + id);
	    }
	}

	public Postes createPostes(Postes postes) {
	    return postesRepository.save(postes);
	}

	public Postes updatePostes(Long id, Postes postes) {
	    Optional<Postes> existingPostes = postesRepository.findById(id);
	       if (existingPostes.isPresent()) {
		       postes.setId(id);
	             return postesRepository.save(postes);
	       } else {
	          throw new RuntimeException("Postes not found with id " + id);
	       }
	}

	public void deletePostes(Long id) {
	    postesRepository.deleteById(id);
	}

}



