package labs.intratech.services;

import labs.intratech.models.HistoriquePerformanceEmploye;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.HistoriquePerformanceEmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriquePerformanceEmployeService  {
	private final HistoriquePerformanceEmployeRepository historiquePerformanceEmployeRepository;

	@Autowired
	public HistoriquePerformanceEmployeService(HistoriquePerformanceEmployeRepository historiquePerformanceEmployeRepository) {
	    this.historiqueperformanceemployeRepository = historiquePerformanceEmployeRepository;
	}

	public List<HistoriquePerformanceEmploye> getAllHistoriquePerformanceEmploye() {
	    return historiquePerformanceEmployeRepository.findAll();
	}  

	public HistoriquePerformanceEmploye getHistoriquePerformanceEmployeById(Long id) {
	    Optional<HistoriquePerformanceEmploye> historiquePerformanceEmploye = historiquePerformanceEmployeRepository.findById(id);
	    if (historiquePerformanceEmploye.isPresent()) {
	       return historiquePerformanceEmploye.get();
	    } else {
	       throw new RuntimeException("HistoriquePerformanceEmploye not found with id " + id);
	    }
	}

	public HistoriquePerformanceEmploye createHistoriquePerformanceEmploye(HistoriquePerformanceEmploye historiquePerformanceEmploye) {
	    return historiquePerformanceEmployeRepository.save(historiquePerformanceEmploye);
	}

	public HistoriquePerformanceEmploye updateHistoriquePerformanceEmploye(Long id, HistoriquePerformanceEmploye historiqueperformanceemploye) {
	    Optional<HistoriquePerformanceEmploye> existingHistoriquePerformanceEmploye = historiqueperformanceemployeRepository.findById(id);
	       if (existingHistoriquePerformanceEmploye.isPresent()) {
		       historiqueperformanceemploye.setHistoriquePerformanceEmployeid(id);
	             return historiqueperformanceemployeRepository.save(historiqueperformanceemploye);
	       } else {
	          throw new RuntimeException("HistoriquePerformanceEmploye not found with id " + id);
	       }
	}

	public void deleteHistoriquePerformanceEmploye(Long id) {
	    historiqueperformanceemployeRepository.deleteById(id);
	}

}



