package com.sonny.sa.entites;


import com.sonny.sa.enums.TypeSentiment;
import jakarta.persistence.*;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String texte;
    private TypeSentiment type;

    // PERSIST: Ici on sauvegarde le client s'il existe puis on récupère son id et on injecte comme
    // clé étrangère dans le sentiment
    //MERGE: si le client existe deja dans la base de données on ne va pas le recréer
    // on va juste fusionner les informations
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
