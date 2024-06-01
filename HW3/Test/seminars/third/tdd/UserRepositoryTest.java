package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import  static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void checkLogOut() {
        User nikita = new User("Nikita", "111", true);
        User masha = new User("Masha", "222", false);
        User dasha = new User("Dasha", "333", true);
        User pasha = new User("Pasha", "444", false);

        nikita.authenticate("Nikita", "111");
        masha.authenticate("Masha", "222");
        dasha.authenticate("Dasha", "333");
        pasha.authenticate("Pasha", "444");

        userRepository.addUser(nikita);
        userRepository.addUser(masha);
        userRepository.addUser(dasha);
        userRepository.addUser(pasha);

        ArrayList<User> expectedList = new ArrayList<>();
        expectedList.add(nikita);
        expectedList.add(dasha);

        userRepository.logOut();

        assertThat(userRepository.data).containsExactlyInAnyOrderElementsOf(expectedList);
        assertThat(nikita.isAuthenticate).isEqualTo(true);
        assertThat(masha.isAuthenticate).isEqualTo(false);
        assertThat(dasha.isAuthenticate).isEqualTo(true);
        assertThat(pasha.isAuthenticate).isEqualTo(false);
    }
}