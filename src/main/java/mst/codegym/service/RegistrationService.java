package mst.codegym.service;

import mst.codegym.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface RegistrationService {
  @Transactional
  User register(User user);
}
