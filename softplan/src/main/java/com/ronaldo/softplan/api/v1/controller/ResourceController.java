package com.ronaldo.softplan.api.v1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldo.softplan.api.ApiResponseMessages;
import com.ronaldo.softplan.api.RestPath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController("ResourceController")
@RequestMapping("/")
@Api(tags = "Resources")
public class ResourceController {

    @Value("${resources.source.repo.url}")
    private String repoURL;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/source")
    @ApiOperation(value = "${v1.resources.source}")
    @ApiIgnore
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_200),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public void redirectToSource(HttpServletResponse httpServletResponse) throws IOException {
         httpServletResponse.sendRedirect(repoURL);
    }
}
