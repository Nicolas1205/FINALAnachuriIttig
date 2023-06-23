package ar.edu.unju.edm.Final.service.impl;

import ar.edu.unju.edm.Final.model.Comentario;
import ar.edu.unju.edm.Final.model.ComentarioKey;
import ar.edu.unju.edm.Final.service.IComentarioService;
import ar.edu.unju.edm.Final.repository.ComentarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Service
public class ComentarioService implements IComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;

    public void addComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public Optional<Comentario> getComentario(ComentarioKey codigo) {
        return comentarioRepository.findById(codigo);
    }

}
