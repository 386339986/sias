package com.nice.mapper;

import com.nice.pojo.UserRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 12:30
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface UserRecordMapper {
    List<UserRecord> findUserRecordByUserId(UserRecord userRecord);

    int  insertUserRecord(UserRecord userRecord);

    //查询所有违约记录
    List<Map<String,Object>> findUserRecord(Integer userId);
}
