package aom.maozj.study.dsf;

import org.eclipse.cdt.dsf.gdb.internal.ui.GdbAdapterFactory;
import org.eclipse.cdt.dsf.gdb.internal.ui.GdbSessionAdapters;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerInputProvider;

import aom.maozj.study.dsf.viewmodel.MDebugViewModelAdapter;

@SuppressWarnings("restriction")
public class MDebugAdapterFactory extends GdbAdapterFactory implements IAdapterFactory {

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		// TODO Auto-generated method stub
		return super.getAdapter(adaptableObject, adapterType);
	}

	@Override
	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return super.getAdapterList();
	}

	@Override
	protected GdbSessionAdapters createGdbSessionAdapters(ILaunch launch, DsfSession session) {
		// TODO Auto-generated method stub
		return new MSessionAdapter(launch, session, getAdapterList());
	}

}

@SuppressWarnings("restriction")
class MSessionAdapter extends GdbSessionAdapters {

	public MSessionAdapter(ILaunch launch, DsfSession session, Class<?>[] launchAdapterTypes) {
		super(launch, session, launchAdapterTypes);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> T createModelAdapter(Class<T> adapterType, ILaunch launch, DsfSession session) {
		// TODO Auto-generated method stub
		T modelAdapter;
		if (IViewerInputProvider.class.isAssignableFrom(adapterType)) {
			modelAdapter = (T) new MDebugViewModelAdapter(session, getSteppingController());
		}
		modelAdapter = super.createModelAdapter(adapterType, launch, session);
		return modelAdapter;
	}

}
