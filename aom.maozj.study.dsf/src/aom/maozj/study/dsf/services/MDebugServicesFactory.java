package aom.maozj.study.dsf.services;

import org.eclipse.cdt.dsf.debug.service.IDsfDebugServicesFactory;
import org.eclipse.cdt.dsf.gdb.service.GdbDebugServicesFactory;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.debug.core.ILaunchConfiguration;

public class MDebugServicesFactory extends GdbDebugServicesFactory implements IDsfDebugServicesFactory {

	public MDebugServicesFactory(String version, ILaunchConfiguration config) {
		super(version, config);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V createService(Class<V> clazz, DsfSession session, Object... optionalArguments) {
		// TODO Auto-generated method stub
		V service;
		if(clazz.isAssignableFrom(MDebugService.class)) {
			return (V) new MDebugService(session);
		}
		service = super.createService(clazz, session, optionalArguments);
		return service;
	}

}
