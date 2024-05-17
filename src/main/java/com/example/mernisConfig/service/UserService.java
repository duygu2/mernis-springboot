package com.example.mernisConfig.service;

import com.example.mernisConfig.mernis.JSGKPSPublicSoap;
import com.example.mernisConfig.model.User;
import com.example.mernisConfig.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public String registerUser(User user) throws Exception {
        JSGKPSPublicSoap client= new JSGKPSPublicSoap();
        boolean isRealPerson = client.TCKimlikNoDogrula(
                Long.valueOf(user.getIdentityNumber()),
                user.getFirstName(),
                user.getLastName(),
                Integer.valueOf(user.getBirthOfDateYear().getYear()));

        if(isRealPerson){
            userRepository.save(user);
            System.out.println(user.getBirthOfDateYear().getYear());
            return "kullanıcı başarıyla kayıt edildi";

        }
        else {
            System.out.println(user.getBirthOfDateYear().getYear());
            throw new IllegalArgumentException("Kullanıcı bulunamadı!");
        }

    }

}
