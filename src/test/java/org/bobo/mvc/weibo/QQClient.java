package org.bobo.mvc.weibo;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class QQClient extends OAuth
{
	public QQClient(String clientID, String clientSecret, String redirectURI){
		super(clientID, clientSecret, redirectURI);
		this.authorizeURL = "https://graph.qq.com/oauth2.0/authorize";
		this.accessTokenURL = "https://graph.qq.com/oauth2.0/token";
		this.showUserURL = "https://graph.qq.com/user/get_user_info";
	}
	
	@Override
	public String authorize(String state)
	{
		return super.authorize(state)+"&scope=get_user_info";
	}
	
	@Override
	protected String getAccessTokenByCode(String code)
	{
		String url = this.accessTokenURL + "?client_id=" + clientID + "&client_secret=" + clientSecret
				+ "&grant_type=authorization_code&redirect_uri=" + redirectURI + "&code=" + code;
		GetMethod getMethod = new GetMethod(url);
		try
		{
			int status = httpClient.executeMethod(getMethod);
			if(status == HttpStatus.SC_OK){
				String body = getMethod.getResponseBodyAsString();
				body = body.substring(body.indexOf("=")+1, body.indexOf("&"));
				return body;
			}
		}
		catch (HttpException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * 通过accessToken获取当前用户Uid
	 * @param accessToken
	 * @return
	 * @author junyong.yang
	 * @created 2012-11-28 下午4:10:17
	 */
	private String getUserUid(String accessToken){
		String url = "https://graph.qq.com/oauth2.0/me?access_token=" + accessToken;
		GetMethod getMethod = new GetMethod(url);
		try
		{
			int status = httpClient.executeMethod(getMethod);
			if(status == HttpStatus.SC_OK){
				String body = getMethod.getResponseBodyAsString();
				//System.out.println(body);
				body = body.substring(body.indexOf("openid\":\"")+9, body.lastIndexOf("\""));
				return body;
			}
		}
		catch (HttpException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		return "";
	}
	
	@Override
	protected String getUserProfileByUid(String accessToken, String Uid){
		String url = this.showUserURL + "?access_token=" + accessToken + "&openid=" + Uid + "&oauth_consumer_key=" + clientID + "&format=json";
		GetMethod getMethod = new GetMethod(url);
		try
		{
			int status =httpClient.executeMethod(getMethod);
			if(status == HttpStatus.SC_OK){
				String body = getMethod.getResponseBodyAsString();
				return body;
			}
		}
		catch (HttpException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public UserInfo getUserInfoByCode(String code)
	{
		String accessToken = getAccessTokenByCode(code);
		if(accessToken.equals("")){
			return null;
		}
		
		String uId = getUserUid(accessToken);
		
		if(uId.equals("")){
			return null;
		}
		
		String profileStr = getUserProfileByUid(accessToken, uId);
		System.out.println(profileStr);
		if(profileStr.equals("")){
			return null;
		}
		
		UserInfo userInfo = new UserInfo();
		try
		{
			JSONObject json =  JSONObject.parseObject(profileStr);
			String nickName = json.getString("nickname");
			String profileImageUrl = json.getString("figureurl_qq_1");
			userInfo.setuId(uId);
			userInfo.setAccessToken(accessToken);
			userInfo.setProfileImageUrl(profileImageUrl);
			userInfo.setNickName(nickName);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return userInfo;
	}
}
