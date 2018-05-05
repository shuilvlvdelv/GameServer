package com.ftiger.www.game.redis.dao;

import com.ftiger.www.game.redis.obj.RoomInfoDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 宋旭源
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomInfoDO,String> {
    /**
     * 根据状态查询房间
     * @param status
     * @return
     */
    List<RoomInfoDO> findAllByStatus(String status);
}
