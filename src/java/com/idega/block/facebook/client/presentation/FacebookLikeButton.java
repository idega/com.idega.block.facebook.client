package com.idega.block.facebook.client.presentation;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.idega.block.facebook.client.FacebookConstants;
import com.idega.block.facebook.client.bean.manadged.FacebookLikeButtonBean;
import com.idega.facelets.ui.FaceletComponent;
import com.idega.idegaweb.IWBundle;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.util.URIUtil;
import com.idega.util.expression.ELUtil;

public class FacebookLikeButton extends IWBaseComponent {

	private FacebookLikeButtonBean manadgedBean;
	private String urlToLike;
	
	private String layout;
	
	private String actionType;
	
	private String width;
	
	private Boolean showFriendFaces = true;
	
	private Boolean share = true;
	
	private String type = "iframe";

	private FacesContext facesContext;
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		setFacesContext(context);
		FacebookLikeButtonBean manadgedBean = getManadgedBean();
		manadgedBean.setActionType(getActionType());
		manadgedBean.setLayout(getLayout());
		manadgedBean.setShare(getShare());
		manadgedBean.setUrlToLike(getUrlToLike());
		manadgedBean.setWidth(getWidth());
		super.encodeBegin(context);
	}
	
	private void addIframe(IWContext iwc){
		FacebookLikeButtonBean manadgedBean = getManadgedBean();
		Layer main = new Layer();
		add(main);
		main.setStyleClass("fb_iframe_widget");
		Layer iframe = new Layer("iframe");
		main.add(iframe);
		URIUtil uri = new URIUtil();
		uri.setUri("//www.facebook.com/plugins/like.php");
		uri.setParameter("href", manadgedBean.getUrlToLike());
		uri.setParameter("layout", manadgedBean.getLayout());
		uri.setParameter("action", manadgedBean.getActionType());
		uri.setParameter("show-faces","true" );
		uri.setParameter("share", String.valueOf(manadgedBean.getShare()));
		iframe.setMarkupAttribute("src", uri.getUri());
		iframe.setMarkupAttribute("scrolling", "no");
		iframe.setMarkupAttribute("frameborder", "0");
		iframe.setMarkupAttribute("allowTransparency", "true");
		iframe.setStyleAttribute("border", "none");
		iframe.setStyleAttribute("overflow", "hidden");
		iframe.setStyleAttribute("width", manadgedBean.getWidth());
		iframe.setStyleAttribute("height", "80px");
	}
	private void addHTML5(IWContext iwc){
		IWBundle bundle = iwc.getIWMainApplication().getBundle(FacebookConstants.IW_BUNDLE_IDENTIFIER);
		FaceletComponent facelet = (FaceletComponent)iwc.getApplication().createComponent(FaceletComponent.COMPONENT_TYPE);
		facelet.setFaceletURI(bundle.getFaceletURI("like.xhtml"));
		add(facelet);
	}
	@Override
	protected void initializeComponent(FacesContext context) {
		super.initializeComponent(context);
		
		IWContext iwc = IWContext.getIWContext(context);
		
		String type = getType();
		if(type.equals("iframe")){
			addIframe(iwc);
		}else{
			addHTML5(iwc);
		}
	}

	private FacebookLikeButtonBean getManadgedBean(){
		if(manadgedBean == null){
			manadgedBean = ELUtil.getInstance().getBean(FacebookLikeButtonBean.BEAN_NAME);
		}
		return manadgedBean;
	}

	public String getUrlToLike() {
		if(urlToLike != null){
			return urlToLike;
		}
		urlToLike = getExpressionValue(getFacesContext(),"urlToLike");
		return urlToLike;
	}

	public void setUrlToLike(String urlToLike) {
		this.urlToLike = urlToLike;
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

	public String getActionType() {
		if(actionType != null){
			return actionType;
		}
		actionType = getExpressionValue(getFacesContext(),"actionType");
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getWidth() {
		if(width != null){
			return width;
		}
		width = getExpressionValue(getFacesContext(),"width");
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Boolean getShowFriendFaces() {
		if(showFriendFaces != null){
			return showFriendFaces;
		}
		showFriendFaces = getExpressionValue(getFacesContext(),"showFriendFaces");
		return showFriendFaces;
	}

	public void setShowFriendFaces(Boolean showFriendFaces) {
		this.showFriendFaces = showFriendFaces;
	}

	public Boolean getShare() {
		if(share != null){
			return share;
		}
		share = getExpressionValue(getFacesContext(),"share");
		return share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}

	@Override
	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public String getType() {
		if(type != null){
			return type;
		}
		type = getExpressionValue(getFacesContext(),"type");
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
