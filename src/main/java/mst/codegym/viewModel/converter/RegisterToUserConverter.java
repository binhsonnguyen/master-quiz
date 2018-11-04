package mst.codegym.viewModel.converter;

import mst.codegym.model.User;
import mst.codegym.model.UsernamePasswordCredential;
import mst.codegym.viewModel.account.Register;
import org.springframework.core.convert.converter.Converter;

public class RegisterToUserConverter implements Converter<Register, User> {
  public User convert(Register source) {
    return User.builder()
        .email(source.getEmail())
        .usernamePasswordCredential(UsernamePasswordCredential.builder()
            .username(source.getUsername())
            .password(source.getPassword())
            .build())
        .build();
  }
}
