package com.arasdenizhan.pizzaordersystem.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fullName;

    @NotNull
    private String mobile;

    @NotNull
    private String address;

    @NotNull
    private String mail;

    @NotNull
    private String pizzaType;
}
