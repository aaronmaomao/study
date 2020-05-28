package aom.maozj.study.dsf.launch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ISourceLocator;

import aom.maozj.study.dsf.services.MDebugService;

public class MLaunch extends GdbLaunch {

	public MLaunch(ILaunchConfiguration launchConfiguration, String mode, ISourceLocator locator) {
		super(launchConfiguration, mode, locator);
		// TODO Auto-generated constructor stub
	}

	public void addSimProcess() throws InterruptedException, ExecutionException {
		
	}

}
