package com.test.voating.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Controller for demo purpose
 *
 */

@RestController
@RequestMapping(value = "/")
public class SwaggerApiController {

    @RequestMapping(method = RequestMethod.GET)
    @ApiIgnore
    public void openHomePage(HttpServletResponse response) throws IOException {
	response.sendRedirect("/swagger-ui.html#");
    }
}
