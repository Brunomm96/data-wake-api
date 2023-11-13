import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


//package br.com.datawake.datawakeapi.cors;
//
//import br.com.datawake.datawakeapi.property.AppProperties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CorsFilter implements Filter {
//
//    @Autowired
//    private AppProperties myAppProperties;
//
//    private static final Logger log = LoggerFactory.getLogger(CorsFilter.class);
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    private String originPermitida = "http://localhost:8888;"; // TODO: Configurar para diferentes ambientes
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//
//        originPermitida = myAppProperties.getCorsAllowOrigin();
//        List<String> originsAllow = new ArrayList<String>();
//        originsAllow.addAll( Arrays.asList(originPermitida.split(";")) );
//
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//        if ("OPTIONS".equals(request.getMethod()) && originsAllow.contains( request.getHeader("Origin") ) ) {
//
//            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//            response.setHeader("Access-Control-Max-Age", "3600");
//
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            log.error("Origem não permitida");
//            log.info( " > Origem: " + request.getHeader("Origin") , dateFormat.format(new Date()));
//            log.info( " > Origens permitidas: " + originPermitida , dateFormat.format(new Date()));
//
//            chain.doFilter(req, resp);
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//    }
//
//}
