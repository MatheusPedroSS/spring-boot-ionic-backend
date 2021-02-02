package com.matheuspedro.cursomc.services;

import java.util.Optional;

import com.matheuspedro.cursomc.domain.Pedido;
import com.matheuspedro.cursomc.repositories.PedidoRepository;
import com.matheuspedro.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }

}
