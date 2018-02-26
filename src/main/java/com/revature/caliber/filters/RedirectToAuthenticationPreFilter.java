/*
*  A filter is too restrictive to do all of the needed authentication, redirect to authentication service
*  instead
*/
package com.revature.caliber.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

public class RedirectToAuthenticationPreFilter extends ZuulFilter {
 
	@Value("#{systemEnvironment['CALIBER_DEV_MODE']}")
	private boolean debug;

    @Override
    public String filterType() {
        return "pre";
    }
 
    @Override
    public int filterOrder() {
        return 1;
    }
 
    @Override
    public boolean shouldFilter() {
        return true;
    }
 
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //String requestURI = (String) context.get("requestURI");
        String requestURI = request.getRequestURI();
        System.out.println("Request  URI " + requestURI);

        Cookie[] cookies = request.getCookies();
        boolean hasRole = false;
        if(cookies != null && cookies.length > 0) {
        for(Cookie c : cookies)
        {
            if(c.getName().equals("role"))
            {
                hasRole = true;
                System.out.println("Has role cookie");
            }
        }
        }
        
        if(debug) {
          System.out.println("Debug mode");
        if(!hasRole)//if the user has already logged in, they will have a cookie named role
        {
            context.addZuulRequestHeader("preRedirectRequestUri",requestURI );

            //these endpoints should bypass authentication
            if(requestURI.contains("/revoke"))
            {
                context.put("requestURI", "forward:/security/revoke");
            } 
            else if(requestURI.contains("/authenticated_token"))
            {
                context.put("requestURI", "forward:/security/authenticated_token");
            }
            else if(requestURI.contains("/authenticated"))
            {
                context.put("requestURI", "forward:/security/authenticated");
            }
            else if(requestURI.contains("/dto/")) {
              context.put("requestURI", "forward:/security/authorize");
            }
            else
            {
                if(requestURI.length() > 7 && requestURI.substring(requestURI.length() - 8).equals("caliber/"))//ends with caliber/
                context.put("requestURI", "forward:/security/");
            }
        }
        }

        else {

        if(!hasRole)//if the user has already logged in, they will have a cookie named role
        {
            context.addZuulRequestHeader("preRedirectRequestUri",requestURI );

            //these endpoints should bypass authentication
            if(requestURI.contains("/revoke"))
            {
                context.put("requestURI", "forward:/security/revoke");
            } 
            else if(requestURI.contains("/authenticated_token"))
            {
                context.put("requestURI", "forward:/security/authenticated_token");
            }
            else if(requestURI.contains("/authenticated"))
            {
                context.put("requestURI", "forward:/security/authenticated");
            }
            else if(requestURI.contains("/dto/")) {
              context.put("requestURI", "forward:/security/authorize");
            }
            else
            {
                if(requestURI.length() > 7 && requestURI.substring(requestURI.length() - 8).equals("caliber/"))//ends with caliber/
                context.put("requestURI", "forward:/security/");
            }
        }
        else
          context.put("requestURI", "forward:/security/authorize");//anything that is not one of those endpoints goes here
        }

        return null;
    }
 
}
