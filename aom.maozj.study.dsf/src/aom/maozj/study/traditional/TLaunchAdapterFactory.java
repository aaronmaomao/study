package aom.maozj.study.traditional;

import java.util.Map;

import org.eclipse.cdt.debug.core.model.IConnectHandler;
import org.eclipse.cdt.debug.core.model.IDebugNewExecutableHandler;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.commands.IDisconnectHandler;
import org.eclipse.debug.core.commands.ITerminateHandler;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IColumnPresentationFactory;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelProxyFactory;
import org.eclipse.debug.ui.contexts.ISuspendTrigger;

import aom.maozj.study.traditional.launch.TLaunch;

public class TLaunchAdapterFactory implements IAdapterFactory {
	private Map<Class<?>, Object> adapters;

	public TLaunchAdapterFactory() {
		// TODO Auto-generated constructor stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		// TODO Auto-generated method stub
		if (!(adaptableObject instanceof TLaunch)) {
			return null;
		}

		Object adapter = adapters.get(adapterType);
		if (adapter == null) {
			adapter = createAdapter(adapterType);
			adapters.put(adapterType, adapter);
		}
		return (T) adapter;
	}

	@Override
	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class<?>[] { IElementContentProvider.class, IModelProxyFactory.class, ISuspendTrigger.class,
			IColumnPresentationFactory.class, ITerminateHandler.class, IConnectHandler.class,
			IDisconnectHandler.class, IDebugNewExecutableHandler.class, };
	}

	@SuppressWarnings("unchecked")
	private <T> T createAdapter(Class<T> adapterType) {
		Object adapter = null;
		return (T) adapter;
	}

}
