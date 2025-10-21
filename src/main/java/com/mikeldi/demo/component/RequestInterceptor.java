package com.mikeldi.demo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("requestTimeInterceptor")
public class RequestInterceptor implements HandlerInterceptor {

	private static final Log LOG = LogFactory.getLog(RequestInterceptor.class);

	//Se ejecuta antes 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long tiempo= System.currentTimeMillis();
		request.setAttribute("tiempoInicial", tiempo);
		LOG.info("Tiempo inicial " + tiempo);
		return true;
	}

	// Se ejecuta despues
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex)
			throws Exception {
		
		long tiempoInicial= (long) request.getAttribute("tiempoInicial");
		long tiempoFinal= System.currentTimeMillis();
		LOG.info("Tiempo  final: " + tiempoFinal + "Tiempo Total: " + (tiempoFinal-tiempoInicial) + " ms");
	}

	
	
	
	

}
