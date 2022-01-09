package com.tqi.evolution.avaliacao.analisecreditoapi.controller;

import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Emprestimo;
import com.tqi.evolution.avaliacao.analisecreditoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public String cadastroCliente(@RequestBody Cliente cliente){
        return clienteService.cadastroCliente(cliente);
    }

    @GetMapping("/login")
    public String login(@RequestBody Map<String,String> loginUsuario){
        String email = loginUsuario.get("email");
        String senha = loginUsuario.get("senha");
        return clienteService.login(email,senha);
    }

    @PostMapping("/emprestimo")
    public String solicitarEmprestimo(@RequestBody Emprestimo emprestimo){
        return clienteService.solicitacaoEmprestimo(emprestimo);
    }

    @GetMapping("/logout")
    public String logoutUsuario(){
        return clienteService.logout();
    }

    @GetMapping("/listaEmprestimos")
    public List<Emprestimo> listaEmprestimos(){
        return clienteService.listaEmprestimos();
    }

    @PutMapping("/pagarParcela/{id}")
    public String pagarParcela(@PathVariable Long id){
        return clienteService.pagarParcela(id);
    }
}
