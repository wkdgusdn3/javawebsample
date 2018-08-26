package com.girltv.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.girltv.core.model.Video;

@Repository
public class VideoDAO {
	private static final String NAMESPACE = "com.girltv.core.dao.VideoMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * videoId로 동영상정보 조회
	 * @param videoId
	 * @return
	 */
	public Video selectVideoByVideoId(int videoId){
		return (Video)sqlSessionTemplate.selectOne(NAMESPACE + "selectVideoByVideoId", videoId);
	}
	
	/**
	 * Video 전체 개수 조회
	 * @return
	 */
	public int selectVideoCount(){
		return (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectVideoCount");
	}
	
	/**
	 * Video 목록 조회
	 * @param offset 페이지 시작점 
	 * @param pageSize 페이지당 게시물 수
	 * @return
	 */
	public List<Video> selectVideoList(int offset, int pageSize){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("pageSize", pageSize);
		
		return sqlSessionTemplate.selectList(NAMESPACE + "selectVideoList", params);
	}
}