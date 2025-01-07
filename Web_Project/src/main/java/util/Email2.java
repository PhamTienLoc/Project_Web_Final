package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email2 {
	// ltphat240103@gmail.com
	// quhxgastoodjtdzh : mật khẩu ứng dụng nha quên thì cứ bấm mật
	// khẩu ứng dụng của gmail là gì là được nha
	
	static final String from = "ltphat240103@gmail.com";
	static final String password = "quhxgastoodjtdzh";

	public static boolean sendEmail(String to,String tieuDe ,String noiDung) {
		// Properties : khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// create Authenticator

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}

		};
		// Phiên làm việc

		Session session = Session.getInstance(props, auth);
		// Tạo một tin nhắn mới
		MimeMessage msg = new MimeMessage(session);

		try {
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			// Người gửi
			msg.setFrom(from);
			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Tiêu đề email
			msg.setSubject(tieuDe);

			// Quy định ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hổi
			 msg.setReplyTo(new Address[] {new InternetAddress("21129858@st.hcmuaf.edu.vn")});

			// Nội dung
//				msg.setText("<html><body><table border='1'>"
//						+ "<tr><td>Họ và tên</td> <td>Phat IT</td></tr>"
//						+ "</table></body></html>","UTF-8");

//			msg.setContent(
//					"<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Page Title</title>\r\n"
//							+ "</head>\r\n" + "<body>\r\n" + "\r\n" + "<h1>This is a Heading</h1>\r\n"
//							+ "<p>This is a paragraph.</p>\r\n" + "\r\n"
//							+ "<img src=\"pic_trulli.jpg\" alt=\"Italian Trulli\"> " + "</body>\r\n" + "</html>",
//					"text/html");

			msg.setContent(noiDung, "text/HTML; charset=UTF-8");

			Transport.send(msg);
			return true;

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Email2.sendEmail("22130188@st.hcmuaf.edu.vn",System.currentTimeMillis()+"","Đây là phần nội dung");
		}
		
	}
}
