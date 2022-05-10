package com.sck.alice;


import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sck.alice.vaildation.JsonUtil;
import com.sck.alice.vaildation.NamingCaseChanger;
import com.sck.alice.vaildation.ValidChecker;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

@Controller
@CrossOrigin(origins="*")
@RequestMapping("openapi/v1/secucat/safehome")
public class OpenAPIUserController {
	
	private final Logger logger         =          LoggerFactory.getLogger(this.getClass());
	
	static final String g_filePath = "C:/Temp/";

	
	/*
	 * 기기검색
	 * @param user_key : 모바일 키
	 * @return user_key. 없으면 fail >> 없으면 success
	 */
	@PostMapping("/search/key")
	public @ResponseBody String keyCheck (@RequestBody String body) throws Exception{
		
		logger.info(" @keyCheck Start ");
		logger.info(" @keyCheck body : "+ body);
		JSONObject queryResult  = 	new JSONObject();
		queryResult.put("result","fail");
		try {
			String bodyDecoded = URLDecoder.decode(body,"UTF-8");
			JSONObject json = (JSONObject) JSONValue.parse(bodyDecoded);

			Map<String,Object> obj = JsonUtil.getMapFromString(bodyDecoded);
			logger.info("@keyCheck body : "+ obj);

			// 객체 생성
			ValidChecker vaildData = new ValidChecker(obj);
			vaildData.notNull("user_key");
			vaildData.notNull("user_key");
			vaildData.ifNull("user_key","defalt"));

			Map<String,Object> param = NamingCaseChanger.toCamelCase(vaildData.getMap());
			param.("user_key","defalt");

			Object oh =  param.get("user_key");
			param.get("user_key").toString();
			' "ss":"ss" '
			Intgege paraing(String);


			Object o = "string";
			String s = o;
			println(s);

		}
		catch (IllegalArgumentException e) {
			logger.info(e.getMessage());
		} 
		catch (Exception e) {
			logger.info("error : " + e.getMessage());
			if(!e.getMessage().equals("Registered key")) {
				e.printStackTrace();
			}
		}
		logger.info(" @keyCheck Return :  " + queryResult.toJSONString());
		logger.info(" @keyCheck End ");
		return queryResult.toJSONString();
	}
	
	/*
	 * 아이디 찾기
	 * @param user_name  : 이름
	 * @param user_phone : 폰번호
	 * @return user_id ( tbl_safe_user ) 
	 */
