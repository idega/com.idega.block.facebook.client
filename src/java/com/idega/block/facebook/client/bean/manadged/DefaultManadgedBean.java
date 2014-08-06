package com.idega.block.facebook.client.bean.manadged;

import org.springframework.beans.factory.annotation.Autowired;

import com.idega.core.business.DefaultSpringBean;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWContext;

public class DefaultManadgedBean extends DefaultSpringBean{

	@Autowired
	private FacebookRequestBean facebookRequestBean;

	
	public IWResourceBundle getIwrb() {
		return facebookRequestBean.getIwrb();
	}
	
	public IWContext getIwc() {
		return facebookRequestBean.getIwc();
	}

	public void setIwc(IWContext iwc) {
		facebookRequestBean.setIwc(iwc);
	}
	
	public boolean isFacebookScriptAdded(){
		return facebookRequestBean.isFacebookScriptAdded();
	}
	
	public void setFacebookScriptAdded(boolean added){
		facebookRequestBean.setFacebookScriptAdded(added);
	}
}

