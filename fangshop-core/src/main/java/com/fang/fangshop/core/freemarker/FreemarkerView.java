package com.fang.fangshop.core.freemarker;

import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.ext.servlet.IncludePage;
import freemarker.template.SimpleHash;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class FreemarkerView extends FreeMarkerView {
    @Override
    protected SimpleHash buildTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        SimpleHash hash = super.buildTemplateModel(model, request, response);
        hash.put(FreemarkerServlet.KEY_INCLUDE, new IncludePage(request, response));
        return hash;
    }
}