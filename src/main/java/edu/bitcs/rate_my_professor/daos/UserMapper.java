package edu.bitcs.rate_my_professor.daos;

import edu.bitcs.rate_my_professor.pos.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select count(uId) from User where uEmail = #{uEmail}")
    long numberOfEmail(String uEmail);

    @Select("select uPassword from User where uEmail = #{uEmail}")
    String getuPasswordByuEmail(String uEmail);

    @Select("select uId from User where uEmail = #{uEmail}")
    long getuIdByuEmail(String uEmail);

    @Insert("insert into User(uEmail,uPassword,uFirstName,uLastName) values(#{uEmail},#{uPassword},#{uFirstName},#{uLastName})")
    @Options(useGeneratedKeys = true, keyProperty = "uId")
    long insertUser(User user);

    @Select("select * from User where uEmail = #{uEmail}")
    User getUserByuEmail(String uEmail);

    @Update("update User set uEmail = #{uNewEmail}, uPassword = #{uPassword}, uFirstName = #{uFirstName}, uLastName = #{uLastName} where uEmail = #{uEmail}")
    long updateUserByuEmail(String uNewEmail,String uPassword,String uFirstName,String uLastName,String uEmail);

    @Delete("delete from User where uEmail = #{uEmail}")
    long deleteUserByuEmail(String uEmail);


}
