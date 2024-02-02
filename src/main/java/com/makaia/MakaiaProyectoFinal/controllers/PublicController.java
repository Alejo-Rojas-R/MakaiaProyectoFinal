package com.makaia.MakaiaProyectoFinal.controllers;

import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
@Tag(name = "Public Controller", description = "Operations related to public access")
public class PublicController {
    private final UserService userService;

    @Autowired
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    @Operation(summary = "Register a new user")
    public Usuario createUser(@RequestBody UsuarioDTO dto) {
        return userService.createUser(dto);
    }

    @PostMapping("login")
    @Operation(summary = "User login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioDTO dto) {
        return userService.login(dto);
    }
}
