package mst.codegym.web.controller;

import mst.codegym.model.User;
import mst.codegym.model.UsernamePasswordCredential;
import mst.codegym.service.RegistrationService;
import mst.codegym.viewModel.account.Register;
import mst.codegym.viewModel.converter.RegisterToUserConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringJUnitJupiterConfig(RegistrationControllerTestConfig.class)
class RegistrationControllerTest {

  private static String sampleEmail;
  private static String sampleUsername;
  private static String samplePassword;
  private static String sampleMatchingPassword;
  private static String sampleNotMatchingPassword;
  private static Register sampleCredential;
  private static User sampleUser;

  static {
    sampleEmail = "user@domain.net";
    sampleUsername = "username";
    samplePassword = "secret";
    sampleMatchingPassword = "secret";
    sampleNotMatchingPassword = "_secret";

    sampleCredential = Register
        .builder()
        .email(sampleEmail)
        .username(sampleUsername)
        .password(samplePassword)
        .matchingPassword(sampleMatchingPassword)
        .build();

    sampleUser = User.builder()
        .email(sampleEmail)
        .usernamePasswordCredential(UsernamePasswordCredential.builder()
            .username(sampleUsername)
            .password(samplePassword)
            .build())
        .build();
  }

  @InjectMocks
  private RegistrationController registrationController;

  @Autowired
  private RegistrationService registrationService;

  @Autowired
  private RegisterToUserConverter registerToUserConverter;

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
  }

  @Test
  void testAccessAccountRegistrationPage() throws Exception {
    mockMvc
        .perform(get("/register"))
        .andExpect(status().isOk())
        .andExpect(view().name("account/register"))
        .andExpect(model().attribute("account", Register.builder().build()));
  }

  @Test
  void testCreateAccount() throws Exception {
    when(registrationService
        .register(registerToUserConverter
            .convert(sampleCredential)))
        .thenReturn(sampleUser);

    mockMvc
        .perform(post("/register")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("email", sampleEmail)
            .param("username", sampleUsername)
            .param("password", "123456")
            .param("matchingPassword", sampleMatchingPassword))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/index"));
  }
}
