package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.AddressMapper;
import com.xiaoshu.dao.MajorMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Address;
import com.xiaoshu.entity.CountVo;
import com.xiaoshu.entity.Major;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class StuService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private StudentMapper sm;
	
	@Autowired
	private MajorMapper mm;
	
	@Autowired
	private AddressMapper am;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(User t) throws Exception {
		userMapper.insert(t);
	};

	// 修改
	public void updateStu(Student stu) throws Exception {
//		sm.updateByPrimaryKey(stu);
		sm.updateStu(stu);
	};

	// 删除
	public void deleteStu(Integer id) throws Exception {
		sm.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public Student existStuByName(String sdName) throws Exception {
		List<Student> stuList =  sm.findByName(sdName);
		return stuList.isEmpty()?null:stuList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

	public PageInfo<Student> findStuPage(Student stu, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<Student> stuList  = sm.findAll(stu);
		PageInfo<Student> pageInfo = new PageInfo<Student>(stuList);
		return pageInfo;
	}
//查询所有班级
	public List<Major> findAllMajor() {
		// TODO Auto-generated method stub
		List<Major> list = mm.selectAll();
		return list;
	}
	//添加
	public void addStu(Student stu) {
		// TODO Auto-generated method stub
		sm.addStu(stu);
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> stuList  = sm.findAll(null);
		return stuList;
	}

	public List<CountVo> countStu() {
		// TODO Auto-generated method stub
		List<CountVo> list = sm.countStu();
		return list;
	}

	//添加专业
	public void addMajor(Major major) {
		// TODO Auto-generated method stub
		mm.addMajor(major);
	}
	//查询地址
	public List<Address> findAllAddress(int i) {
		// TODO Auto-generated method stub
		List<Address>  alist = am.findByParentId(i);
		return alist;
	}


}
