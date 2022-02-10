package org.palladiosimulator.hwsimcoupling.scheduler.resources.active.ssh;

import java.io.Serializable;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.ssh.CommandHandlerSSH;
import org.palladiosimulator.hwsimcoupling.util.DemandCache.RESOURCE;
import org.palladiosimulator.hwsimcoupling.util.impl.DemandCacheImpl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;

public class SimSSHDelayResource extends SimDelayResource {
	
	private static DemandCacheImpl demandCache;
	
	public SimSSHDelayResource(SchedulerModel model, String name, String id,
			IResourceTableManager resourceTableManager) {
		super(model, name, id, resourceTableManager);
		demandCache = DemandCacheImpl.getDemandCacheImpl(new CommandHandlerSSH());
	}
	
	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand) {
		parameterMap.put("coupled", "ssh");
		this.doProcessing(process, resourceServiceID, demandCache.get(parameterMap, RESOURCE.CPU));

    }
}
