package com.lh.onionarchitecture.web.api.controller;

import com.lh.onionarchiecture.object.model.account.UserAccount;
import com.lh.onionarchitecture.application.service.UserAccountService;
import com.lh.onionarchitecture.application.service.dto.CreateUserAccountRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Transactional
@Api(tags = "账户接口")
public class AccountCtrl {

  @Autowired private UserAccountService userAccountService;

  @PostMapping("/accounts")
  @ApiOperation("创建账户")
  public UserAccount createUserAccount(
      @Validated @RequestBody CreateUserAccountRequest createUserAccountRequest) {
    return userAccountService.createUserAccount(createUserAccountRequest);
  }
}
