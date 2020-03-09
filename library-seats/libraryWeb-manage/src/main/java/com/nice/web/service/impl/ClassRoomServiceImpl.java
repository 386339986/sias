package com.nice.web.service.impl;

import com.nice.web.pojo.Classroom;
import com.nice.web.utils.DataResult;
import com.nice.web.utils.DateUtil;
import com.nice.web.mapper.ClassRoomMapper;
import com.nice.web.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    /**
     * @Description 获取明天教室列表
     * @Param
     * @return
     **/
    @Override
    public List<Map<String, Object>> findTomorrowClassRoom() {

        return classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime());
    }

    /**
     * @Description 获取所以教室列表
     * @Param
     * @return
     **/
    @Override
    public DataResult findAllClassRoom() {
        return DataResult.ok(classRoomMapper.findClassRoomById(null));
    }

    /**
     * @Description 获取明天教室列表
     * @Param
     * @return
     **/
    @Override
    public List<Map<String, Object>> findTodayClassRoom() {
        return classRoomMapper.findAllClassRoom(null, DateUtil.nowCreateTime(), DateUtil.nowEndTime());
    }

    @Override
    public DataResult findClassRoom() {
        List<String> classRoom = classRoomMapper.findClassRoom();
        return DataResult.ok(classRoom);
    }

    /**
     * 根据id删除教室
     * @param id
     * @return
     */
    @Override
    public DataResult delete(Integer id) {
        try {
            classRoomMapper.delete(id);
        } catch (Exception e) {
            return DataResult.fail(500, "删除失败！！", e);
        }
        return DataResult.ok(id);
    }

    /**
     * 添加教室
     * @param classroom
     * @return
     */
    @Override
    public DataResult insertClassroom(Classroom classroom) {
        try {
            classRoomMapper.insertClassroom(classroom);
        } catch (Exception e) {
            return DataResult.fail(500, "添加失败！！", e);
        }
        return DataResult.ok(classroom);
    }


}