package med.voll.api.domain.consulta;

import org.springframework.http.ResponseEntity;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
