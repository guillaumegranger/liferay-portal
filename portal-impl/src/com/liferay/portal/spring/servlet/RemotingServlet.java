/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.spring.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.context.TunnelApplicationContext;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Brian Wing Shun Chan
 */
public class RemotingServlet extends DispatcherServlet {

	public static final String CONTEXT_CLASS =
		TunnelApplicationContext.class.getName();

	public static final String CONTEXT_CONFIG_LOCATION =
		"/WEB-INF/remoting-servlet.xml,/WEB-INF/remoting-servlet-ext.xml";

	@Override
	public Class<?> getContextClass() {
		try {
			return Class.forName(CONTEXT_CLASS);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return null;
	}

	@Override
	public String getContextConfigLocation() {
		return CONTEXT_CONFIG_LOCATION;
	}

	private static Log _log = LogFactoryUtil.getLog(RemotingServlet.class);

}