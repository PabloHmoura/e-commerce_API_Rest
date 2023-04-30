package br.com.ada.pablo.livraria.pessoa;

import br.com.ada.pablo.livraria.transacao.Transacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PessoaServiceTest {

    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pessoaService = new PessoaService(pessoaRepository);
    }

    @Test
    void testAddPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João da Silva");
        pessoa.setNascimento(new Date());
        pessoa.setCpf("123.456.789-10");
        pessoa.setEmail("joao.silva@gmail.com");
        pessoa.setTelefone("(11) 98765-4321");
        pessoa.setSaldo(new BigDecimal("1000.00"));

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa pessoaSalva = pessoaService.add(pessoa);

        assertEquals(pessoa, pessoaSalva);
    }

    @Test
    void testListAllPessoas() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        pessoa1.setNome("João da Silva");
        pessoa1.setNascimento(new Date());
        pessoa1.setCpf("123.456.789-10");
        pessoa1.setEmail("joao.silva@gmail.com");
        pessoa1.setTelefone("(11) 98765-4321");
        pessoa1.setSaldo(new BigDecimal("1000.00"));

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoa2.setNome("Maria Santos");
        pessoa2.setNascimento(new Date());
        pessoa2.setCpf("109.876.543-21");
        pessoa2.setEmail("maria.santos@gmail.com");
        pessoa2.setTelefone("(11) 98765-4321");
        pessoa2.setSaldo(new BigDecimal("500.00"));

        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> pessoasSalvas = pessoaService.listAll();

        assertEquals(pessoas, pessoasSalvas);
    }

    @Test
    void testFindById() {
        Long id = 1L;

        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("João da Silva");
        pessoa.setNascimento(new Date());
        pessoa.setCpf("123.456.789-10");
        pessoa.setEmail("joao.silva@gmail.com");
        pessoa.setTelefone("(11) 98765-4321");
        pessoa.setSaldo(new BigDecimal("1000.00"));

        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> pessoaEncontrada = pessoaService.findById(id);

        assertEquals(pessoa, pessoaEncontrada.orElse(null));
    }
}