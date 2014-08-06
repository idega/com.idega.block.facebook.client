package com.idega.block.facebook.client.presentation;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.idega.block.facebook.client.FacebookConstants;
import com.idega.block.facebook.client.bean.manadged.FacebookShareButtinBean;
import com.idega.facelets.ui.FaceletComponent;
import com.idega.idegaweb.IWBundle;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.util.expression.ELUtil;

public class FacebookShareButton extends IWBaseComponent {

	private FacebookShareButtinBean manadgedBean;
	private String urlToShare;
	
	private String layout;
	
	private FacesContext facesContext;
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		setFacesContext(context);
		FacebookShareButtinBean manadgedBean = getManadgedBean();
		manadgedBean.setUrlToShare(getUrlToShare());
		manadgedBean.setLayout(getLayout());
		super.encodeBegin(context);
	}
	
	private void addHTML5(IWContext iwc){
		IWBundle bundle = iwc.getIWMainApplication().getBundle(FacebookConstants.IW_BUNDLE_IDENTIFIER);
		FaceletComponent facelet = (FaceletComponent)iwc.getApplication().createComponent(FaceletComponent.COMPONENT_TYPE);
		facelet.setFaceletURI(bundle.getFaceletURI("share.xhtml"));
		add(facelet);
	}
	@Override
	protected void initializeComponent(FacesContext context) {
		super.initializeComponent(context);
		
		IWContext iwc = IWContext.getIWContext(context);
		
		addHTML5(iwc);
	}

	private FacebookShareButtinBean getManadgedBean(){
		if(manadgedBean == null){
			manadgedBean = ELUtil.getInstance().getBean(FacebookShareButtinBean.BEAN_NAME);
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
