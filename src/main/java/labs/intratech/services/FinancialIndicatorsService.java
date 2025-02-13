package labs.intratech.services;

import labs.intratech.models.FinancialIndicators;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.FinancialIndicatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class FinancialIndicatorsService  {
	private final FinancialIndicatorsRepository financialIndicatorsRepository;

	@Autowired
	public FinancialIndicatorsService(FinancialIndicatorsRepository financialIndicatorsRepository, FinancialIndicatorsRepository financialIndicatorsRepository1) {
        this.financialIndicatorsRepository = financialIndicatorsRepository1;
	}

	public List<FinancialIndicators> getAllFinancialIndicators() {
	    return financialIndicatorsRepository.findAll();
	}  

	public FinancialIndicators getFinancialIndicatorsById(Long id) {
	    Optional<FinancialIndicators> financialIndicators = financialIndicatorsRepository.findById(id);
	    if (financialIndicators.isPresent()) {
	       return financialIndicators.get();
	    } else {
	       throw new RuntimeException("FinancialIndicators not found with id " + id);
	    }
	}

	public FinancialIndicators createFinancialIndicators(FinancialIndicators financialIndicators) {
	    return financialIndicatorsRepository.save(financialIndicators);
	}

	public FinancialIndicators updateFinancialIndicators(Long id, FinancialIndicators financialindicators) {
	    Optional<FinancialIndicators> existingFinancialIndicators = financialIndicatorsRepository.findById(id);
	       if (existingFinancialIndicators.isPresent()) {
		       financialindicators.setIndicatorId(id);
	             return financialIndicatorsRepository.save(financialindicators);
	       } else {
	          throw new RuntimeException("FinancialIndicators not found with id " + id);
	       }
	}

	public void deleteFinancialIndicators(Long id) {
		financialIndicatorsRepository.deleteById(id);
	}

}



