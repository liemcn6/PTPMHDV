package com.example.ecommerce.controller;

import com.example.ecommerce.dto.RegistrationRequestDto;
import com.example.ecommerce.exception.ApiRequestException;
import com.example.ecommerce.exception.EmailException;
import com.example.ecommerce.exception.InputFieldException;
import com.example.ecommerce.exception.PasswordException;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final UserMapper userMapper;
    private final ControllerUtils controllerUtils;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequestDto user, BindingResult bindingResult) {
        controllerUtils.captchaValidation(user.getCaptcha());

        if (controllerUtils.isPasswordDifferent(user.getPassword(), user.getPassword2())) {
            throw new PasswordException("Passwords do not match.");
        }
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        if (!userMapper.registerUser(user)) {
            throw new EmailException("Email is already used.");
        }
        return ResponseEntity.ok("User successfully registered.");
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        if (!userMapper.activateUser(code)) {
            throw new ApiRequestException("Activation code not found.", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok("User successfully activated.");
        }
    }
}
