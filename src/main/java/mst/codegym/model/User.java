package mst.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(fetch = FetchType.LAZY,
      cascade = CascadeType.ALL,
      mappedBy = "user",
      orphanRemoval = true)
  private UsernamePasswordCredential usernamePasswordCredential;

  private String email;

  private String firstName;

  private String midName;

  private String lastName;

  private String address;

  private String phone;
}
