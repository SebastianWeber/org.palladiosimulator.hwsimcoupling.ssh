package org.palladiosimulator.hwsimcoupling.scheduler.ssh;

import org.palladiosimulator.hwsimcoupling.scheduler.resources.active.ssh.SimSSHDelayResource;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;

public class SSHDelaySchedulerExtensionFactory implements SchedulerExtensionFactory {

	public SSHDelaySchedulerExtensionFactory() {
		
	}
	
	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores, IResourceTableManager resourceTableManager) {

		return new SimSSHDelayResource(model, resourceId, resourceId, resourceTableManager);
	}

}
