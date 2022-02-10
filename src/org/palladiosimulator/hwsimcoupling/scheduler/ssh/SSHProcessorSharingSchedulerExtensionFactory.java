package org.palladiosimulator.hwsimcoupling.scheduler.ssh;

import org.palladiosimulator.hwsimcoupling.scheduler.resources.active.ssh.SimSSHProcessorSharingResource;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;

public class SSHProcessorSharingSchedulerExtensionFactory implements SchedulerExtensionFactory {

	public SSHProcessorSharingSchedulerExtensionFactory() {
		
	}
	
	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores, IResourceTableManager resourceTableManager) {

		return new SimSSHProcessorSharingResource(model, resourceId, resourceId, numberOfCores, resourceTableManager);
	}

}
