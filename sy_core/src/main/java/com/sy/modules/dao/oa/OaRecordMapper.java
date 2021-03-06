package com.sy.modules.dao.oa;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.entity.oa.OaRecord;
import com.sy.modules.entity.oa.OaRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@MyBatisRepository
public interface OaRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int countByExample(OaRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int deleteByExample(OaRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long rId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int insert(OaRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int insertSelective(OaRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    List<OaRecord> selectByExampleWithRowbounds(OaRecordExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    List<OaRecord> selectByExample(OaRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    OaRecord selectByPrimaryKey(Long rId);
    
    OaRecord selectByPrimaryKeyAndCId(Long cId);
    
    List<OaRecord> selectAllRecordListByCId(Long cId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OaRecord record, @Param("example") OaRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OaRecord record, @Param("example") OaRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OaRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OaRecord record);
}