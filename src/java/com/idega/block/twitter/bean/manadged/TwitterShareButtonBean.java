package com.idega.block.twitter.bean.manadged;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(TwitterShareButtonBean.BEAN_NAME)
@Scope("request")
public class TwitterShareButtonBean  extends DefaultManadgedBean{
	public static final String BEAN_NAME = "twitterShareButtonBean";
	

	private String urlToShare;
	
	private String layout = "standart";
	


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
