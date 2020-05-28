package aom.maozj.study.dsf.launch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.eclipse.cdt.dsf.concurrent.Sequence;
import org.eclipse.cdt.dsf.debug.service.IDsfDebugServicesFactory;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunchDelegate;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate2;
import org.eclipse.debug.core.model.ISourceLocator;

import aom.maozj.study.dsf.Activator;
import aom.maozj.study.dsf.services.MDebugServicesFactory;

public class MLaunchConfigurationDelegate extends GdbLaunchDelegate implements ILaunchConfigurationDelegate2 {

	public MLaunchConfigurationDelegate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		// TODO Auto-generated method stub
		ILaunch launch = super.getLaunch(configuration, mode);
		return launch;
	}

	@Override
	protected GdbLaunch createGdbLaunch(ILaunchConfiguration configuration, String mode, ISourceLocator locator) throws CoreException {
		// TODO Auto-generated method stub
		MLaunch launch = new MLaunch(configuration, mode, locator);
		return launch;
	}

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		super.launch(configuration, mode, launch, monitor);
		
	}

	@Override
	protected IDsfDebugServicesFactory newServiceFactory(ILaunchConfiguration config, String version) {
		// TODO Auto-generated method stub
		MDebugServicesFactory servicesFactory = new MDebugServicesFactory(version, config);
		return servicesFactory;
	}

	@Override
	protected Sequence getServicesSequence(DsfSession session, ILaunch launch, IProgressMonitor rm) {
		// TODO Auto-generated method stub
		MLaunchServicesSequence servicesSequence = new MLaunchServicesSequence(session, (MLaunch) launch, rm);
		return servicesSequence;
	}

	@Override
	protected String getPluginID() {
		// TODO Auto-generated method stub
		return Activator.PLUGIN_ID;
	}
}
