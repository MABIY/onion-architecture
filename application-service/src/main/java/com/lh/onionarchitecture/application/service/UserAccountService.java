package com.lh.onionarchitecture.application.service;

import com.lh.onionarchiecture.object.model.account.UserAccount;
import com.lh.onionarchitecture.application.service.dto.CreateUserAccountRequest;
import com.lh.onionarchitecture.application.service.map_struct.UserAccountMapping;
import com.lh.onionarchitecture.object.service.account.IUserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

/** @author lh */
@Service
public class UserAccountService {
  @Autowired private IUserAccountRepository userAccountRepo;
  @Autowired private UserAccountMapping userAccountMapping;

  @Transactional
  public UserAccount createUserAccount(CreateUserAccountRequest createUserAccountRequest) {
    UserAccount userAccount =
        userAccountMapping.createUserAccountRequestToUserAccount(createUserAccountRequest);
    userAccount.setCreateTime(Instant.now());
    return userAccountRepo.save(userAccount);
  }

}
