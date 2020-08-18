package com.vass.movistar.ec.portabilidad.web.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" +  PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=render-photo-document" }, service = MVCRenderCommand.class)
public class RenderPhotoDocument  implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/photoDocument.jsp";
	}

}
