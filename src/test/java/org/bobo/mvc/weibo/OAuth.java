package org.bobo.mvc.weibo;

import org.apache.commons.httpclient.HttpClient;

public class OAuth
{
	protected String authorizeURL;
	protected String accessTokenURL;
	protected String clientID;
	protected String clientSecret;
	protected String redirectURI;
	protected String showUserURL;
	
	protected HttpClient httpClient;
	
	public OAuth(String clientID, String clientSecret, String redirectURI){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.redirectURI = redirectURI;
		this.httpClient = new HttpClient();
	}
	
	/**
	 * 获得认证跳转链接
	 * @param state
	 * @return
	 * @author junyong.yang
	 * @created 2012-11-28 下午4:08:16
	 */
	public String authorize(String state)
	{
		return this.authorizeURL + "?client_id=" + this.clientID + "&redirect_uri=" + this.redirectURI
				+ "&response_type=code&state=" + state;
	}
	
	/**
	 * 通过返回code获得AccessToken
	 * @param code
	 * @return
	 * @author junyong.yang
	 * @created 2012-11-28 下午4:08:36
	 */
	protected String getAccessTokenByCode(String code){
		return "";
	}
	
	/**
	 * 通过Uid获得该用户的UserProfile
	 * @param accessToken
	 * @param Uid
	 * @return
	 * @author junyong.yang
	 * @created 2012-11-28 下午4:08:55
	 */
	protected String getUserProfileByUid(String accessToken, String Uid){
		return "";
	}
	
	/**
	 * 通过code获取UserInfo
	 * 获得code之后直接调用此方法
	 * @param code
	 * @return
	 * @author junyong.yang
	 * @created 2012-11-28 下午4:09:38
	 */
	public UserInfo getUserInfoByCode(String code) {
		return null;
	}
}
