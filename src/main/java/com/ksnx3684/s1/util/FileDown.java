package com.ksnx3684.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.ksnx3684.s1.file.FileDTO;

@Component
public class FileDown extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub.
		System.out.println("filedown start");
		
		FileDTO fileDTO = (FileDTO)model.get("file");
		System.out.println(fileDTO.getFileName());
		System.out.println(fileDTO.getOriName());
		
		String board = (String)model.get("board");
		
		String path = "/resources/upload/" + board + "/";
		
		// 내장 객체는 다른 영역의 내장 객체를 불러올 수 있다
		// 단, 좁은 영역에서 큰 영역으로는 가능하나 그 반대는 불가능
		// page -> request -> session -> application(ServletContext)
		// getRealPath메서드는 application이 가지고 있음
		// 매개변수에 request가 있음
		ServletContext sc = request.getSession().getServletContext();
		
		path = sc.getRealPath(path);
		
		File file = new File(path, fileDTO.getFileName());
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		
		// Encoding 처리
		response.setCharacterEncoding("UTF-8");
		
		// 총 파일의 크기
		response.setContentLength((int)file.length());
		
		// 다운 시 파일의 이름을 인코딩
		String fileName = URLEncoder.encode(fileDTO.getOriName(), "UTF-8");
		
		// Haeder 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 로컬 디스크에서 파일을 읽어서 클라이언트로 전송 연결 준비
		FileInputStream f1 = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		// 최종 전송
		FileCopyUtils.copy(f1, os);
		
		// 연결 끊기
		os.close();
		f1.close();
		
	}
}
