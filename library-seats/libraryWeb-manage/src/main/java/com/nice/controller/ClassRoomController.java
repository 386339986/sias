package com.nice.controller;

import com.nice.pojo.Classroom;
import com.nice.service.ClassRoomService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    //查询所以的教室是
    @RequestMapping("/findAllClassRoom")
    public DataResult findAllClassRoom(){
        return classRoomService.findAllClassRoom();
    }
    //查询今天教室信息以及预约的座位数量
    @RequestMapping("/findTodayClassRoom")
    public DataResult findTodayClassRoom(){
        return  DataResult.ok(classRoomService.findTodayClassRoom());
    }

    //查询今天教室信息以及预约的座位数量
    @RequestMapping("/findTomorrowClassRoom")
    public DataResult findTomorrowClassRoom(){
        return  DataResult.ok(classRoomService.findTomorrowClassRoom());
    }


    //查询教室信息
    @RequestMapping("/findClassRoom")
    public DataResult findClassRoom(){
        return  DataResult.ok(classRoomService.findClassRoom());
    }

    /*删除教室*/
    @PostMapping("delete/{id}")
    public DataResult delClassRoom(@PathVariable("id")Integer id){
        return DataResult.ok(classRoomService.delete(id));
    }
    //添加教室
    @PostMapping("insert")
    public DataResult insertClassroom(Classroom classroom){
        return DataResult.ok(classRoomService.insertClassroom(classroom));
    }

}
