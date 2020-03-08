package com.nice.service;

import com.nice.pojo.Seats;
import com.nice.utils.DataResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-04 22:27
 *
 * @author wmj
 * @version 1.0
 */
public interface SeatsService {

    //查询预约座位
    DataResult findSubscribeSeats(Integer classroomId,String createTime,String state);
    //添加座位
    DataResult insertSeats(Seats seats);
    //删除座位
    DataResult deleteSeats(Integer id);
}