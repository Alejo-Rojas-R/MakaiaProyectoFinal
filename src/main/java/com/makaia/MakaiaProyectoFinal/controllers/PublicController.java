package com.makaia.MakaiaProyectoFinal.controllers;

import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/public")
public class PublicController {
    private final UserService userService;

    @Autowired
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public Usuario createUser(@RequestBody UsuarioDTO dto) {
        return userService.createUser(dto);
    }
}
