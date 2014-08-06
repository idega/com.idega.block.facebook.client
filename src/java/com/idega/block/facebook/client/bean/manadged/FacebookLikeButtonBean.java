package com.idega.block.facebook.client.bean.manadged;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(FacebookLikeButtonBean.BEAN_NAME)
@Scope("request")
public class FacebookLikeButtonBean extends DefaultManadgedBean{
	public static final String BEAN_NAME = "facebookLikeButtonBean";
	

	private String urlToLike;
	
	private String layout = "standart";
	
	private String actionType = "like";
	
	private String width;
	
	private Boolean showFriendFaces = Boolean.TRUE;
	
	private Boolean share = Boolean.TRUE;

	public String getUrlToLike() {
		return urlToLike;
	}

	public void setUrlToLike(String urlToLike) {
		this.urlToLike = urlToLike;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Boolean getShowFriendFaces() {
		return showFriendFaces;
	}

	public void setShowFriendFaces(Boolean showFriendFaces) {
		this.showFriendFaces = showFriendFaces;
	}

	public Boolean getShare() {
		return share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}
	
}
