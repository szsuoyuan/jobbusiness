package com.sy.modules.dao.ws;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.entity.ws.WsOrder;
import com.sy.modules.entity.ws.WsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
@Component
@MyBatisRepository
public interface WsOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int countByExample(WsOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int deleteByExample(WsOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int insert(WsOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int insertSelective(WsOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    List<WsOrder> selectByExampleWithRowbounds(WsOrderExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    List<WsOrder> selectByExample(WsOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    WsOrder selectByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WsOrder record, @Param("example") WsOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WsOrder record, @Param("example") WsOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WsOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WsOrder record);
}