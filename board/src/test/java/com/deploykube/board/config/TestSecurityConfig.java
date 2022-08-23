package com.deploykube.board.config;

import com.deploykube.board.domain.UserAccount;
import com.deploykube.board.repository.UserAccountRepository;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(UserAccount.of(
                "parkTest",
                "pw",
                "test1234@sample.com",
                "park-test",
                "test memo"
        )));
    }
}
