package com.sonny.sa.service;


import com.sonny.sa.entites.Client;
import com.sonny.sa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
   private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        this.clientRepository.save(client);
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientACreer) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientACreer.getEmail());
        if(clientDansLaBDD == null) {
            clientDansLaBDD = this.clientRepository.save(clientACreer);
        }
        return clientDansLaBDD;
    }

    public void modifier(int id, Client client) {
        Client clientDansLaBDD = this.lire(id);
        if (clientDansLaBDD.getId() == client.getId()) {
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
