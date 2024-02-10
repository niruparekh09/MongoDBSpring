package com.app.enities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Team {
    @Id
    private String id;
    @NotBlank(message = "Team Name Can't be Empty")
    @Field(name = "Team_Name")
    private String name;
    @NotNull(message = "Bike Field Can't Be Empty")
    private Bikes bike;
}
