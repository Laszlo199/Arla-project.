package bll;

import be.Users;
import bll.exception.BLLException;
import dal.exception.DALexception;

import java.util.List;

/**
 *
 */
// Users add, delete and all
public interface IFacade extends IScreen{
    List<Users> getAllUser()throws BLLException;
    void deleteUser(Users user)throws BLLException;
    void updateUser(Users oldUser, Users newUser) throws BLLException;
    void createUser(Users user) throws BLLException;
}