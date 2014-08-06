package com.idega.block.facebook.client.bean.manadged;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(FacebookShareButtinBean.BEAN_NAME)
@Scope("request")
public class FacebookShareButtinBean  extends DefaultManadgedBean{
	public static final String BEAN_NAME = "facebookShareButtinBean";
	

	private String urlToShare;
	
	private String layout = "button";
	


	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getUrlToShare() {
		return urlToShare;
	}

	public void setUrlToShare(String urlToShare) {
		this.urlToShare = urlToShare;
	}

}
