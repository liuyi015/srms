/*
 * 文件名：UserModel.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserModel.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package cn.ly.srms.entity.model;

import java.io.File;

import cn.ly.srms.entity.User;

/**
 * TODO添加类描述
 * @author     liuyi 1610140
 * @version    srms 2017年8月25日
 * @since      srms
 */
public class UserModel extends User {
	private File img;
	private String imgFileName;
	private String imgContentType;
	
	
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	
	

}

