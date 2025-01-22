package labs.intratech.services;

import labs.intratech.models.Employes;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class EmployesService  {
	private final EmployesRepository employesRepository;

	@Autowired
	public EmployesService(EmployesRepository employesRepository) {
	    this.employesRepository = employesRepository;
	}

	public List<Employes> getAllEmployes() {
	    return employesRepository.findAll();
	}  

	public Employes getEmployesById(Long id) {
	    Optional<Employes> employes = employesRepository.findById(id);
	    if (employes.isPresent()) {
	       return employes.get();
	    } else {
	       throw new RuntimeException("Employes not found with id " + id);
	    }
	}

	public Employes createEmployes(Employes employes) {
	    return employesRepository.save(employes);
	}

	public Employes updateEmployes(Long id, Employes employes) {
	    Optional<Employes> existingEmployes = employesRepository.findById(id);
	       if (existingEmployes.isPresent()) {
		       employes.setEmployesid(id);
	             return employesRepository.save(employes);
	       } else {
	          throw new RuntimeException("Employes not found with id " + id);
	       }
	}

	public void deleteEmployes(Long id) {
	    employesRepository.deleteById(id);
	}

}



