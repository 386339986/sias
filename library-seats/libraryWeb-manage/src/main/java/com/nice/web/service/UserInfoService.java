package com.nice.web.service;

import com.nice.web.utils.DataResult;

/**
 * @ClassName UserInfoService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/23
 * @Version V1.0
 **/
public interface UserInfoService {
    //获取用户信息
    DataResult findUserInfo();

    //
    DataResult insertUserinfo(String studentId,String name);

}
