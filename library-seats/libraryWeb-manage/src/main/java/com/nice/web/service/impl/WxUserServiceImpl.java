package com.nice.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.pojo.UserInfo;
import com.nice.web.utils.DataResult;
import com.nice.web.mapper.UserInfoMapper;
import com.nice.web.mapper.WxUserMapper;
import com.nice.web.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WxUserServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/4
 * @Version V1.0
 **/
@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

     /**
      * @Description 禁用 查询微信用户列表
      * @param studentId
      * @param pagenum
      * @param pagesize
      * @return com.nice.web.utils.DataResult
      **/
    @Override
    public DataResult findWxUser(Integer studentId, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> wxUser = wxUserMapper.findWxUser(studentId);
        PageInfo<Map<String, Object>> pageInfo= new PageInfo<>(wxUser);
        Map<String,Object> res=new HashMap<>();
        res.put("infoList",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        return DataResult.ok(res);
    }

    /**
     * @Description 禁用 与开启用户
     * @param id
     * @param state
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult updataWxUserState(Integer id,Integer state) {
        UserInfo userInfo = new UserInfo();
        userInfo.setState(state);
        userInfo.setUerId(id);
        try{
            userInfoMapper.updateUserInfoState(userInfo);
        }catch(Exception e){
            return DataResult.fail(500,"状态修改失败！",e);
        }
        return DataResult.ok();
    }

    /**
     * @Description 删除用户
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult deleteUserInfo(Integer id,String studentId) {
        List<Map<String, Object>> userInfo = userInfoMapper.findUserInfo(studentId);
        if(userInfo.get(0).get("user_id").equals(0)){
            userInfoMapper.deleteUserInfo(id,studentId);
        }
        userInfoMapper.deleteUserInfoStudentId(id);
        return DataResult.ok();
    }
}
