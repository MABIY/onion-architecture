package com.lh.onionarchitecture.infrastructure.repository;

import com.lh.onionarchiecture.object.model.account.UserAccount;
import com.lh.onionarchitecture.object.service.account.IUserAccountRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author lh
 */
public interface IUserAccountRepositoryImpl extends IUserAccountRepository , CrudRepository<UserAccount, Long> {
  public Optional<UserAccount> findByAccountName(String accountName);

  public List<UserAccount> findByIdIn(List<Long> ids);
}
