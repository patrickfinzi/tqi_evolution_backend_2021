package com.tqi.evolution.avaliacao.analisecreditoapi.service;

import com.tqi.evolution.avaliacao.analisecreditoapi.dto.request.ClienteDTO;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Emprestimo;
import com.tqi.evolution.avaliacao.analisecreditoapi.repository.ClienteRepository;
import com.tqi.evolution.avaliacao.analisecreditoapi.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    ClienteDTO usuario = new ClienteDTO();

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public String cadastroCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return "usuario cadastrado com sucesso.";
    }

    public String login(String email, String senha){
        if(verificaUsuarioLogado(usuario)){
            return "usuario ja logado";
        }
        Cliente cliente = clienteRepository.loginCliente(email,senha);
        if(cliente != null){
            setUsuarioLogado(usuario,cliente);
            return "login realizado com sucesso.";
        }
        else {
            return "email ou senha incorretas.";
        }
    }

    public String solicitacaoEmprestimo(Emprestimo emprestimo){
        String verificacao;
        if(!verificaUsuarioLogado(usuario)){
            return "realize o login com email e senha.";
        }
        verificacao = validaEmprestimo(emprestimo);
        if(verificacao.equals("sucesso")){
            emprestimoRepository.save(emprestimo);
            return "emprestimo realizado com sucesso";
        }
        else{
            return verificacao;
        }
    }

    public Boolean validaData(String dataPrimeiraParcela){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataParcela = LocalDate.parse(dataPrimeiraParcela, formatter);
        LocalDate data3meses = LocalDate.now().plusMonths(3);
        return dataParcela.isAfter(data3meses);
    }

    public String validaEmprestimo(Emprestimo emprestimo){
        if(emprestimo.getQuantidade() > 60){
            return "valor maximo de parcelas igual a 60.";
        }
        if(validaData(emprestimo.getDataPrimeiraParcela())){
            return "data primeira parcela pode ser no maximo 3 meses do dia atual";
        }
        return "sucesso";
    }

    public String logout(){
        if(verificaUsuarioLogado(usuario)) {
            usuario.setUsuarioLogadoFlag(0);
            return "Logout realizado com sucesso.";
        }
        else{
            return "não há nenhum usuario logado.";
        }
    }

    public Boolean verificaUsuarioLogado(ClienteDTO usuarioLogado){
        if(usuarioLogado.getUsuarioLogadoFlag() == 1)
            return true;
        else return false;
    }

    public void setUsuarioLogado(ClienteDTO usuarioLogado, Cliente cliente){
        usuarioLogado.setEmail(cliente.getEmail());
        usuarioLogado.setSenha(cliente.getSenha());
        usuarioLogado.setNome(cliente.getNome());
        usuarioLogado.setCpf(cliente.getCpf());
        usuarioLogado.setEndereco(cliente.getEndereco());
        usuarioLogado.setRenda(cliente.getRenda());
        usuarioLogado.setRg(cliente.getRg());
        usuarioLogado.setId(cliente.getId());
        usuarioLogado.setUsuarioLogadoFlag(1);
    }

    public String pagarParcela(Long id){
        Emprestimo e = emprestimoRepository.findById(id).orElse(null);
        if(e.getQuantidade()==0){
            return "emprestimo pago totalmente";
        }
        e.setQuantidade(e.getQuantidade()-1);
        emprestimoRepository.save(e);
        return "pagamento da parcela efetuado com sucesso";
    }

    public List<Emprestimo> listaEmprestimos(){
        /*if(verificaUsuarioLogado(usuario)){
            return "realize o login com email e senha.";
        }*/
        return emprestimoRepository.findByClienteId(usuario.getId());
    }
}
