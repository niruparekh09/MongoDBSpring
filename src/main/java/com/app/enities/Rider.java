package com.app.enities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "Rider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Rider {
    @Id
    private String id;
    @NotBlank(message = "First Name Cannot Be Null")
    private String firstName;
    @NotBlank(message = "Last Name Cannot Be Null")
    private String lastName;
    @NotBlank(message = "Short Credential Cannot Be Null")
    private String shortCred;
    @DBRef
    private Team teamName;
    private List<Sponsor> sponsorList;
}
