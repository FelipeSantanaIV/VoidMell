package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoPacienteDTO(@NotNull
                                          Long id,
                                          String nome,
                                          String telefone,
                                          DadosEnderecoDTO endereco) {
}