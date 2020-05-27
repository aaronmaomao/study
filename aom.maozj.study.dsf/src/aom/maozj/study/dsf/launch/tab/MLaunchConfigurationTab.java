package aom.maozj.study.dsf.launch.tab;

import org.eclipse.cdt.debug.core.ICDTLaunchConfigurationConstants;
import org.eclipse.cdt.dsf.gdb.IGDBLaunchConfigurationConstants;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MLaunchConfigurationTab extends AbstractLaunchConfigurationTab  implements ILaunchConfigurationTab {
	
	private Composite composite;
	private Text text;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		composite = new Composite(parent, SWT.NONE);
		
		this.setControl(composite);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Path");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_DEBUGGER_START_MODE, IGDBLaunchConfigurationConstants.DEBUGGER_MODE_REMOTE);
		configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_PROGRAM_NAME, "C:\\Users\\zhengjun.mao\\Desktop\\CTest.exe");
		try {
			configuration.doSave();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Main Tab";
	}

}
