package com.controller;

import com.bean.User;
import com.controller.impl.UserController;
import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.service.impl.ParagraphServiceImp;
import com.service.impl.UserServiceImpl;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import com.service.ParagraphService;
import com.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by yjy on 16-11-21.
 */
public class UserControllerTests {

    private static String username = "yjy";
    private static String password = "111111";
    private static String email = "1224624112@qq.com";

    private IMocksControl mocksControl;
    private UserService userService;
    private ParagraphService paragraphService;
    private UserController userController;

    @Before
    public void init(){
        mocksControl = EasyMock.createControl();
        userService = mocksControl.createMock(UserServiceImpl.class);
        paragraphService = mocksControl.createMock(ParagraphServiceImp.class);
        userController = new UserController();
        userController.setUserService(userService);
        userController.setParagraphService(paragraphService);
    }
/*

    @Test
    public void createUser(){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userService.save(user);
        EasyMock.expectLastCall().andVoid();

        mocksControl.replay();

        userController.createUser(username,password,email);

        mocksControl.verify();

        UserDAO userDAO = new UserDAOImpl();
        User sqluser = userDAO.findUserByUsername(username);
        Assert.assertNotNull(sqluser);
    }
*/

    @After
    public void destroy(){

    }
}
