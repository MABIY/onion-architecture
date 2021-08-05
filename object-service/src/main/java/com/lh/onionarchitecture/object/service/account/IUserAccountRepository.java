package com.lh.onionarchitecture.object.service.account;


import com.lh.onionarchiecture.object.model.account.UserAccount;

import java.util.List;
import java.util.Optional;

public interface IUserAccountRepository {

    Optional<UserAccount> findByAccountName(String accountName);

  List<UserAccount> findByIdIn(List<Long> ids);

    UserAccount save(UserAccount userAccount);
}
