package com.matheuspedro.cursomc.services;

import java.util.Optional;

import com.matheuspedro.cursomc.domain.Cliente;
import com.matheuspedro.cursomc.repositories.ClienteRepository;
import com.matheuspedro.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }

}
