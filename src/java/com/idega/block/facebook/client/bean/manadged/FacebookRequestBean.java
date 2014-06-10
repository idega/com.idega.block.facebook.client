package com.idega.block.facebook.client.bean.manadged;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.idega.block.facebook.client.FacebookConstants;
import com.idega.core.business.DefaultSpringBean;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWContext;
import com.idega.util.CoreUtil;

@Service(FacebookRequestBean.BEAN_NAME)
@Scope("request")
public class FacebookRequestBean extends DefaultSpringBean {
	public static final String BEAN_NAME = "facebookRequestBean";

	
	private IWContext iwc = null;
	
	private IWResourceBundle iwrb = null;
	
	private boolean facebookScriptAdded;
	
	
	public IWResourceBundle getIwrb() {
		if(iwrb == null){
			IWContext iwc = getIwc();
			iwrb = iwc.getIWMainApplication().getBundle(FacebookConstants.IW_BUNDLE_IDENTIFIER).getResourceBundle(iwc);
		}
		return iwrb;
	}
	
	public IWContext getIwc() {
		if(iwc == null){
			iwc = CoreUtil.getIWContext();
		}
		return iwc;
	}

	public void setIwc(IWContext iwc) {
		this.iwc = iwc;
	}

	public boolean isFacebookScriptAdded() {
		return facebookScriptAdded;
	}

	public void setFacebookScriptAdded(boolean facebookScriptAdded) {
		this.facebookScriptAdded = facebookScriptAdded;
	}
	
	public String getFacebookScriptAddedSet(){
		facebookScriptAdded = true;
		return null;
	}

}
