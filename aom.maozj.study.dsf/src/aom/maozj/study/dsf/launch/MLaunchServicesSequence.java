package aom.maozj.study.dsf.launch;

import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.gdb.launching.ServicesLaunchSequence;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IProgressMonitor;

import aom.maozj.study.dsf.services.MDebugService;

public class MLaunchServicesSequence extends ServicesLaunchSequence{
	private GdbLaunch launch;

	public MLaunchServicesSequence(DsfSession session, GdbLaunch launch, IProgressMonitor pm) {
		super(session, launch, pm);
		this.launch = launch;
	}
	
	@Override
	public Step[] getSteps() {
		// TODO Auto-generated method stub
		Step[] origin_steps = super.getSteps();
		Step[] steps = new Step[origin_steps.length+1];
		System.arraycopy(origin_steps, 0, steps, 0, origin_steps.length);
		steps[origin_steps.length]=new Step() {
			@Override
			public void execute(RequestMonitor rm) {
				// TODO Auto-generated method stub
				launch.getServiceFactory().createService(MDebugService.class, launch.getSession()).initialize(rm);
			}
		};
		return steps;
	}

}
