package org.palladiosimulator.hwsimcoupling.consumers.ssh;

import org.palladiosimulator.hwsimcoupling.consumers.ErrorConsumer;
import org.palladiosimulator.hwsimcoupling.exceptions.DemandCalculationFailureException;

public class ErrorDetector implements ErrorConsumer {
	
	@Override
	public void accept(String t) throws DemandCalculationFailureException{
		if (t.contains("Error")) {
			throw new DemandCalculationFailureException(t);
		}
		
	}
	
}


