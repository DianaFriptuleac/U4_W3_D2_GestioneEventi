package Diana_Friptuleac;

import Diana_Friptuleac.dao.EventoDAO;
import Diana_Friptuleac.eventi.Evento;
import Diana_Friptuleac.eventi.EventoType;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager(); //creo un unico EntityManager per tutto l'app.
        EventoDAO eventDB = new EventoDAO(em);

        //-------------------------------Save-------------------------------------------------------
        Evento evento1 = new Evento("Panda", LocalDate.of(2024, 12, 10),
                "Salviamo i Panda!", EventoType.PUBBLICO, 200);

        Evento evento2 = new Evento("Foreste", LocalDate.of(2024, 11, 15),
                "Proteggiamo le foreste", EventoType.PUBBLICO, 300);

        Evento evento3 = new Evento("Mare", LocalDate.of(2025, 1, 20),
                "Ripuliamo il mare", EventoType.PUBBLICO, 150);

        Evento evento4 = new Evento("Animali", LocalDate.of(2024, 10, 25),
                "Difendiamo gli animali selvatici", EventoType.PRIVATO, 100);

        Evento evento5 = new Evento("Città", LocalDate.of(2024, 9, 30),
                "Verde in città", EventoType.PUBBLICO, 250);

        Evento evento6 = new Evento("Montagna", LocalDate.of(2024, 12, 5),
                "Salviamo la montagna", EventoType.PRIVATO, 80);

        eventDB.save(evento1);
        eventDB.save(evento2);
        eventDB.save(evento3);
        eventDB.save(evento4);
        eventDB.save(evento5);
        eventDB.save(evento6);

        //-------------------------------GetById-------------------------------------------------------
        try {
            Evento eventById = eventDB.getById(6);
            System.out.println("Evendo id: " + eventById);


            eventDB.delete(6);
            //  eventDB.delete(1);
            eventDB.delete(3);


        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        //-------------------------------Delete-------------------------------------------------------
       /* try {
            eventDB.delete(6);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }*/


        em.close();
        emf.close();
    }
}
