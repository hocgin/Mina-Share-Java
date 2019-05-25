package in.hocg.zhifou.service;

import in.hocg.zhifou.config.security.JwtToken;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.repository.UserRepository;
import in.hocg.zhifou.support.BaseService;
import in.hocg.zhifou.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.visola.spring.security.tokenfilter.TokenService;

import java.security.Principal;
import java.util.Optional;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseService<User, UserRepository>
        implements UserService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public JwtToken signIn(SignInRo param) {
        String username = param.getUsername();
        String password = param.getPassword();
        
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username,
                password
        );
        
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken(authentication);
        return new JwtToken(token);
    }
    
    @Override
    public User getCurrentUserInfo(Principal principal) {
        String username = principal.getName();
        Optional<User> userOptional = repository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("未找到用户信息");
        }
        User user = userOptional.get();
        
        // 屏蔽密码
        user.setPassword(null);
        return user;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRo param) {
        String username = param.getUsername();
        String password = param.getPassword();
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isPresent()) {
            throw new ApiException("用户已经存在");
        }
        User user = param.asUser();
        
        String passwordEncode = passwordEncoder.encode(password);
        user.setPassword(passwordEncode);
        
        repository.save(user);
    }
    
    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
