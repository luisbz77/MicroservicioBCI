package com.luisbrito.micro.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames={"email"})})
public class User {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;
    private String name;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private List<Phone> phones;
    private Timestamp created;
    private Timestamp modified;
    @JsonProperty(value = "last_login")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp lastLogin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    @JsonProperty(value = "isactive")
    private boolean isActive;
}
