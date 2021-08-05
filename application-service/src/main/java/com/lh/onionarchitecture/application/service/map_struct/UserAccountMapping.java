package com.lh.onionarchitecture.application.service.map_struct;

import com.lh.onionarchiecture.object.model.account.UserAccount;
import com.lh.onionarchitecture.application.service.dto.CreateUserAccountRequest;
import org.mapstruct.*;

/** @author lh */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
    typeConversionPolicy = ReportingPolicy.ERROR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAccountMapping {

  @Mappings({
    @Mapping(source = "accountName", target = "accountName"),
    @Mapping(source = "password", target = "password"),
  })
  UserAccount createUserAccountRequestToUserAccount(
      CreateUserAccountRequest createUserAccountRequest);
}
