package org.gastpro.api.owners.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.accounts.domain.Account;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnore
    private Account accounts;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "phone_number", length = Integer.MAX_VALUE)
    private String phoneNumber;

}