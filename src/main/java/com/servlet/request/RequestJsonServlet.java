package com.servlet.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.dto.HelloDto;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestJsonServlet",urlPatterns = "/request-json")
public class RequestJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("json = " + json);

        HelloDto helloDto = objectMapper.readValue(json, HelloDto.class);
        System.out.println("helloDto = " + helloDto.getName());
    }

}
