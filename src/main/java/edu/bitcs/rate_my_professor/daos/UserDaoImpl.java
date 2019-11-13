package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isEmailExisted(String uEmail) {
        if(userMapper.numberOfEmail(uEmail)==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isPasswordCorrect(String uEmail, String uPassword) {
        String uPasswordInDb = userMapper.getuPasswordByuEmail(uEmail);

        if(uPasswordInDb.equals(uPassword)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insertUser(User user) {
        if(userMapper.insertUser(user)>=0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getUserByuEmail(String uEmail) {
        return userMapper.getUserByuEmail(uEmail);
    }

    @Override
    public boolean updateUserByuEmail(User user, String uEmail) {
        if(userMapper.updateUserByuEmail(user.getuEmail(),user.getuPassword(),user.getuFirstName(),user.getuLastName(),uEmail)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUserByuEmail(String uEmail) {
        if(userMapper.deleteUserByuEmail(uEmail)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
