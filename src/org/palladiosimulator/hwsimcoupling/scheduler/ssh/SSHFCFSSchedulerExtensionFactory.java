package org.palladiosimulator.hwsimcoupling.scheduler.ssh;

import org.palladiosimulator.hwsimcoupling.scheduler.resources.active.ssh.SimSSHFCFSResource;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;

public class SSHFCFSSchedulerExtensionFactory implements SchedulerExtensionFactory {

	public SSHFCFSSchedulerExtensionFactory() {
		
	}
	
	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores, IResourceTableManager resourceTableManager) {

		return new SimSSHFCFSResource(model, resourceId, resourceId, numberOfCores, resourceTableManager);
	}

}
