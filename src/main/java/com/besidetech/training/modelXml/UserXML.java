package com.besidetech.training.modelXml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "myt_user")
@JacksonXmlRootElement(localName = "User")
public class UserXML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)

    private Integer id; // identificiatore dell'utente

    @JacksonXmlProperty
    @Column(name = "created")
    private Date created; // rappresenta la data di creazione dell utente

    @JacksonXmlProperty
    @Column(name = "created_by")
    private Integer created_by;// rappresenta l id dell'user che effettua la creazione

    @JacksonXmlProperty
    @Column(name = "last_upd")
    private Date last_update; // data ultimo aggiornamento

    @JacksonXmlProperty
    @Column(name = "last_upd_by")
    private Integer last_update_by; // rappresenta l id dell user che effettua l'aggiornamento

    @JacksonXmlProperty
    @Column(name = "username")
    private String username; // è anche considerata una chiave primaria all interno del db

    @JacksonXmlProperty
    @Column(name = "password")
    private String password; // il campo non puo essere vuoto

    @JacksonXmlProperty
    @Column(name = "email")
    private String email;

    @JacksonXmlProperty
    @Column(name = "active")
    private Boolean active; // da verificare la reale funzione

    @JacksonXmlProperty
    @Column(name = "name")
    private String name; // nome utente

    @JacksonXmlProperty
    @Column(name = "surname")
    private String surname; // congome utente

    @JacksonXmlProperty
    @Column(name = "gender")
    private char gender; // sesso dell utente

    @JacksonXmlProperty
    @Column(name = "level")
    private String level; // livello gerarchico dell utente

    @JacksonXmlProperty
    @Column(name = "phone")
    private String phone; // numero di telefono fisso dell utente

    @JacksonXmlProperty
    @Column(name = "mobile")
    private String mobile; // numero di telefono mobile dell utente

    @JacksonXmlProperty
    @Column(name = "load_cost")
    private Float load_cost; // CHIEDERE A COSA SERVE

    @JacksonXmlProperty
    @Column(name = "bill_code")
    private Integer bill_code; // CHIEDERE A COSA SERVE

    @JacksonXmlProperty
    @Column(name = "seat_charge")
    private Float seat_charge;// CHIEDERE A COSA SERVE

    @JacksonXmlProperty
    @Column(name = "daily_hours")
    private Float daily_hours; // ore giornaliere di lavoro dell'utente

    @JacksonXmlProperty
    @Column(name = "profile_id")
    private Integer profile_id; // CHIEDERE A COSA SERVE

    @JacksonXmlProperty
    @Column(name = "note")
    private String note; //

    @JacksonXmlProperty
    @Column(name = "confirm_key")
    private String confirm_key; //

    @JacksonXmlProperty
    @Column(name = "avatar")
    private String avatar;

    @JacksonXmlProperty
    @Column(name = "page_size")
    private Integer page_size;

    @JacksonXmlProperty
    @Column(name = "notifications")
    private String notifications;


//    @JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    Set<UserProject> projects = new TreeSet<>();
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    Set<Charge> charges = new TreeSet<>();
//
}
