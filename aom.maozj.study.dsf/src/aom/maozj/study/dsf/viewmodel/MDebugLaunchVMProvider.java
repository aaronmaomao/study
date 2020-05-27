package aom.maozj.study.dsf.viewmodel;

import org.eclipse.cdt.dsf.debug.ui.viewmodel.launch.LaunchRootVMNode;
import org.eclipse.cdt.dsf.debug.ui.viewmodel.launch.StackFramesVMNode;
import org.eclipse.cdt.dsf.gdb.internal.ui.viewmodel.launch.ContainerVMNode;
import org.eclipse.cdt.dsf.gdb.internal.ui.viewmodel.launch.GdbStandardProcessVMNode;
import org.eclipse.cdt.dsf.gdb.internal.ui.viewmodel.launch.LaunchVMProvider;
import org.eclipse.cdt.dsf.gdb.internal.ui.viewmodel.launch.ThreadVMNode;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.dsf.ui.viewmodel.AbstractVMAdapter;
import org.eclipse.cdt.dsf.ui.viewmodel.IRootVMNode;
import org.eclipse.cdt.dsf.ui.viewmodel.IVMNode;
import org.eclipse.cdt.dsf.ui.viewmodel.datamodel.AbstractDMVMProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;

@SuppressWarnings("restriction")
public class MDebugLaunchVMProvider extends LaunchVMProvider {

	public MDebugLaunchVMProvider(AbstractVMAdapter adapter, IPresentationContext presentationContext, DsfSession session) {
		super(adapter, presentationContext, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createNodes() {
		// TODO Auto-generated method stub
		IRootVMNode launchNode = new LaunchRootVMNode(this);
		setRootNode(launchNode);

		// Container node to contain all processes and threads
		IVMNode containerNode = new ContainerVMNode(this, getSession());
		IVMNode processesNode = new GdbStandardProcessVMNode(this);
		addChildNodes(launchNode, new IVMNode[] { containerNode, processesNode });

		IVMNode threadsNode = new MDebugThreadVMNode(this, getSession());
		addChildNodes(containerNode, new IVMNode[] { threadsNode });

		IVMNode stackFramesNode = new StackFramesVMNode(this, getSession());
		addChildNodes(threadsNode, new IVMNode[] { stackFramesNode });
		super.createNodes();
	}

}

@SuppressWarnings("restriction")
class MDebugThreadVMNode extends ThreadVMNode {

	public MDebugThreadVMNode(AbstractDMVMProvider provider, DsfSession session) {
		super(provider, session);
		// TODO Auto-generated constructor stub
	}

}
