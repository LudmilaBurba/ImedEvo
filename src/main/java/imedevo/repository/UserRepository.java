package imedevo.repository;

import imedevo.model.User;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

  private List<User> users = new ArrayList();

  public UserRepository() {
    User user = new User();
    user.setId(1);
    user.setName("Olya");
    user.setEmail("olya@test.com");
    user.setPhone("0931111111");
    user.setBirthDate(1986);

    users.add(user);

    user = new User();
    user.setId(2);
    user.setName("Petya");
    user.setEmail("petya@test.com");
    user.setPhone("0982222222");
    user.setBirthDate(1973);

    users.add(user);

    user = new User();
    user.setId(3);
    user.setName("Masha");
    user.setEmail("masha@test.com");
    user.setPhone("0673333333");
    user.setBirthDate(1993);

    users.add(user);

    user = new User();
    user.setId(4);
    user.setName("Sasha");
    user.setEmail("sasha@test.com");
    user.setPhone("0944444444");
    user.setBirthDate(2000);

    users.add(user);

    user = new User();
    user.setId(5);
    user.setName("Klavdiya Olegovna");
    user.setEmail("KlavdiyaOlegovna@test.com");
    user.setPhone("0482654321");
    user.setBirthDate(1941);

    users.add(user);
  }

    private AtomicInteger counter = new AtomicInteger(1);


    public Collection<User> findAll() {
        return users.values();
    }

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    public User save(User user) {

        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }

        users.put(user.getId(), user);

        return user;
    }

    public Optional<User> delete(Integer id) {
        return Optional.ofNullable(users.remove(id));
    }

    public User getUser(User user) {
        // TODO check, if user with such e-mail is exists
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User u1 = iterator.next();
            if (u1.getEmail().equals(user.getEmail())) {
                return u1;
            }
        }
        return null;
    }

    public void saveNewUserInDB(User user){
        users.add(user);
    }
}