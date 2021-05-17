package bll;

import be.ScreenElement;
import be.User;
import bll.exception.BLLException;
import dal.exception.DALexception;

import java.util.List;

/**
 *
 */
// Users add, delete and all
public interface IFacade extends IScreen, IDefaultScreen{
    List<User> getAllUser()throws BLLException;
    void deleteUser(User user)throws BLLException;
    void updateUser(User oldUser, User newUser) throws BLLException;
    void createUser(User user) throws BLLException;
    boolean validate(String password) throws BLLException;
    List<ScreenElement> getScreenForUser(int userId) throws BLLException;
    void resetPassword(User oldUser,User reset) throws BLLException;
    void updatePassword(User oldUser,String newPassword) throws BLLException;


    User getUser(String username) throws BLLException;
}
