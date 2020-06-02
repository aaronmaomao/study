package aom.maozj.study.dsf.launch;

import java.util.concurrent.ExecutionException;

import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ISourceLocator;

public class MLaunch extends GdbLaunch {

	public MLaunch(ILaunchConfiguration launchConfiguration, String mode, ISourceLocator locator) {
		super(launchConfiguration, mode, locator);
		// TODO Auto-generated constructor stub
	}

	public void addSimProcess() throws InterruptedException, ExecutionException {
		
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return super.getAdapter(adapter);
	}
}
