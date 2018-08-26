package com.girltv.core.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.girltv.dao.common.AbstractMasterTransactionalBaseDAOTest;

public class VideoDAOTest extends AbstractMasterTransactionalBaseDAOTest {
	@Autowired
	private VideoDAO videoDAO;

	@Override
	@Autowired
	public void setDataSource(@Qualifier(value = "dataSource") DataSource dataSource) {
	}

	@Test
	public void testSelectVideoByVideoId() {
		videoDAO.selectVideoByVideoId(1);
	}

	@Test
	public void testSelectVideoCount() {
		videoDAO.selectVideoCount();
	}

	@Test
	public void testSelectVideoList() {
		int offset = 1;
		int pageSize = 10;
		videoDAO.selectVideoList(offset, pageSize);
	}
}