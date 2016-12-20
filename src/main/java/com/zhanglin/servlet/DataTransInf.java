package com.zhanglin.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataTransInf extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6666457543775384350L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String acceptjson = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) req.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			acceptjson = sb.toString();
			System.out.println(acceptjson);
			/*
			if (acceptjson != "") {
				JSONObject jo = JSONObject.fromObject(acceptjson);
				JSONArray imgArray = jo.getJSONArray("PartsImages");
				JSONArray infArray = jo.getJSONArray("BasicInfo");
				for (int i = 0; i < imgArray.size(); i++) {
					JSONObject imgObject = JSONObject.fromObject(imgArray
							.get(i));
					System.out.println(imgObject.get("PartsImg"));
				}
				JSONObject infObject = JSONObject.fromObject(infArray.get(0));
				System.out.println(infObject.get("Parts_cate"));
				System.out.println(infObject.get("Company"));
				System.out.println(infObject.get("Parts_name"));
				System.out.println(infObject.get("TEL"));
				System.out.println(infObject.get("Parts_price"));
				System.out.println(infObject.get("Suitable"));
				System.out.println(infObject.get("UsedStyle"));
				System.out.println(infObject.get("Supplement"));
				System.out.println(jo.toString());
			}
			response.getWriter().write(MyReadFile.read("/post/publishsuccess"));
			*/
		} catch (Exception e) {
			e.printStackTrace();
//			response.getWriter().write(MyReadFile.read("/post/publishfailure"));
		}
	}
}
