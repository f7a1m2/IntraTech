package labs.intratech.services;

import labs.intratech.models.Offres;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.OffresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class OffresService  {
	private final OffresRepository offresRepository;

	@Autowired
	public OffresService(OffresRepository offresRepository) {
	    this.offresRepository = offresRepository;
	}

	public List<Offres> getAllOffres() {
	    return offresRepository.findAll();
	}  

	public Offres getOffresById(Long id) {
	    Optional<Offres> offres = offresRepository.findById(id);
	    if (offres.isPresent()) {
	       return offres.get();
	    } else {
	       throw new RuntimeException("Offres not found with id " + id);
	    }
	}

	public Offres createOffres(Offres offres) {
	    return offresRepository.save(offres);
	}

	public Offres updateOffres(Long id, Offres offres) {
	    Optional<Offres> existingOffres = offresRepository.findById(id);
	       if (existingOffres.isPresent()) {
		       offres.setOffresid(id);
	             return offresRepository.save(offres);
	       } else {
	          throw new RuntimeException("Offres not found with id " + id);
	       }
	}

	public void deleteOffres(Long id) {
	    offresRepository.deleteById(id);
	}

}



