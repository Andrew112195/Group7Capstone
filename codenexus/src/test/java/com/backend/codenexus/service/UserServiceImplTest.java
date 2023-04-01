package com.backend.codenexus.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.UserEntity;

import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2) // mock DB for DAO tests
public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    private UserEntity user;

    @BeforeEach
    public void setUp() {
        // Set up test user for unit testing
        user = new UserEntity();
        user.setId(1000L);
        user.setUserTypeId(1);
        user.setEmail("johndoe@test.com");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setUsername("johndoe");
        user.setPassword("password1");
        userDao.save(user);
    }

    @Test
    public void testExistsByUsername() {
        // Test the existsByUsername() method of the UserDao
        assertTrue(userDao.existsByUsername("johndoe"), "User not found in DB");
    }

    @Test
    public void testExistsByUsernameFalseInput() {
        // Test the existsByUsername() method of the UserDao with a false input
        assertFalse(userDao.existsByUsername("johndoe."), "Bad User found in DB");
    }

    @Test
    public void testExistsByUsernameNonCaseSensitive() {
        // Test the existsByUsername() method of the UserDao without case sensitivity
        assertTrue(userDao.existsByUsername("JOHNDOE"), "Object is erroneously case-sensitivity bound");
    }

    @Test
    public void testUpdateUser() {
        // Test the updateUser() method of the UserDao
        UserEntity updatedUser = new UserEntity();
        updatedUser.setId(user.getId());
        updatedUser.setUserTypeId(user.getUserTypeId());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setUsername("differentUsername");
        updatedUser.setPassword(user.getPassword());
        assertNotEquals(updatedUser, userDao.updateUser(user.getId()), "updateUser() not returning User object");
    }


    //service
    @Test
    public void testRegister() {
        // Test the register() method of the UserService
        user.setUsername("uniqueUsername");
        assertTrue(userService.register(user));
    }

    @Test
    public void testRegisterSameUsername() {
        // Test the register() method of the UserService with a duplicate username
        assertFalse(userService.register(user));
    }

    @Test
    public void testRegisterSave() {
        // Test the register() method of the UserService with saving to the DB
        user.setUsername("anotherUniqueUsername");
        userService.register(user);
        assertTrue(userDao.existsByUsername("anotherUniqueUsername"), "User not found in DB");
    }
    @Test
    public void testLoginSuccess() {
        // create a user with valid credentials
        UserEntity user = new UserEntity();
        user.setUsername("validuser");
        user.setPassword("validpassword");
        userDao.save(user);

        // attempt to login with valid credentials
        UserEntity loggedInUser = userService.login(user);

        // assert that the returned user is not null
        assertNotNull(loggedInUser, "User should be able to log in with valid credentials");
        assertEquals(user.getId(), loggedInUser.getId(), "Returned user should be the same as the input user");
    }

    @Test
    public void testLoginWrongPassword() {
        // create a user with valid username and password
        UserEntity user = new UserEntity();
        user.setUsername("validuser");
        user.setPassword("validpassword");
        userDao.save(user);

        // attempt to login with wrong password
        user.setPassword("wrongpassword");
        UserEntity loggedInUser = userService.login(user);

        // assert that the returned user is null
        assertNull(loggedInUser, "User should not be able to log in with wrong password");
    }

    @Test
    public void testLoginNonexistentUser() {
        // create a user with valid username and password
        UserEntity user = new UserEntity();
        user.setUsername("validuser");
        user.setPassword("validpassword");
        userDao.save(user);

        // attempt to login with non-existent username
        user.setUsername("nonexistentuser");
        UserEntity loggedInUser = userService.login(user);

        // assert that the returned user is null
        assertNull(loggedInUser, "User should not be able to log in with non-existent username");
    }
    @Test
    public void testUpdateProfile() {
        //create user to be updated
        UserEntity user = new UserEntity();
        user.setUserTypeId(1);
        user.setEmail("janedoe@test.com");
        user.setFirstname("Jane");
        user.setLastname("Doe");
        user.setUsername("janedoe");
        user.setPassword("password2");
        UserEntity savedUser = userDao.save(user);

        //update user
        savedUser.setFirstname("JaneUpdated");
        savedUser.setLastname("DoeUpdated");
        savedUser.setUsername("janedoeUpdated");
        savedUser.setEmail("janedoeupdated@test.com");
        UserEntity updatedUser = userService.updateProfile(savedUser);

        //check if updated user matches updated values
        assertEquals(updatedUser.getFirstname(), savedUser.getFirstname());
        assertEquals(updatedUser.getLastname(), savedUser.getLastname());
        assertEquals(updatedUser.getUsername(), savedUser.getUsername());
        assertEquals(updatedUser.getEmail(), savedUser.getEmail());
    }

    @Test
    public void testUpdateProfileNonExistentUser() {
        //create user with non-existent ID
        UserEntity user = new UserEntity();
        user.setId(1000L);
        user.setUserTypeId(1);
        user.setEmail("janedoe@test.com");
        user.setFirstname("Jane");
        user.setLastname("Doe");
        user.setUsername("janedoe");
        user.setPassword("password2");

        //try to update non-existent user
        Exception exception = assertThrows(NoSuchElementException.class, () -> userService.updateProfile(user));

        //check if NoSuchElementException is thrown
        String expectedMessage = "No value present";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUpdateProfileNullInput() {
        //try to update null user
        UserEntity user = null;

        //try to update null user
        Exception exception = assertThrows(NullPointerException.class, () -> userService.updateProfile(user));

        //check if NullPointerException is thrown
        String expectedMessage = "Cannot invoke \"com.backend.codenexus.entity.UserEntity.getId()\" because \"user\" is null";
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, expectedMessage);
    }


    @Test
    public void testChangePasswordWithInvalidOldPassword() {
        // create a test user
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("oldpassword");

        // save the user to the database
        userDao.saveAndFlush(user);

        // call the changePassword method with invalid old password
        boolean result = userService.changePassword(user, "invalidpassword", "newpassword");

        // check that the password was not changed and the method returned false
        assertFalse(result);
        userService.updateUser(user);
        assertEquals("oldpassword", user.getPassword());
    }

    @Test
    public void testChangePasswordWithNullUser() {
        // call the changePassword method with null user
        boolean result = userService.changePassword(null, "oldpassword", "newpassword");

        // check that the method returned false
        assertFalse(result);
    }

    @Test
    public void testChangePasswordWithNullOldPassword() {
        // create a test user
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("oldpassword");

        // save the user to the database
        userDao.saveAndFlush(user);

        // call the changePassword method with null old password
        boolean result = userService.changePassword(user, null, "newpassword");

        // check that the password was not changed and the method returned false
        assertFalse(result);
        assertEquals("oldpassword", user.getPassword());
    }

    @Test
    public void testChangePasswordWithNullNewPassword() {
        // create a test user
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("oldpassword");

        // save the user to the database
        userDao.saveAndFlush(user);

        // call the changePassword method with null new password
        boolean result = userService.changePassword(user, "oldpassword", null);

        // check that the password was not changed and the method returned false
        assertFalse(result);
        assertEquals("oldpassword", user.getPassword());
    }

    @Test
    public void testChangePasswordWithException() {
        // create a test user
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("oldpassword");

        // do not save the user to the database

        // call the changePassword method with invalid user
        boolean result = userService.changePassword(user, "oldpassword", "newpassword");

        // check that the password was not changed and the method returned false
        assertFalse(result);
    }



}
