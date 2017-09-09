package com.test;


import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Upload {
	
	private static final Log logger=LogFactory.getLog(Upload.class);
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@RequestParam("description")String description,
			@RequestParam("file")MultipartFile file,HttpServletRequest request,Model model)throws Exception{
		System.out.println(description);
		//����ļ���Ϊ�գ�д���ϴ�·��
		if(!file.isEmpty()){
			//�ϴ��ļ�·��
			String path=request.getRealPath("WEB-INF/file");
			logger.info(path);
			//�ϴ��ļ���
			String filename=file.getOriginalFilename();
			logger.info(filename);
			File filepath=new File(path,filename);
			logger.info(filepath);
			//�ж�·���Ƿ���ڣ��������򴴽�
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//���ϴ��ļ����浽һ��Ŀ���ļ���,����File.separator��Ϊ�˷�ֹWindows��Linux��·��б�ܵ�����
			file.transferTo(new File(path+File.separator+filename));
			model.addAttribute("filename", filename);
			
			return "filesuccess";
		}else{
			return "error";
		}
		
	}
	@RequestMapping(value="download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename
			,Model model) throws Exception{
		//����·��
		String path=request.getRealPath("WEB-INF/file");
		//������·�����������ļ�������
		File file=new File(path+File.separator+filename);
		HttpHeaders headers=new HttpHeaders();
		//��������ļ�������������
		String downloadFileName=new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//֪ͨ��������attachment(���ط�ʽ)���ļ�
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream:�����������ݣ�������ļ�����
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}

}
