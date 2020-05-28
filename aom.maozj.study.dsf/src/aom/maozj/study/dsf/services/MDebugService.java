package aom.maozj.study.dsf.services;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.ImmediateRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.service.AbstractDsfService;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.dsf.service.IDsfService;
import org.osgi.framework.BundleContext;

import aom.maozj.study.dsf.Activator;

public class MDebugService extends AbstractDsfService implements IDsfService {

	public MDebugService(DsfSession session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(RequestMonitor rm) {
		// TODO Auto-generated method stub
		super.initialize(new ImmediateRequestMonitor(rm) {
			@Override
			protected void handleSuccess() {
				// TODO Auto-generated method stub
				super.handleSuccess();
			}
		});
	}

	@Override
	public void shutdown(RequestMonitor rm) {
		// TODO Auto-generated method stub
		unregister();
		super.shutdown(rm);
	}

	@Override
	protected BundleContext getBundleContext() {
		// TODO Auto-generated method stub
		return Activator.getDefault().getBundle().getBundleContext();
	}
	

	public void canCustomService(IDMContext ctx, DataRequestMonitor<Boolean> rm) {
		
	}
	
	public void doCustomService(IDMContext ctx, DataRequestMonitor<String> rm) {
	}

}
