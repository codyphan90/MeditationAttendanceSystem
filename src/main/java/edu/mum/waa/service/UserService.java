package edu.mum.waa.service;

import edu.mum.waa.constant.MessageConstant;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.request.LoginRequest;
import edu.mum.waa.response.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    private Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest)  {
        if (StringUtils.isEmpty(loginRequest.getUserId())) return new LoginResponse(MessageConstant.USER_ID_OR_PASSWORD_IS_BLANK);
        if (StringUtils.isEmpty(loginRequest.getPassword())) return new LoginResponse(MessageConstant.USER_ID_OR_PASSWORD_IS_BLANK);
        UserEntity userEntity = userRepository.findByUserIdEquals(loginRequest.getUserId());
        if (userEntity == null) return new LoginResponse(MessageConstant.USER_ID_OR_PASSWORD_IS_INVALID);
        if (!loginRequest.getPassword().equals(userEntity.getPassword())) return new LoginResponse(MessageConstant.USER_ID_OR_PASSWORD_IS_INVALID);
        logger.info("UserName [{}] login successfully", loginRequest.getUserId());
        return new LoginResponse(true,MessageConstant.LOGIN_SUCCESS.replaceAll("@@user@@", loginRequest.getUserId().toString()));
    }
}
