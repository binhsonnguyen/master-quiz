package mst.codegym.viewModel.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
  private String email;
  private String username;
  private String password;
  private String matchingPassword;
}
