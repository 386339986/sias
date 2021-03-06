package com.nice.web.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.mapper.NoticeMapper;
import com.nice.web.pojo.Classroom;
import com.nice.web.pojo.Notice;
import com.nice.web.service.NoticeService;
import com.nice.web.utils.DataResult;
import com.nice.web.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:54
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 添加公告
     *
     * @param notice
     * @return
     */
    @Override
    public DataResult addNotice(Notice notice) {
        notice.setTime(DateUtil.getStringTime(new Date()));
        noticeMapper.addNotice(notice);
        return DataResult.ok(notice);
    }

    /**
     * 删除公告
     *
     * @param id
     * @return
     */
    @Override
    public DataResult deleteNotice(Integer id) {
        noticeMapper.deleteNotice(id);
        return DataResult.ok(id);
    }

    /**
     * 根据id查询单个公告
     *
     * @param id
     * @return
     */
    @Override
    public DataResult selectANotice(Integer id) {
        List<Notice> notice = noticeMapper.selectANotice(id);
        return DataResult.ok(notice);
    }

    /**
     * 查询所有公告信息
     *
     * @return
     */
    @Override
    public DataResult findAllNotice() {
        List<Notice> notice = noticeMapper.findAllNotice();
        return DataResult.ok(notice);
    }

    /**
     * 分页查询公告
     * @param title
     * @param pagenum
     * @param pagesize
     * @return
     */
    @Override
    public DataResult noticeList(String title, Integer pagenum, Integer pagesize) {
        //分页插件
        PageHelper.startPage(pagenum, pagesize);
        Notice notices = new Notice();
        notices.setTitle(title);
        List<Map<String, Object>> notice = noticeMapper.findNotice(notices);
        PageInfo<Map<String, Object>> noticeList = new PageInfo<>(notice);
        Map<String,Object> map = new HashMap<>();
        map.put("noticeList",noticeList.getList());
        map.put("total",noticeList.getTotal());
        return DataResult.ok(map);

    }
    @Override
    public DataResult updateNotice(Integer id,Notice notice){
        notice.setId(id);
        noticeMapper.updateNotice(notice);
        return DataResult.ok(notice);
    }

}
