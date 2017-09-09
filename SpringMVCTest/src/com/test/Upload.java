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
		//如果文件不为空，写入上传路径
		if(!file.isEmpty()){
			//上传文件路径
			String path=request.getRealPath("WEB-INF/file");
			logger.info(path);
			//上传文件名
			String filename=file.getOriginalFilename();
			logger.info(filename);
			File filepath=new File(path,filename);
			logger.info(filepath);
			//判断路径是否存在，不存在则创建
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件中,其中File.separator是为了防止Windows和Linux下路径斜杠的区别
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
		//下载路径
		String path=request.getRealPath("WEB-INF/file");
		//完整的路径包括下载文件的名称
		File file=new File(path+File.separator+filename);
		HttpHeaders headers=new HttpHeaders();
		//解决下载文件中文乱码问题
		String downloadFileName=new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//通知游览器以attachment(下载方式)打开文件
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream:二进制流数据，最常见的文件下载
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}

}
