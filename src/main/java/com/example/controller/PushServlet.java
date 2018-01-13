package com.example.controller;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;

@WebServlet(name = "PushServlet", urlPatterns = "/pushHandler")
public class PushServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        PushBuilder pushBuilder = httpServletRequest.newPushBuilder();

        if(pushBuilder != null) {
            pushBuilder.path("images/test.jpg");
            pushBuilder.addHeader("content-type", "image/png");
            pushBuilder.push();
            httpServletResponse.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        doPost(httpServletRequest, httpServletResponse);
    }
}
