package com.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.dto.HelloDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet" , urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloDto helloDto = new HelloDto();
        helloDto.setName("minwoo");
        helloDto.setAge(33);

        String s = objectMapper.writeValueAsString(helloDto);
        resp.getWriter().write(s);    }
}
