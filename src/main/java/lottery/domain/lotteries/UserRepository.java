package lottery.domain.lotteries;

import java.util.ArrayList;

public class UserRepository {
    ArrayList<UserEntity> userEntities = new ArrayList<>();

    public void save(UserEntity userEntity) {
        userEntities.add(userEntity);
    }

    public UserEntity findFirstUser() {
        return userEntities.get(0);
    }
}
