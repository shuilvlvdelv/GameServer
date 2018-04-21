package com.ftiger.www.game.redis.dao;

import com.ftiger.www.game.redis.obj.UserRedisDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 宋旭源
 */
@Repository
public interface UserRepository extends CrudRepository<UserRedisDO,String> {

}
