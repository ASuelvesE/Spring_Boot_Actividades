package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.IJugadoresServices;
import com.example.Actividad5.Actividad5.services.mysql.JugadoresServicesMySQL;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class JugadoresController {

    IJugadoresServices<Jugador> services;

    public JugadoresController(){
        services = new JugadoresServicesMySQL();
    }

    @GetMapping("/jugadores")
    List<Jugador> getAll() {
            return services.getAll();
    }
    @GetMapping("/jugadores/{id}")
    List<Jugador> getById(@PathVariable Long id)  {
            return services.getById(id);
    }
    @PostMapping(value = "/jugadores",produces = MediaType.APPLICATION_JSON_VALUE)
    Jugador save(@RequestBody Jugador jugador) {
            return services.save(jugador);
    }
    @PutMapping(value = "/jugadores/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Jugador update(@PathVariable Long id,@RequestBody Jugador jugador) {
            return services.update(id,jugador);
    }
    @PostMapping(value = "/jugadores/login",produces = MediaType.APPLICATION_JSON_VALUE)
    String login(@RequestBody Jugador jugador){
        String token = getJWTToken(jugador.getNombre());
        //System.err.println(token);
        return token;
    }
    private String getJWTToken(String username) {
        String secretKey = "52c1feb2-579c-41ce-b75b-7b46e578c36d";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
