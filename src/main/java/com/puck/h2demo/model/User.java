package com.puck.h2demo.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/** Created by burak on 2019-05-19 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonRootName(value = "User")
@JsonPropertyOrder({"fullName"})
@JsonIgnoreProperties(
    //   value = {"birthDate"},
    ignoreUnknown = true)
public class User {
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private long id;

  private String name;
  private String surname;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Date birthDate;

  @JsonGetter("age")
  private int age() {

    LocalDate birthDateLocalDate =
        this.birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    return (int) ChronoUnit.YEARS.between(birthDateLocalDate, LocalDate.now());
  }

  @JsonGetter("fullName")
  public String fullName() {
    return this.name + " " + this.surname;
  }
}
