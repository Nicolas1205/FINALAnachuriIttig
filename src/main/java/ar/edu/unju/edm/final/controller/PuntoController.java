package ar.edu.unju.edm.Final.controller;

import ar.edu.unju.edm.Final.model.Punto;
import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.model.Valoracion;
import ar.edu.unju.edm.Final.service.IPuntoService;
import ar.edu.unju.edm.Final.service.ITuristaService;
import ar.edu.unju.edm.Final.service.IValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PuntoController {
		@Autowired
		IPuntoService puntoService;
		@Autowired
		IValoracionService valoracionService;
		@Autowired
		ITuristaService turistaService;
	

		@GetMapping("/addPunto")
		public String getPuntoDeInteres(@RequestParam("codigo") Optional<Integer> codigo, Model model) {
				var punto = codigo.map(puntoService::getPunto).orElse(Optional.of(new Punto()));
				model.addAttribute("punto", punto);
				return "addPunto.html";
		}

		@PostMapping("/addPunto")
		public String postPuntoDeInteres(@ModelAttribute("punto") Punto punto) {
				var turista  = turistaService.getTurista(punto.turista.turistaId);
				punto.setTurista(turista.get());
				turista.get().getPuntos().add(punto);
				puntoService.addPunto(punto);
				return "redirect:/puntos";
		}
		
		@GetMapping("/puntos")
		public String getPuntos(Model model) {
				var puntos = puntoService.getPuntos();
				var turista = turistaService.getTurista(1).orElse(new Turista()); // Just experimental
				model.addAttribute("turista", turista);
				model.addAttribute("puntos", puntos);
				model.addAttribute("valoracion", new Valoracion());
				return "puntos.html";
		}

		@DeleteMapping("/deletepunto")
		public String deletePunto(@RequestParam("codigo") Integer codigo) {
				puntoService.deletePunto(codigo);
				return "redirect:/puntos";
		}

		@GetMapping("/comentarios")
		public String getComentarios(@RequestParam("puntoId") Integer puntoId, Model model) {
				var punto = puntoService.getPunto(puntoId).orElse(new Punto());
				model.addAttribute("punto", punto);
				return "comentarios.html";
		}

		@PostMapping("/addValoracion")
		public String postValoracion(@RequestParam("puntoId") Integer puntoId,
																 @ModelAttribute("valoracion") Valoracion valoracion) {

				var punto = puntoService.getPunto(puntoId).orElse(new Punto());
				var turista = turistaService.getTurista(1).orElse(new Turista());
				valoracion.setPunto(punto);
				valoracion.setTurista(turista);
				valoracion.id.puntoId = punto.puntoId;
				valoracion.id.turistaId = 1;
				valoracionService.addValoracion(valoracion);
				return "redirect:/puntos";
		}
}
