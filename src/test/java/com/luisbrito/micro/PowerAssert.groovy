package com.luisbrito.micro

import com.luisbrito.micro.entity.UserEntity
import com.luisbrito.micro.exceptions.InvalidEmailException
import com.luisbrito.micro.model.User
import com.luisbrito.micro.repository.UserRepository
import com.luisbrito.micro.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest()
class PowerAssert extends Specification{

    void 'Obtendremos un valor determinado' () {
        given:
            def stubbedRepository = Stub(UserRepository){
                findByEmail(_) >> new UserEntity("venezolano@gmail.ve")
            }
        when:
        def user = stubbedRepository.findByEmail("venezolano@gmail.ve")
        then:
            user.email = 'venezolano@gmail.ve'
    }
}