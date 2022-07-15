package com.wjtc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-balance-service/balancos")
public class BalancoController {
    private final Balancos balancos;

    @Autowired
    public BalancoController(Balancos balancos) {
        this.balancos = balancos;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findByAccountId(@RequestParam String idConta) {
        final var balanceOptional = balancos.findByAccountId(idConta);
        final var returnMap = new HashMap<String, Object>();
        returnMap.put("os.name", System.getenv().getOrDefault("HOSTNAME", "unknown"));
        balanceOptional.ifPresent(balance -> returnMap.put("balance", balance));
        return ResponseEntity.status(HttpStatus.OK).body(returnMap);
    }
}