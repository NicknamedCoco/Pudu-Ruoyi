package world.keyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.domain.Notice;
import world.keyi.mapper.NoticeMapper;
import world.keyi.service.NoticeService;

import java.util.ArrayList;

/**
 * @author 万一
 * @DATE 2022年04月05日12:35
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ArrayList<Notice> getNoticeList(String type) {
        return noticeMapper.getNoticeList(type);
    }
}