//
//	@PostMapping("/find/id")
//	public @ResponseBody  String findId (@RequestBody String body) throws Exception{
//		
//		logger.info(" @findId Start ");
//		logger.info(" @findId body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		try {
//			String decoded        =  URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData   =  (JSONObject) JSONValue.parse(decoded);
//			logger.info("@keyCheck body : "+ bodyData);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userName",InitSupporter.notNull("user_name", bodyData));
//			param.put("userPhone",InitSupporter.notNull("user_phone", bodyData));
//			
//			logger.info("@findId sqlparam : "+param.toString());
//			Map<String, Object> encryptedParam = leaTool.EncryptOnlyPrivate(param);
//			Map<String, Object> decryptedParam = leaTool.decryptOnlyEncrypted(userCheckService.findIdByParam(encryptedParam));
//			queryResult.put("result",  decryptedParam);
//		}
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		}  
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//		logger.info(" @findId Return :  " + queryResult.toJSONString());
//		logger.info(" @findId End ");
//		
//		return queryResult.toJSONString();
//		
//				
//	}
//	/*
//	 * 아이디 검색
//	 * @param user_id : 아이디
//	 * @return 사용자 정보 ( tbl_safe_user ) 
//	 */
//	@PostMapping("/search/id")
//	public @ResponseBody  String findUserById (@RequestBody String body) throws Exception{
//		
//		logger.info(" @searchId Start ");
//		logger.info(" @searchId body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		try {
//			String decoded        =  URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData   =  (JSONObject) JSONValue.parse(decoded);
//			logger.info("@keyCheck body : "+ bodyData);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			logger.info("@searchId sqlparam : "+param.toString());
//			
//			Map<String, Object> decryptedParam = leaTool.decryptOnlyEncrypted(userCheckService.findUserById(param));
//			queryResult.put("result",  decryptedParam);
//		}
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		}  
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//		logger.info(" @searchId Return :  " + queryResult.toJSONString());
//		logger.info(" @searchId End ");
//		
//		return queryResult.toJSONString();
//		
//				
//	}
//	
//	/*
//	 * 사용자 등록
//	 * @param user_key 			: 모바일 키
//	 * @param user_id 			: 아이디
//	 * @param user_pwd 			: 패스워드
//	 * @param user_name 		: 이름
//	 * @param user_phone		: 휴대폰번호
//	 * @param user_gender		: 성별
//	 * @param user_birth		: 생년월일
//	 * @param user_protector1	: 보호자 정보
//	 * @param location_flag1	: 보호자 위치정보 전송 플래그
//	 * @param user_protector2	: 보호자 정보
//	 * @param location_flag2	: 보호자 위치정보 전송 플래그
//	 * @param user_protector3	: 보호자 정보
//	 * @param location_flag3	: 보호자 위치정보 전송 플래그
//	 * @param mode				: 사용자/보호자 모드  ( 1 / 2 )
//	 * @param device			: 아이폰 / 안드로이드 ( 1 / 0 )
//	 * @param ward_phone1		: 피보호자 전화번호
//	 * @param ward_phone2		: 피보호자 전화번호
//	 * @param ward_phone3		: 피보호자 전화번호
//	 * @return 성공/실패 ( 1 or 0 )
//	 */
//	@PostMapping("/regist")
//	public @ResponseBody String registUser (@RequestBody String body) throws Exception{
//		
//		logger.info(" @registUser Start ");
//		logger.info(" @registUser body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//			UserVO userInfo = new UserVO(bodyData);
//			logger.info("@registUser sqlparam : "+userInfo.getRegistData().toString());
//			Map<String, Object> encryptedPhone = leaTool.EncryptOnlyPrivate(userInfo.getUserPhone());
//			boolean isRegistedPhone =  userCheckService.isRegistedPhone(encryptedPhone);
//			
//			if(isRegistedPhone){
//				queryResult.put("result","phone error");
//			}else {
//				Map<String, Object> encryptedParam = leaTool.EncryptOnlyPrivate(userInfo.getRegistData());
//				queryResult.put("result",userService.userRegist(encryptedParam));
//			}
//		}
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info("error : " + e.getMessage());
//			e.printStackTrace();
//		}
//			logger.info(" @userRegist Return :  " + queryResult.toJSONString());
//			logger.info(" @userRegist End ");
//			
//			return queryResult.toJSONString();
//	}
//	
//	
//	
//	
//	/*
//	 * 로그인
//	 * @param user_key			: 모바일 키
//	 * @param user_id 			: 아이디
//	 * @param user_pwd 			: 패스워드
//	 * @return 사용자 정보 ( tbl_safe_user ), 실패시 null
//	 * @ETC 로그인 성공 시 user_key 업데이트.
//	 */
//	
//	//자동로그인 기능을 위한 업데이트
//	@PostMapping("/login")
//	public @ResponseBody String login (@RequestBody String body) throws Exception{
//	
//		logger.info(" @login Start ");
//		logger.info(" @login body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String bodyDecoded        	   =       URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData      	   =       (JSONObject) JSONValue.parse(bodyDecoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			
//			param.put("userKey",InitSupporter.notNull("user_key", bodyData));
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			param.put("userPwd",InitSupporter.notNull("user_pwd", bodyData));
//			param.put("device",InitSupporter.notNull("device", bodyData));
//			
//			logger.info("@login sqlparam"+param.toString());
//			
//			Map<String,Object> enparam = userCheckService.login(param);
//			logger.info("@login sqlparam"+enparam);
//			
//			Map<String,Object> deparam = leaTool.decryptOnlyEncrypted(enparam); 
//			logger.info("@login sqlparam" + deparam.toString());
//			
//			queryResult.put("result",deparam );
//		} 		
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//		logger.info(" @login Return :  " + queryResult.toJSONString());
//		logger.info(" @login End ");
//		
//		return queryResult.toJSONString();
//        
//	}
//	
//	@PostMapping("/logout")
//	public @ResponseBody String UserLogout (@RequestBody String body) throws Exception{
//	
//		logger.info(" @UserLogout Start ");
//		logger.info(" @UserLogout body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		Map<String, Object> param;
//		try {
//			String bodyDecoded        	   =       URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData      		   =       (JSONObject) JSONValue.parse(bodyDecoded);
//			
//			param = new HashMap<String,Object>();
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			String resultMap =  userCheckService.logout(param);
//			queryResult.put("result", resultMap);
//			logger.info("@UserLogout sqlparam"+param.toString());
//		}catch (IllegalArgumentException e) {
//				logger.info(e.getMessage());
//		}catch (Exception e) {
//				logger.info(e.getMessage());
//			}
//        
//		logger.info(" @UserLogout Return :  " + queryResult.toJSONString());
//		logger.info(" @UserLogout End ");
//		
//		return  queryResult.toJSONString();
//        
//	}
//	
//
//	/*
//	 * 사용자 정보 수정
//	 * @param user_key			: 모바일 키
//	 * @param user_id 			: 아이디
//	 * @param user_pwd 			: 패스워드
//	 * @return 성공/실패 ( 1 or 0 )
//	 */
//	@PostMapping("/update/user")
//	public @ResponseBody String UpdateUser (@RequestBody String body) throws Exception{
//	
//		
//		logger.info(" @UpdateUser Start ");
//		logger.info(" @UpdateUser body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String bodyDecoded        	   =       URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData      		   =       (JSONObject) JSONValue.parse(bodyDecoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			param.put("userPwd",InitSupporter.notNull("user_pwd", bodyData));
//			param.put("userPhone",InitSupporter.notNull("user_phone", bodyData));
//			
//			Map<String,Object> encryptedParam = leaTool.EncryptOnlyPrivate(param);
//			
//			logger.info(" @UpdateUser param :  " + encryptedParam.toString());
//			
//			boolean isRegistedUser =  userCheckService.isRegistedUser(encryptedParam);
//			
//			if(isRegistedUser){
//				// 아이디 + 휴대폰번호 일치하는 경우 비밀번호 변경
//				queryResult.put("result",userService.updateUser(encryptedParam));
//				logger.info("@UpdateUser pwd change");
//			}else {
//				boolean isRegistedPhone =  userCheckService.isRegistedPhone(encryptedParam);
//				
//				if(isRegistedPhone) {
//					// 휴대폰번호 중복시 phone error
//					queryResult.put("result","phone error");
//					logger.info("@UpdateUser duplicate phone number");
//				}else {
//					// 해당 아이디의 비밀번호+휴대폰번호 변경
//					queryResult.put("result",userService.updateUser(encryptedParam));
//					logger.info("@UpdateUser change phone&pwd ");
//				}
//			}
//			
//		}catch (IllegalArgumentException e) {
//				logger.info(e.getMessage());
//		}catch (Exception e) {
//				logger.info("error : " + e.getMessage());
//				e.printStackTrace();
//			}
//
//        //아이디로 검색해서 user_pwd, user_phone 업데이트
//		logger.info(" @UpdateUser Return :  " + queryResult.toJSONString());
//		logger.info(" @UpdateUser End ");
//     
//        return  queryResult.toJSONString();
//        
//        
//	}
//	// 
//	
//	
//	
//	/*
//	 * 사용자 모드 변경
//	 * @param user_id 		: 아이디
//	 * @param mode 			: 사용자모드 / 보호자모드 ( 1/ 2 )
//	 * @return 성공/실패 ( 1 or 0 )
//	 */
//	@PostMapping("/update/mode")
//	public @ResponseBody String UpdateMode (@RequestBody String body) throws Exception{
//		
//		logger.info(" @UpdateMode Start ");
//		logger.info(" @UpdateMode body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			param.put("mode",InitSupporter.notNull("mode", bodyData));
//			
//			logger.info("@UpdateUser sqlparam : "+param.toString());
//			queryResult.put("result",userService.updateUserMode(param));
//		}
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info("error : " + e.getMessage());
//			e.printStackTrace();
//		}
//		logger.info(" @UpdateMode Return :  " + queryResult.toJSONString());
//		logger.info(" @UpdateMode End ");
//		
//        return  queryResult.toJSONString();
//        
//        
//	}
//	
//	
//	
//	/*
//	 * 피 보호자 등록 ( from 보호자 )
//	 * @param user_id 		: 아이디
//	 * @param ward_phone1 	: 피보호자 전화번호 1
//	 * @param ward_phone2 	: 피보호자 전화번호 2
//	 * @param ward_phone3 	: 피보호자 전화번호 3
//	 * @return 성공/실패 ( 1 or 0 )
//	 */
//	@PostMapping("/update/ward")
//	public @ResponseBody String UpdateWard (@RequestBody String body) throws Exception{
//	
//		logger.info(" @UpdateWard Start ");
//		logger.info(" @UpdateWard body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userId",InitSupporter.notNull("user_id", bodyData));
//			param.put("wardPhone1",InitSupporter.notNull("ward_phone1", bodyData));
//			param.put("wardPhone2",InitSupporter.notNull("ward_phone2", bodyData));
//			param.put("wardPhone3",InitSupporter.notNull("ward_phone3", bodyData));
//			
//			userCheckService.findUserById(param);
//			Map<String, Object> encryptedParam = leaTool.EncryptOnlyPrivate(param);
//			logger.info("@UpdateWard sqlparam : "+encryptedParam);
//			queryResult.put("result", protectorService.updateWard(encryptedParam));
//			
//		} 
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//		logger.info(" @UpdateWard Return :  " + queryResult.toJSONString());
//		logger.info(" @UpdateWard End ");		
//     
//		
//        return  queryResult.toJSONString();
//
//        
//	}
//	
//	
//	/*
//	 * 보호자 리스트 검색 
//	 * 피보호자의 phone 번호를 등록한 보호자 리스트
//	 * user_phone번호를 ward_phone 검색 
//	 * @param user_phone 	: 휴대폰 번호
//	 * @return user_name 	: 사용자 이름
//	 * @return user_phone 	: 휴대폰 번호
//	 */
//	@PostMapping("/protect/user")
//	public @ResponseBody String ProtectUser (@RequestBody String body) throws Exception{
//		
//		// 1.1.	User_phone 번호를 ward_phone1 ward_phone2 ward_phne3 를 검색해서 있으면 전송
//		// select user_name,user_phone from tbl_safe_user where ward_phone1 = user_phone  or ward_phone2 =  user_phone or ward_phone3 = user_phone
//		logger.info(" @searchMyProtector Start ");
//		logger.info(" @searchMyProtector body : "+ body);
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		try {
//			String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userPhone",InitSupporter.notNull("user_phone", bodyData));
//			
//			logger.info("@searchMyProtector sqlparam : "+param);
//			Map<String , Object> encryptParam = leaTool.EncryptOnlyPrivate(param);
//			
//			List<Map<String, Object>> decryptList = new ArrayList<>();
//			List<Map<String, Object>> list = wardService.searchMyProtectors(encryptParam);
//			
//			for( Map<String, Object> map : list) {
//				decryptList.add(leaTool.decryptOnlyEncrypted(map));
//			}
//			queryResult.put("result" , decryptList);
//			
//		} 
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//        
//		logger.info(" @searchMyProtector Return :  " + queryResult.toJSONString());
//		logger.info(" @searchMyProtector End ");
//		return  queryResult.toJSONString();
//	}
//	
//	
//	/*
//	 * 자신을 보호자로 등록한 사용자 찾기..
//	 * @param user_protector 	: 보호자이름 + 핸드폰번호
//	 * @return user_key 		: 모바일 키
//	 * @return user_id 			: 아이디
//	 * @return user_name 		: 이름
//	 * @return user_phone 		: 휴대폰 번호
//	 * @return location_flag 	: 위치정보 제공
//	 */
//	//var sql = 'select user_key,user_name,user_id,user_phone from tbl_safe_user where user_protector1 = ? or user_protector2 = ? or user_protector3 = ?';
//	@PostMapping("/monitoring/user")
//	public @ResponseBody String MonitoringUser (@RequestBody String body) throws Exception {
//		
//		logger.info(" @searchMyWard Start ");
//		logger.info(" @searchMyWard body : "+ body);
//
//		JSONObject queryResult  = 	new JSONObject();
//		queryResult.put("result", "fail");
//		
//		try {
//			String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//			JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//			
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("userProtector",InitSupporter.notNull("user_protector", bodyData));
//			
//			logger.info("@searchMyWard sqlparam : "+param.toString());
//			List<Map<String, Object>> decryptList = new ArrayList<>();
//			List<Map<String, Object>> list = protectorService.searchMyWard(leaTool.EncryptOnlyPrivate(param));
//			
//			for( Map<String, Object> map : list) {
//				decryptList.add(leaTool.decryptOnlyEncrypted(map));
//			}
//			queryResult.put("result" , decryptList);
//		}
//		catch (IllegalArgumentException e) {
//			logger.info(e.getMessage());
//		} 
//		catch (Exception e) {
//			logger.info(e.getMessage());
//			if(!e.getMessage().equals("no data")) {
//				e.printStackTrace();
//			}
//		}
//		
//		logger.info(" @searchMyWard Return :  " + queryResult.toJSONString());
//		logger.info(" @searchMyWard End ");
//		
//		return  queryResult.toJSONString();
//		
////		
////		logger.info(" @MonitoringUser Start ");
////		logger.info(" @MonitoringUser body : "+ body);
////		Map<String,Object> resultMap  	   =   	   null;
////		String bodyDecoded        	   =       URLDecoder.decode(body,"UTF-8");
////		JSONObject obj      		   =       (JSONObject) JSONValue.parse(bodyDecoded);
////		
////		String user_protector         =  obj.get("user_protector") == null ? "" : obj.get("user_protector").toString();
////
////        Map<String, Object> param =  new HashMap<String, Object>();
////        param.put("userProtector", 		leaTool.encrypt(user_protector ));
////        logger.info(" @MonitoringUser param :  " + param.toString());
////
////        resultMap = openUserService.searchMyProtector(param);
////        
////		JSONObject returnJSON = new JSONObject(leaTool.decryptOnlyEncrypted(resultMap));
////		logger.info(" @MonitoringUser Return :  " + returnJSON.toJSONString());
////		logger.info(" @MonitoringUser End ");
////		
////		return  returnJSON.toJSONString();
//        
//	}
//	
//	// 2.10 ~ 2.13 기존루틴 사용
//	// 단, api 주소 변경 됨.
//
//
//	 @PostMapping("/uprotect")
//	    public @ResponseBody String updateProtector (@RequestBody String body) throws Exception {
//		 
//			logger.info(" @updateProtector Start ");
//			logger.info(" @updateProtector body : "+ body);
//			
//			JSONObject queryResult  = 	new JSONObject();
//			queryResult.put("result", "fail");
//			
//			try {
//				String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//				JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//				
//				Map<String,Object> param = new HashMap<String,Object>();
//				param.put("userId",InitSupporter.notNull("user_id", bodyData));
//				param.put("userProtector",InitSupporter.notNull("user_protector", bodyData));
//				param.put("locationFlag",InitSupporter.notNull("location_flag", bodyData));
//				param.put("type",InitSupporter.notNull("type", bodyData));
//				
//				logger.info("@updateProtector param : "+param.toString());
//				String type = param.get("type").toString();
//				
//				Map<String,Object>  updateInfo =  null;
//				
//			    if(type.equals("insert")) {
//			    	updateInfo = wardService.makeInsertParam(leaTool.EncryptOnlyPrivate(param));
//				}
//				else if(type.equals("update")) {
//					updateInfo = wardService.makeUpdateParam(leaTool.EncryptOnlyPrivate(param));
//				}
//				else if(type.equals("delete")) {
//					updateInfo = wardService.makeDeleteParam(leaTool.EncryptOnlyPrivate(param));
//				}else {
//					throw new IllegalArgumentException("not allow type");
//				}
//				
//				
//				logger.info("@updateProtector updateInfo : "+updateInfo.toString());
//				queryResult.put("result",wardService.updateMyProtectorList(updateInfo));
//				
//			} 
//			catch (IllegalArgumentException e) {
//				logger.info(e.getMessage());
//			} 
//			catch (Exception e) {
//				logger.info(e.getMessage());
//				if(!e.getMessage().equals("duplicate protector") && !e.getMessage().equals("protector not exist")) {
//					e.printStackTrace();
//				}
//			}
//
//			logger.info(" @updateProtector Return :  " + queryResult.toJSONString());
//			logger.info(" @updateProtector End ");
//		    return  queryResult.toJSONString();
//
//	    }
//	 
//	    @PostMapping("/protect/list/phone")
//		 public @ResponseBody String searchProtectorInfo (@RequestBody String body) throws Exception {
//	    	// 보호자의 디바이스 및 키 검색
//	    	logger.info(" @searchProtectorInfo Start ");
//			logger.info(" @searchProtectorInfo body : "+ body);
//			
//			JSONObject queryResult  = 	new JSONObject();
//			queryResult.put("result", "fail");
//			try {
//					String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//					JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//					
//					Map<String,Object> param = new HashMap<String,Object>();
//					param.put("userPhone",InitSupporter.notNull("user_phone", bodyData));
//					param.put("userName",InitSupporter.notNull("user_name", bodyData));
//
//					Map<String,Object> encryptParam = wardService.searchProtectorInfo(leaTool.EncryptOnlyPrivate(param));
//					queryResult.put("result" , leaTool.decryptOnlyEncrypted(encryptParam));
//					logger.info("@searchMyProtector sqlparam : "+queryResult.getAsString("result"));
//			} 
//			catch (IllegalArgumentException e) {
//					logger.info(e.getMessage());
//			} 
//			catch (Exception e) {
//				logger.info(e.getMessage());
//				if(!e.getMessage().equals("no data")) {
//					e.printStackTrace();
//				}
//			}
//		     
//			  logger.info(" @searchProtectorInfo Return :  " + queryResult.toJSONString());
//			  logger.info(" @searchProtectorInfo End ");
//		      return  queryResult.toJSONString();
//		      
//		  }
//	    
//		
//		/*
//		 * @회원 탈퇴
//		 * @param user_phone : 모바일 키
//		 * @return user_phone . 없으면 fail >> 없으면 success
//		 */
//		@PostMapping("/user/drop")
//		public @ResponseBody String UserDrop (@RequestBody String body) throws Exception{
//			
//			logger.info(" @UserDrop Start ");
//			logger.info(" @UserDrop body : "+ body);
//			JSONObject queryResult  = 	new JSONObject();
//			queryResult.put("result", "fail");
//			try {
//					String decoded 	 = 	URLDecoder.decode(body,"UTF-8");
//					JSONObject bodyData  = 	(JSONObject) JSONValue.parse(decoded);
//					logger.info("@userDrop bodyData : "+bodyData.toString());
//					
//					Map<String,Object> param = new HashMap<String,Object>();
//					param.put("userId",InitSupporter.notNull("user_id", bodyData));
//					param.put("userPwd",InitSupporter.notNull("user_pwd", bodyData));
//					
//					String userPhone = InitSupporter.notNull("user_phone", bodyData);
//					String userName  = InitSupporter.notNull("user_name", bodyData);
//					String userProtector =  userName+" / "+userPhone;
//					param.put("userPhone",userPhone);
//					param.put("userName",userName);
//					param.put("userProtector", userProtector);
//
//					Map<String, Object> encryptedParam = leaTool.EncryptOnlyPrivate(param);
//					userCheckService.findUserToDelete(encryptedParam);
//					queryResult.put("result",userService.userDrop(encryptedParam));
//					//삭제 아이디 부를기
//					//wardService.protectorLineUp(encryptedParam);
//				
//			} 
//			catch (IllegalArgumentException e) {
//				logger.info(e.getMessage());
//			} 
//			catch (Exception e) {
//				logger.info(e.getMessage());
//				if(!e.getMessage().equals("no data")) {
//					e.printStackTrace();
//				}
//			}
//			logger.info(" @UserDrop Return :  " + queryResult.toJSONString());
//			logger.info(" @UserDrop End ");
//			
//	        return  queryResult.toJSONString();
//		}
//		
//
//
//		@PostMapping("/find/user")
//		public @ResponseBody  String FindUserToUpdatePwd (@RequestBody String body) throws Exception{
//			
//			logger.info(" @FindUserToUpdatePwd Start ");
//			logger.info(" @FindUserToUpdatePwd body : "+ body);
//			Map<String, Object> result = null;
//			try {
//				String bodyDecoded        	 =       URLDecoder.decode(body,"UTF-8");
//				JSONObject obj      		 =       (JSONObject) JSONValue.parse(bodyDecoded);
//				
//				if(isNotEmpty("user_key", obj) && isNotEmpty("user_phone", obj) && isNotEmpty("user_name", obj) && isNotEmpty("user_id", obj)) {
//					Map<String,Object> sqlParam = utils.keyCaseChanger("camel",utils.jsonToMap(obj));
//					logger.info(" @FindUserToUpdatePwd sqlParam  :"+ sqlParam.toString() );
//					leaTool.EncryptOnlyPrivate(sqlParam);
//					result = openUserService.findUserToUpdatePwd(sqlParam);
//				}
//			} catch (Exception e) {
//				logger.info("openUserService.FindUserToUpdatePwd >> " + e.getMessage());
//			}
//			
//			JSONObject returnJSON = new JSONObject(result);
//			logger.info(" @FindUserToUpdatePwd Return :  " + returnJSON.toJSONString());
//			logger.info(" @FindUserToUpdatePwd End ");
//			
//			return  returnJSON.toJSONString();
//		}
//		
//		@PostMapping("/update/pwd")
//		public @ResponseBody  String updatePwd (@RequestBody String body) throws Exception{
//			
//			logger.info(" @updatePwd Start ");
//			logger.info(" @updatePwd body : "+ body);
//			Map<String, Object> result = null;
//			try {
//				String bodyDecoded        	 =       URLDecoder.decode(body,"UTF-8");
//				JSONObject obj      		 =       (JSONObject) JSONValue.parse(bodyDecoded);
//				
//				if(isNotEmpty("user_id", obj) && isNotEmpty("user_pwd", obj)) {
//					Map<String,Object> sqlParam = utils.keyCaseChanger("camel",utils.jsonToMap(obj));
//					logger.info(" @updatePwd sqlParam  :"+ sqlParam.toString() );
//					result = openUserService.updatePwd(sqlParam);
//				}
//			} catch (Exception e) {
//				logger.info("openUserService.updatePwd >> " + e.getMessage());
//			}
//			
//			JSONObject returnJSON = new JSONObject(result);
//			logger.info(" @updatePwd Return :  " + returnJSON.toJSONString());
//			logger.info(" @updatePwd End ");
//			
//			return  returnJSON.toJSONString();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		public Boolean isNotEmpty(String key, JSONObject obj)  {
//			if(obj.get(key)  == null) {
//				throw new IllegalArgumentException(key+"의 값은 null이거나 공백일 수 없습니다.");
//			}
//			 if(obj.get(key).toString().equals("")) {
//				 throw new IllegalArgumentException(key+"의 값은 null이거나 공백일 수 없습니다.");
//			}
//			 return true;
//		}
//		
//		
//		
//		
//	    
	 
}

