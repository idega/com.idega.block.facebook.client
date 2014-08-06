package com.idega.block.twitter.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.idega.block.facebook.client.FacebookConstants;
import com.idega.core.business.DefaultSpringBean;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWContext;
import com.idega.util.CoreUtil;

@Service(TwitterRequestBean.BEAN_NAME)
@Scope("request")
public class TwitterRequestBean extends DefaultSpringBean {
	public static final String BEAN_NAME = "twitterRequestBean";

	
	private IWContext iwc = null;
	
	private IWResourceBundle iwrb = null;
	
	private boolean twitterScriptAdded;
	
	
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

	public boolean isTwitterScriptAdded() {
		return twitterScriptAdded;
	}

	public void setTwitterScriptAdded(boolean twitterScriptAdded) {
		this.twitterScriptAdded = twitterScriptAdded;
	}
	
	public String getTwitterScriptAddedSet(){
		twitterScriptAdded = true;
		return null;
	}
}
