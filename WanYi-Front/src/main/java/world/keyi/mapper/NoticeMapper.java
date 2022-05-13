package world.keyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import world.keyi.domain.Notice;

import java.util.ArrayList;

@Mapper
@Repository
public interface NoticeMapper {
    ArrayList<Notice> getNoticeList(String type);
}
