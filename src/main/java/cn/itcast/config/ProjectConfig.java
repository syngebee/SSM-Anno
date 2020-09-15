package cn.itcast.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ProjectConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        FilterRegistration.Dynamic encodeFilter = servletContext.addFilter("encodeFilter", CharacterEncodingFilter.class);
        encodeFilter.setInitParameter("encoding","utf-8");
        encodeFilter.addMappingForUrlPatterns(null,true,"/*");

/*        Servlet aDefault1 = servletContext.getServlet("default");

        ServletRegistration.Dynamic aDefault = servletContext.addServlet("default",aDefault1);
        aDefault.addMapping("*.html");*/
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class,MybatisConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }




}
