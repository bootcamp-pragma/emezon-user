package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.infra.constants.RestApiConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiConstants.API_PING)
public class PingController {

    @GetMapping
    public String ping() {
        return "pong";
    }

}
