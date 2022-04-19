package com.example.openapi.controller;

import com.example.openapi.MyUrl;
import com.example.openapi.MyUrlConfigurationProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Servers({
        @Server(url="/abc", description = "new desc")
})
public class HomeController {

    @Value("${my.urlStr}")
    private String urlStr;

   // @Value("${peter.urls}")
   // private List<MyUrl> urls;
    @Autowired
    private MyUrlConfigurationProperties myconfig;

    @GetMapping("/hello/{name}")
    @Operation(summary = "Just say hello to people")
    @Tag(name = "Greeting")
    @ApiResponses(value = {
            @ApiResponse(description = "good one", responseCode = "200", content = { @Content(mediaType = "application/json")}),
            @ApiResponse(description = "bad request", responseCode = "400", content = @Content)
    })
    @Tags(value = {
            @Tag(name = "Greeting"),
            @Tag(name = "For beginner")
    })
    public String sayHello(@PathVariable String name) {
        return "hello " + name;
    }

    @GetMapping("/myurls")
    public String getUrls() {
        return this.urlStr;
        //return Arrays.asList(urls);
    }

    @GetMapping("/peterurls")
    public List<MyUrl> getPeterUrls() {
        return this.myconfig.getUrls();
    }
}


