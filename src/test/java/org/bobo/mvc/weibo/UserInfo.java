package org.bobo.mvc.weibo;

public class UserInfo
{
	/**
	 * 验证后的accessToken
	 */
	private String accessToken;
	
	/**
	 * 用户在该网站唯一id
	 */
	private String uId;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 用户头像链接
	 */
	private String profileImageUrl;
	
	public String getAccessToken()
	{
		return accessToken;
	}
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	/**
	 * 用户在该网站唯一id
	 */
	public String getuId()
	{
		return uId;
	}
	
	/**
	 * 用户在该网站唯一id
	 */
	public void setuId(String uId)
	{
		this.uId = uId;
	}
	
	/**
	 * 用户昵称
	 */
	public String getNickName()
	{
		return nickName;
	}
	
	/**
	 * 用户昵称
	 */
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	
	/**
	 * 用户头像链接
	 */
	public String getProfileImageUrl()
	{
		return profileImageUrl;
	}
	
	/**
	 * 用户头像链接
	 */
	public void setProfileImageUrl(String profileImageUrl)
	{
		this.profileImageUrl = profileImageUrl;
	}
	
	@Override
	public String toString()
	{
		return "nickName:" + nickName + " uId:" + uId + " accessToken:" + accessToken + " profileImageUrl:"
				+ profileImageUrl;
	}
}
