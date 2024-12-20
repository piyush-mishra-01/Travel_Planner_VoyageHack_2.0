package com.voyage.userManagementService.component;

import com.voyage.userManagementService.entity.Role;
import com.voyage.userManagementService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private  RoleRepository roleRepository;



    @Override
    public void run(String... args) {
        // Add data to the database
        if (roleRepository.count() <3) { // Ensure data is added only once
            Role role1=new Role();
            role1.setRoleName("ROLE_ADMIN");

            Role role2=new Role();
            role2.setRoleName("ROLE_AGENT");

            Role role3=new Role();
            role3.setRoleName("ROLE_TRAVELER");
            roleRepository.save(role1);
            roleRepository.save(role2);
            roleRepository.save(role3);


        }
    }
}

