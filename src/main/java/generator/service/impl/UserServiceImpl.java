package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.model.entity.User;
import generator.service.UserService;
import com.yupi.springbootinit.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author hsw237045657
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-09-19 21:40:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




