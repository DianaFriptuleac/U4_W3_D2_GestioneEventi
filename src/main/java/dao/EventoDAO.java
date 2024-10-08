package dao;

import eventi.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    //l'oggetto
    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save
    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transizione
        transaction.begin();  //faccio partire la transition
        entityManager.persist(newEvento);  //agg. nuovo evento ma non e ancora nel DB.
        transaction.commit();  //chiudo transizione e mando l'elevto al DB
        System.out.println("L'evento " + newEvento.getTitolo() + " è stato aggiunto con successo!");

    }
}
