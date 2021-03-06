package com.team.d.command.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class LogoutCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		
		if(session.getAttribute("loginUser") != null) {
			session.invalidate(); // 세션 비우기
		} else if(session.getAttribute("loginAdmin") != null) {
			session.invalidate();
		}
		
	}

}
