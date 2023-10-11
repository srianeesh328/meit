package com.example.demo.controller;

import com.example.demo.services.LoginService;
import com.example.demo.services.LoginServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(
        path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    private LoginService loginService;

    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public @ResponseBody ResponseEntity<String> login(){
        return ResponseEntity.ok().body("hola");
    }
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<LoginResponse> login (
            @Valid @RequestBody LoginRequest loginParam,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) { 
            LoginResponse loginResponse = new LoginResponse("KO");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loginResponse);
        }

        LoginServiceResult loginServiceResult = loginService.authenticate(loginParam.getUser(), loginParam.getPassword());

        if(loginServiceResult.getFlag()) {
            String token = loginServiceResult.getAccess_token();
            //String access_token = new String(Base64.getDecoder().decode(token));
            LoginResponse loginResponse = new LoginResponse("OK", token);
            return ResponseEntity.ok().body(loginResponse);
        } else {
            LoginResponse loginResponse = new LoginResponse("KO");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }
}
