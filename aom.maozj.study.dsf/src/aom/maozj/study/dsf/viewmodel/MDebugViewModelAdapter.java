package aom.maozj.study.dsf.viewmodel;

import org.eclipse.cdt.dsf.debug.ui.viewmodel.SteppingController;
import org.eclipse.cdt.dsf.gdb.internal.ui.viewmodel.GdbViewModelAdapter;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.dsf.ui.viewmodel.IVMProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.ui.IDebugUIConstants;

@SuppressWarnings("restriction")
public class MDebugViewModelAdapter extends GdbViewModelAdapter {

	public MDebugViewModelAdapter(DsfSession session, SteppingController controller) {
		super(session, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IVMProvider createViewModelProvider(IPresentationContext context) {
		// TODO Auto-generated method stub
		IVMProvider vmProvider;
		if (context.getId().equals(IDebugUIConstants.ID_DEBUG_VIEW)) {
			vmProvider = new MDebugLaunchVMProvider(this, context, getSession());
			return vmProvider;
		}
		return super.createViewModelProvider(context);
	}

}
