package org.tang.springboot.mail.test;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.misusing.FriendlyReminderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   测试邮件的发送
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailSender {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration configuration;	
	/**
	 * 测试简单的邮件
	 */
	@Test
	public void mailSender() {
		logger.info("开始准备要发送的邮件...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tangxing@gpowersoft.com");
		message.setTo("tangxingvip@sohu.com");
		message.setSubject("项目有问题，请查看原因");
		message.setText("详情请查看附件！");
		sender.send(message);
		logger.info("邮件发送成功！");
	}
	
	/**
	 * 测试带附件的邮件
	 */
	@Test
	public void mailAttachmentSender() throws Exception{
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
		message.setFrom("tangxing@gpowersoft.com");
		message.setTo("673356842@qq.com");
		message.setSubject("贵公司产品检测出漏洞，请修复！！！");
		message.setText("详细信息，请查看附件");
		FileSystemResource file = new FileSystemResource(new File(this.getClass().getClassLoader().getResource("1.jpg").getPath()));
		message.addAttachment("附件-1.jpg", file);
		message.addAttachment("附件-2.jpg", file);
		sender.send(mimeMessage);
	}
	
	/**
	 * 测试嵌入静态资源
	 * @throws Exception
	 */
	@Test
	public void mailStaticResourceSender()throws Exception {
		long start = System.currentTimeMillis();
		logger.info("开始准备静态资源邮件...");
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("tangxing@gpowersoft.com");
		helper.setTo("673356842@qq.com");
		helper.setSubject("使用静态资源");
		helper.setText("<html><body><img src='cid:test'/></body></html>", true);
		FileSystemResource file = new FileSystemResource(this.getClass().getClassLoader().getResource("1.jpg").getPath());
		helper.addInline("test", file);
		sender.send(mimeMessage);
		long end = System.currentTimeMillis();
		logger.info("静态邮件发送成功,耗时{}s",(end-start)/1000);
	}
	
	/**
	 * 发送模版邮件
	 */
	@Test
	public void templateMailSender() throws Exception{
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("tangxing@gpowersoft.com");
		helper.setTo("673356842@qq.com");
		helper.setSubject("使用FreeMarker模版处理邮件");
		Template template = configuration.getTemplate("mail.html");
		String text = template.toString();
		logger.info(text);
		helper.setText(text,true);
		sender.send(mimeMessage);
	}
	
}
