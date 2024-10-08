package Diana_Friptuleac.eventi;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity  //la classe dovra essere mappata ad una tabella. Hibernate- crea la tabella
@Table(name = "all_events")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titolo_evento", nullable = false)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate data;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "max_nr_partecipanti")
    private int max_nr_partecipanti;

    public Evento() {
        //il costruttore vuoto per JPA
    }

    public Evento(String titolo, LocalDate data, String descrizione, EventoType tipo_evento, int max_nr_partecipanti) {
        this.titolo = titolo;
        this.data = data;
        this.descrizione = descrizione;
        this.max_nr_partecipanti = max_nr_partecipanti;
    }

    public long getId() {
        return id;
    }

    public int getMax_nr_partecipanti() {
        return max_nr_partecipanti;
    }

    public void setMax_nr_partecipanti(int max_nr_partecipanti) {
        this.max_nr_partecipanti = max_nr_partecipanti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", max_nr_partecipanti=" + max_nr_partecipanti +
                '}';
    }
}
