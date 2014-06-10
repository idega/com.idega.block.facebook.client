package com.idega.block.twitter.presentation;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.idega.block.facebook.client.FacebookConstants;
import com.idega.block.twitter.bean.manadged.TwitterShareButtonBean;
import com.idega.facelets.ui.FaceletComponent;
import com.idega.idegaweb.IWBundle;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.util.expression.ELUtil;

public class TwitterShareButton extends IWBaseComponent {

	private TwitterShareButtonBean manadgedBean;
	private String urlToShare;
	
	private String layout;
	
	private FacesContext facesContext;
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		setFacesContext(context);
		TwitterShareButtonBean manadgedBean = getManadgedBean();
		manadgedBean.setUrlToShare(getUrlToShare());
		manadgedBean.setLayout(getLayout());
		super.encodeBegin(context);
	}
	
	private void addHTML5(IWContext iwc){
		IWBundle bundle = iwc.getIWMainApplication().getBundle(FacebookConstants.IW_BUNDLE_IDENTIFIER);
		FaceletComponent facelet = (FaceletComponent)iwc.getApplication().createComponent(FaceletComponent.COMPONENT_TYPE);
		facelet.setFaceletURI(bundle.getFaceletURI("twitter-share.xhtml"));
		add(facelet);
	}
	@Override
	protected void initializeComponent(FacesContext context) {
		super.initializeComponent(context);
		
		IWContext iwc = IWContext.getIWContext(context);
		
		addHTML5(iwc);
	}

	private TwitterShareButtonBean getManadgedBean(){
		if(manadgedBean == null){
			manadgedBean = ELUtil.getInstance().getBean(TwitterShareButtonBean.BEAN_NAME);
		}
		return manadgedBean;
	}



	@Override
	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	
	public String getLayout() {
		if(layout != null){
			return layout;
		}
		layout = getExpressionValue(getFacesContext(),"layout");
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getUrlToShare() {
		if(urlToShare != null){
			return urlToShare;
		}
		urlToShare = getExpressionValue(getFacesContext(),"urlToShare");
		return urlToShare;
	}

	public void setUrlToShare(String urlToShare) {
		this.urlToShare = urlToShare;
	}

}
