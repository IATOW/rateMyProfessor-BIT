package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.User;

public interface UserDao extends Dao {
    boolean isEmailExisted(String uEmail);
    boolean isPasswordCorrect(String uEmail, String uPassword);

    boolean insertUser(User user);
    User getUser(String uEmail);
    boolean updateUserByuEmail(User user,String uEmail);
    boolean deleteUserByuEmail(String uEmail);
}
