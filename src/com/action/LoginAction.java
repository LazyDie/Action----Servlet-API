package com.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action, ServletResponseAware {

	private String username;
	private String password;
	private HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer)ctx.getApplication().get("counter");
		if(counter == null){
			counter = 1;
		}else{
			counter++;
		}
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUsername());
		if(getUsername().equals("a")&&getPassword().equals("1")){
			Cookie c = new Cookie("user", getUsername());
			c.setMaxAge(60*60);
			response.addCookie(c);
			ctx.put("tip", "µÇÂ¼³É¹¦");
			return SUCCESS;
			
		}
		ctx.put("tip", "µÇÂ¼Ê§°Ü");
		return ERROR;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
