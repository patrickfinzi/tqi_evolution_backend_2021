package com.tqi.evolution.avaliacao.analisecreditoapi.service;

import com.tqi.evolution.avaliacao.analisecreditoapi.dto.request.ClienteDTO;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Emprestimo;
import com.tqi.evolution.avaliacao.analisecreditoapi.repository.ClienteRepository;
import com.tqi.evolution.avaliacao.analisecreditoapi.repository.EmprestimoRepository;
import com.tqi.evolution.avaliacao.analisecreditoapi.utils.ClienteUtils;
import com.tqi.evolution.avaliacao.analisecreditoapi.utils.EmprestimoUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.tqi.evolution.avaliacao.analisecreditoapi.utils.ClienteUtils.createFakeDTO;
import static com.tqi.evolution.avaliacao.analisecreditoapi.utils.ClienteUtils.createFakeEntity;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EmprestimoRepository emprestimoRepository;

    @Mock
    ClienteDTO usuario = ClienteUtils.createFakeDTO();

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void testGivenClienteThenReturnSuccessMessage(){
        Cliente expectedCliente = createFakeEntity();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(expectedCliente);
        String sucesso = clienteService.cadastroCliente(expectedCliente);
        String expectedSuccessMessage = "usuario cadastrado com sucesso.";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenClienteThenReturnUsuarioLogadoSuccessMessage(){
        Cliente expectedCliente = createFakeEntity();
        ClienteDTO expectedUsuario = createFakeDTO();
        String email = "patrick@gmail.com";
        String senha = "mg123";
        when(clienteRepository.loginCliente(any(String.class), any(String.class))).thenReturn(expectedCliente);
        String sucesso = clienteService.login(email,senha);
        String expectedSuccessMessage = "login realizado com sucesso.";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenClienteThenReturnUsuarioLogadoErroMessage(){
        Cliente expectedCliente = null; //createFakeEntity();
        String email = "patrick1@gmail.com";
        String senha = "mg1234";
        when(clienteRepository.loginCliente(any(String.class), any(String.class))).thenReturn(expectedCliente);
        String sucesso = clienteService.login(email,senha);
        String expectedSuccessMessage = "email ou senha incorretas.";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenEmprestimoThenReturnSuccessMessage(){
        Emprestimo expectedEmprestimo = EmprestimoUtils.createFakeEntity();
        ClienteDTO expectedUsuario = ClienteUtils.createFakeDTO();
        when(usuario.getUsuarioLogadoFlag()).thenReturn(1);
        when(emprestimoRepository.save(any(Emprestimo.class))).thenReturn(expectedEmprestimo);
        String sucesso = clienteService.solicitacaoEmprestimo(expectedEmprestimo);
        String expectedSuccessMessage = "emprestimo realizado com sucesso";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenEmprestimoThenReturnPagamentoSuccessMessage(){
        Emprestimo expectedEmprestimo = EmprestimoUtils.createFakeEntity();
        when(emprestimoRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expectedEmprestimo));
        when(emprestimoRepository.save(any(Emprestimo.class))).thenReturn(expectedEmprestimo);
        String sucesso = clienteService.pagarParcela(1L);
        String expectedSuccessMessage = "pagamento da parcela efetuado com sucesso";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    /*@Test
    void testGivenEmprestimoThenReturnListaEmprestimoSuccessMessage(){
        List<Emprestimo> lista = new ArrayList<>();
        Emprestimo expectedEmprestimo = EmprestimoUtils.createFakeEntity();
        lista.add(expectedEmprestimo);
        when(emprestimoRepository.findByClienteId(any(Long.class))).thenReturn(lista);
    }*/

}
