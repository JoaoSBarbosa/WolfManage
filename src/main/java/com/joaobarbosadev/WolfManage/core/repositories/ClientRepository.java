package com.joaobarbosadev.WolfManage.core.repositories;

import com.joaobarbosadev.WolfManage.core.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
