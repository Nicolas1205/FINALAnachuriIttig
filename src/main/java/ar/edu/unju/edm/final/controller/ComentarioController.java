package ar.edu.unju.edm.Final.controller;

import ar.edu.unju.edm.Final.model.Comentario;
import ar.edu.unju.edm.Final.model.ComentarioKey;
import ar.edu.unju.edm.Final.service.IComentarioService;
import ar.edu.unju.edm.Final.service.IPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import ar.edu.unju.edm.Final.model.Punto;

@Controller
public class ComentarioController {
		@Autowired
		IComentarioService comentarioService;
		@Autowired
		IPuntoService puntoService;

		
		@GetMapping("/addComentario")
		public String getComentario(@RequestParam("puntoId") Integer puntoId, Model model) {
				
				var punto = puntoService.getPunto(puntoId).orElse(new Punto());
				var comentario = new Comentario();
				model.addAttribute("punto", punto);
				model.addAttribute("comentario", comentario);
				model.addAttribute("comentarioKey", new ComentarioKey());
				return "addComentario.html";
		}
		@PostMapping("/addComentario")
		public String postComentario(@RequestParam("puntoId") Integer puntoId,
																 @ModelAttribute("comentario") Comentario comentario) {


				var punto = puntoService.getPunto(puntoId).orElse(new Punto());
				comentario.punto.puntoId = punto.puntoId;
				comentario.turista.turistaId = comentario.id.turistaId;
				comentarioService.addComentario(comentario);
				//punto.getComentarios().add(comentrio);
				return String.format("redirect:/comentarios?puntoId=%d", punto.puntoId);
		}
		
}

