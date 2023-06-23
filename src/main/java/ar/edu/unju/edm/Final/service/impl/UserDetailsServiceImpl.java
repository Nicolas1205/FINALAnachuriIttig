package ar.edu.unju.edm.Final.service.impl;

import ar.edu.unju.edm.Final.TuristaDetails;
import ar.edu.unju.edm.Final.repository.TuristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TuristaRepository turistaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var turista = turistaRepository.findTuristaByNombre(username);
        System.out.println(turista);

        return new TuristaDetails(turista.orElseThrow(() -> new UsernameNotFoundException("no se encontró el nombre de usuario")));
    }
}
