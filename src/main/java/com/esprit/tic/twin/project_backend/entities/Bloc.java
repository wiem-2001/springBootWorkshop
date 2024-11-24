package com.esprit.tic.twin.project_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idBloc;
     String nomBloc;
     long capaciteBloc ;
    @ManyToOne
     Foyer foyer;
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    @JsonIgnore
     Set<Chambre> chambreSet;


}
