package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Comentario;
import ar.edu.unju.edm.Final.model.ComentarioKey;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IComentarioService {
    void addComentario(Comentario comentario);

    Optional<Comentario> getComentario(ComentarioKey codigo);
    //public void deleteComentario(int codigo);
}
