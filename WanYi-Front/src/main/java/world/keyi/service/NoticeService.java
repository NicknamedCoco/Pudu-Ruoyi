package world.keyi.service;

import world.keyi.domain.Notice;

import java.util.ArrayList;

public interface NoticeService {
    ArrayList<Notice> getNoticeList(String type);
}
