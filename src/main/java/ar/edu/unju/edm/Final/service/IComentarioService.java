package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Comentario;
import ar.edu.unju.edm.Final.model.ComentarioKey;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;
import java.util.List;

@Service
public interface IComentarioService {
		public void addComentario(Comentario comentario);
		public Optional<Comentario> getComentario(ComentarioKey codigo);
		//public void deleteComentario(int codigo);
}
