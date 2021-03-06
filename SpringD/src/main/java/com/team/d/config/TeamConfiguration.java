package com.team.d.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.team.d.command.board.BoardListCommand;
import com.team.d.command.board.DeleteBoardCommand;
import com.team.d.command.board.InsertBoardCommand;
import com.team.d.command.board.SearchBoardCommand;
import com.team.d.command.board.SelectNoticeCommand;
import com.team.d.command.board.ShowBoardCommand;
import com.team.d.command.board.UpdateBoardCommand;
import com.team.d.command.board.UpdateBoardPageCommand;
import com.team.d.command.member.AdminLoginCommand;
import com.team.d.command.member.ChangePwCommand;
import com.team.d.command.member.EmailAuthCommand;
import com.team.d.command.member.EmailCheckCommand;
import com.team.d.command.member.FindIdCommand;
import com.team.d.command.member.FindPwCommand;
import com.team.d.command.member.IdCheckCommand;
import com.team.d.command.member.JoinCommand;
import com.team.d.command.member.LeaveCommand;
import com.team.d.command.member.LoginCommand;
import com.team.d.command.member.LogoutCommand;
import com.team.d.command.member.PresentPwCheckCommand;
import com.team.d.command.member.UpdateMemberCommand;
import com.team.d.command.member.UpdatePwCommand;
import com.team.d.command.reply.GetChildListCommand;
import com.team.d.command.reply.GetReplyListCommand;
import com.team.d.command.reply.InsertReReplyCommand;
import com.team.d.command.reply.InsertReplyCommand;
import com.team.d.command.reservation.CancelRevCommand;
import com.team.d.command.reservation.EmailRevCodeCommand;
import com.team.d.command.reservation.MyReservationCommand;
import com.team.d.command.reservation.NonMemberRevListCommand;
import com.team.d.command.reservation.ReceiptCommand;
import com.team.d.command.reservation.ReceiptCommand2;
import com.team.d.command.reservation.RevInfoCommand;
import com.team.d.command.reservation.SelectRemainingRoom;
import com.team.d.command.reservation.SelectRoomCommand;
import com.team.d.command.room.DownloadRoomServiceMenuCommand;
import com.team.d.command.room.SelectRoomListCommand;
import com.team.d.command.room.SelectRoomViewCommand;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class TeamConfiguration { 

	/* ??? ??????????????? ??????????????? ????????? bean ??????*/
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("SERVER_USER");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	
	@Bean(destroyMethod="close")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(hikariDataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/team/d/dao/mapper/*.xml"));
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}    
	
	/* Board ?????? */
	@Bean
	public InsertBoardCommand InsertBoardCommand() {
		return new InsertBoardCommand();
	}
	@Bean
	public BoardListCommand boardListCommand() {
		return new BoardListCommand();
	}
	@Bean
	public SearchBoardCommand searchBoardCommand() {
		return new SearchBoardCommand();		
	}
	@Bean
	public SelectNoticeCommand selectInformCommand() {
		return new SelectNoticeCommand();
	}
	@Bean
	public ShowBoardCommand showBoardCommand() {
		return new ShowBoardCommand();
	}
	@Bean
	public UpdateBoardPageCommand UpdateBoardPageCommand() {
		return new UpdateBoardPageCommand();
	}
	@Bean
	public UpdateBoardCommand updateBoardCommand() {
		return new UpdateBoardCommand();
	}
	@Bean
	public DeleteBoardCommand deleteBoardCommand() {
		return new DeleteBoardCommand();
	}
	
	/* Reply ?????? */
	@Bean
	public InsertReplyCommand insertReplyCommand() {
		return new InsertReplyCommand();
	}
	@Bean
	public GetReplyListCommand getReplyListCommand() {
		return new GetReplyListCommand();
	}
	@Bean
	public GetChildListCommand getChildListCommand() {
		return new GetChildListCommand();
	}
	@Bean
	public InsertReReplyCommand insertReReplyCommand() {
		return new InsertReReplyCommand();
	}
	
	/* member ?????? */
	@Bean
	public LoginCommand loginCommand() { // ?????????
		return new LoginCommand();
	}
	@Bean
	public LogoutCommand logoutCommand(){ // ????????????
		return new LogoutCommand();
	}
	@Bean
	public IdCheckCommand idCheckCommand() { // ????????? ??????
		return new IdCheckCommand();
	}
	@Bean
	public EmailCheckCommand emailCheckCommand() { // ????????? ??????
		return new EmailCheckCommand();
	}
	@Bean
	public EmailAuthCommand emailAuthCommand() { // ????????? ??????
		return new EmailAuthCommand();
	}
	@Bean
	public JoinCommand joinCommand() { // ????????????
		return new JoinCommand();
	}
	@Bean
	public PresentPwCheckCommand presentPwCheckCommand(){ // ?????? ???????????? ??????
		return new PresentPwCheckCommand();
	}
	@Bean
	public UpdatePwCommand updatePwCommand(){ // ???????????? ??????
		return new UpdatePwCommand();
	}
	@Bean
	public UpdateMemberCommand updateMemberCommand(){ // ???????????? ??????
		return new UpdateMemberCommand();
	}
	@Bean
	public FindIdCommand findIdCommand(){ // ????????? ??????
		return new FindIdCommand();
	}
	@Bean
	public FindPwCommand findPwCommand(){ // ???????????? ??????
		return new FindPwCommand();
	}
	@Bean
	public ChangePwCommand changePwCommand(){ // ???????????? ??????&??????
		return new ChangePwCommand();
	}
	@Bean
	public LeaveCommand leaveCommand(){ // ????????????
		return new LeaveCommand();
	}
	@Bean
	public AdminLoginCommand adminLoginCommand() { // ????????? ?????????
		return new AdminLoginCommand();
	}
	
	/* reservation ?????? */ 
	@Bean
	public SelectRemainingRoom selectRemainingRoom() {
		return new SelectRemainingRoom();
	}

	@Bean
	public SelectRoomCommand selectRoomCommand() {
		return new SelectRoomCommand();
	}

	@Bean
	public ReceiptCommand receiptCommand() {
		return new ReceiptCommand();
	}
	@Bean
	public RevInfoCommand revInfoCommand() {
		return new RevInfoCommand();
	}
	@Bean
	public ReceiptCommand2 receiptCommand2() {
		return new ReceiptCommand2();
	}
	
	@Bean
	public MyReservationCommand myReservationCommand() {
		return new MyReservationCommand();
	}
	@Bean
	public CancelRevCommand cancelRevCommand() {
		return new CancelRevCommand();
	}
	@Bean
	public EmailRevCodeCommand emailRevCodeCommand() {
		return new EmailRevCodeCommand();
	}
	@Bean
	public NonMemberRevListCommand nonMemberRevListCommand() {
		return new NonMemberRevListCommand();
	}
	/* Room ??????*/
	@Bean
	public SelectRoomListCommand selectRoomListCommand() {
		return new SelectRoomListCommand();
	}
	
	@Bean
	public SelectRoomViewCommand selectRoomViewCommand() {
		return new SelectRoomViewCommand();
	}
	
	@Bean
	public DownloadRoomServiceMenuCommand downloadRoomServiceMenuCommand() {
		return new DownloadRoomServiceMenuCommand();
	}
	
}
