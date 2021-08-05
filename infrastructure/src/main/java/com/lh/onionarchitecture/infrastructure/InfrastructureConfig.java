package com.lh.onionarchitecture.infrastructure;

import com.lh.onionarchitecture.infrastructure.repository.PackageMarker;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lh
 */
@EnableJpaRepositories(basePackageClasses = PackageMarker.class)
public class InfrastructureConfig {
}
