package cn.ly.srms.common.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author 传智.郭嘉
 * qq邮箱连不上服务器，不能用作发送的邮箱
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		/*props.setProperty("mail.host", "localhost");*/
		/*props.put("mail.smtp.host", "mail.qq.com");*/
		props.setProperty("mail.host", "mail.cufs.com.cn");
		  props.put("mail.smtp.auth", "true"); //true一定要加引号
		//props.setProperty("mail.port", 465);
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("liuyi3@cufs.com.cn", "Admin124");
/*				return new PasswordAuthentication("1131154693@qq.com", "trnicalfbopchjaf");
*/			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("liuyi3@cufs.com.cn"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("来自购物天堂传智商城官方激活邮件");
			// 设置邮件正文:
			message.setContent("<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.36.103:8080/shop/user_active.action?code="+code+"'>http://192.168.36.103:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("1271723221@qq.com","1111");
		System.out.println("发送成功");
	}
}
