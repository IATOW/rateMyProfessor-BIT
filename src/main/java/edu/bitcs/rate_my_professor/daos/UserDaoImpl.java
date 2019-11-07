package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public boolean isEmailExisted(String uEmail) {
        return true;
    }

    @Override
    public boolean isPasswordCorrect(String uEmail, String uPassword) {
        return true;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public User getUser(String uEmail) {
        return new User("yichengchen99@gmail.com","123456","yicheng","chen");
    }

    @Override
    public boolean updateUserByuEmail(User user, String uEmail) {
        return false;
    }

    @Override
    public boolean deleteUserByuEmail(String uEmail) {
        return false;
    }

    @Override
    public void creatConnection() {

    }

    @Override
    public void destroyConnection() {

    }
}
