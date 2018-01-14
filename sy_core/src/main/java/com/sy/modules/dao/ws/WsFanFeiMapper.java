package com.sy.modules.dao.ws;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.entity.ws.WsFanFei;
import com.sy.modules.entity.ws.WsFanFeiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@MyBatisRepository
public interface WsFanFeiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int countByExample(WsFanFeiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int deleteByExample(WsFanFeiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer fId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int insert(WsFanFei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int insertSelective(WsFanFei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    List<WsFanFei> selectByExampleWithRowbounds(WsFanFeiExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    List<WsFanFei> selectByExample(WsFanFeiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    WsFanFei selectByPrimaryKey(Integer fId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WsFanFei record, @Param("example") WsFanFeiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WsFanFei record, @Param("example") WsFanFeiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WsFanFei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_fanfei
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WsFanFei record);
}