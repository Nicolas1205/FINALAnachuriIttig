package ar.edu.unju.edm.Final;

import ar.edu.unju.edm.Final.repository.PuntoRepository;
import ar.edu.unju.edm.Final.service.IPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalAnachuriIttigApplication implements CommandLineRunner {

    @Autowired
    IPuntoService puntoService;

    public static void main(String[] args) {
        SpringApplication.run(FinalAnachuriIttigApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(puntoService.getPuntosWithAverage());
    }
}
