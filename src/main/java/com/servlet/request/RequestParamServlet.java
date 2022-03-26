package com.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("<전체 조회>");

        request.getParameterNames()
                .asIterator().forEachRemaining(
                        paramName -> System.out.println(paramName + " = " +request.getParameter(paramName)));


        System.out.println("<단일 조회>");

        String name = request.getParameter("name");
        System.out.println("name = " + name);

        
        System.out.println("<중복되는 이름이 2개 이상인 경우>");
        
        String[] names = request.getParameterValues("name");
        for (String name2 : names) {
            System.out.println(name2);
        }




    }

}
